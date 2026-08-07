package com.thejoa703.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.PostDto.PostRequestDto;
import com.thejoa703.dto.PostDto.PostResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Hashtag;
import com.thejoa703.entity.Image;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.HashtagRepository;
import com.thejoa703.repository.PostRepository;
import com.thejoa703.util.FileStorageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)		// import spring
public class PostService {
	
	private final AppUserRepository		appUserRepository;
	private final PostRepository		postRepository;
	private final HashtagRepository		hashtagRepository;	// 해시태그
	private final FileStorageService	fileStorageService;	// 이미지 업로드처리
	
	// 1. 전체게시글조회
	public List<Post> getAllPost() {
		return postRepository.findByDeletedFalse();
	}
	
	// 2. 단건조회
	public Post getPostById(Long id) {	// Optional 붙어있으면 1개 or null
		Post post = postRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("단건조회 오류! 존재하지 않는 게시글!" + id));
		
		if(post.isDeleted()) {	// 논리삭제
			throw new IllegalArgumentException("삭제된 게시글!");
		}
		return post;
	}
	
	// 3. 오라클 네이티브페이징조회
	public List<Post> getPostPaged(int start, int end) {
		return postRepository.findPostsWithPaging(start, end);
	}
	
	// 4. 게시글생성 (save + 해시태그 + 이미지업로드)
	@Transactional	// appUserRepository, postRepository 2개. 하나라도 틀리면 rollback
	public PostResponseDto createPost(Long userId, PostRequestDto dto, List<MultipartFile> files) {
		AppUser user = appUserRepository.findById(userId)
				.orElseThrow(()-> new IllegalArgumentException("존재하지 않는 사용자! ID: " + userId));
		
		Post post = new Post();
		post.setUser(user);
		post.setContent( dto.getContent() );
		
		// 이미지업로드
		if(files != null && !files.isEmpty()) {
			files.forEach( file-> {
				String url = fileStorageService.upload(file);
				Image image = new Image();
				image.setSrc(url);
				image.setPost(post);
				
				post.getImages().add(image);
			});
		}
		
		// 해시태그 (1. 겹치면 안됨		2. #해시	#first #태그)
		if(dto.getHashtags() != null && !dto.getHashtags().isEmpty()) {
			post.getHashtags().clear();		// 기존에 들어가있던 해시태그 clear
			Set<String> distinctTags = Arrays.stream( dto.getHashtags().split(","))	// 1. ,기준으로 분리해서 배열을 스트림
					.map(String::trim)	// 2. 공백빼기
					.filter(s -> !s.isEmpty())	// 3. 빈거 아닌애들
					.collect(Collectors.toSet());	// 4 .콜렉션프레임워크, 겹치는 값이 있으면 안됨
		
			// 1. 코드읽기 시도,		2. ai 이용해서 분석
			distinctTags.forEach(tagStr -> {
                String normalized = tagStr.startsWith("#") ? tagStr.substring(1) : tagStr;	// # 기호제거
                Hashtag tag = hashtagRepository.findByName(normalized)	// 기존에 등록된 태그인지 먼저 확인
                        .orElseGet(() -> {	// 존재하지 않으면
                            Hashtag newTag = new Hashtag();			// 새로운 해시태그 만들고
                            newTag.setName(normalized);				// 이름 셋팅
                            return hashtagRepository.save(newTag);	// db 저장
                        });
                post.getHashtags().add(tag);	// 해시태그 객체(리스트)에 저장
            });
		}
		
		return PostResponseDto.from( postRepository.save(post) );	// PostResponseDto
	}
	
	// 5. 게시글수정 (save 안쓰고 update 쿼리 반영)
	@Transactional	// postRepository 틀리면 rollback
	public PostResponseDto updatePost(Long userId, Long postId, PostRequestDto dto, List<MultipartFile> files) {
		Post post = postRepository.findById(postId)
				.orElseThrow(()-> new IllegalArgumentException("게시글수정(단건조회) 오류! 존재하지 않는 게시글! postId: " + postId));
		
//		if(post.isDeleted()) { new IllegalArgumentException("삭제된 게시글!"); }
		if(!post.getUser().getId().equals(userId)) {
			throw new IllegalArgumentException("본인 글만 수정할 수 있습니다.");
		}
		post.setContent( dto.getContent() );	// 저장메서드를 따로 호출하지 않아도 update 쿼리 반영
		
		// 이미지업로드
		if(files != null && !files.isEmpty()) {
			files.forEach( file-> {
				String url = fileStorageService.upload(file);
				Image image = new Image();
				image.setSrc(url);
				image.setPost(post);
				
				post.getImages().add(image);
			});
		}
		
		// 해시태그 (1. 겹치면 안됨		2. #해시	#first #태그)
		if(dto.getHashtags() != null && !dto.getHashtags().isEmpty()) {
			Set<String> distinctTags = Arrays.stream( dto.getHashtags().split(","))	// 1. ,기준으로 분리해서 배열을 스트림
					.map(String::trim)	// 2. 공백빼기
					.filter(s -> !s.isEmpty())	// 3. 빈거 아닌애들
					.collect(Collectors.toSet());	// 4 .콜렉션프레임워크, 겹치는 값이 있으면 안됨
		
			// 1. 코드읽기 시도,		2. ai 이용해서 분석
			distinctTags.forEach(tagStr -> {
                String normalized = tagStr.startsWith("#") ? tagStr.substring(1) : tagStr;	// # 기호제거
                Hashtag tag = hashtagRepository.findByName(normalized)	// 기존에 등록된 태그인지 먼저 확인
                        .orElseGet(() -> {	// 존재하지 않으면
                            Hashtag newTag = new Hashtag();			// 새로운 해시태그 만들고
                            newTag.setName(normalized);				// 이름 셋팅
                            return hashtagRepository.save(newTag);	// db 저장
                        });
                post.getHashtags().add(tag);	// 해시태그 객체(리스트)에 저장
            });
		}
	
		return PostResponseDto.from( postRepository.save(post) );	// PostResponseDto
	}
	
	// 6. 게시글삭제 (delete)
	@Transactional	// postRepository 틀리면 rollback
	public void deletePost(Long postId) {
		Post post = postRepository.findById(postId)
				.orElseThrow(()-> new IllegalArgumentException("게시글삭제(단건조회) 오류! 존재하지 않는 게시글! postId: " + postId));
		
//		postRepository.delete(post);	// 물리삭제
		post.setDeleted(true);			// 논리삭제 - 저장메서드를 따로 호출하지 않아도 delete 쿼리 반영
										// save. 써도 되나 메모리 낭비... ...
	}
}

/*	@Transactional(readOnly = true)		더티체킹
	
더티 체킹(Dirty Checking)은 JPA에서 트랜잭션이 끝나는 시점에 조회했던 엔티티의 값이 변경되었다면,
별도의 save()나 update() 쿼리 없이 알아서 데이터베이스에 UPDATE 쿼리를 날려주는 기능입니다.

동작 방식  
1. postRepository.findById(postId)로 엔티티를 조회하면, JPA는 이 시점의 최초 상태를 스냅샷으로 만들어 영속성 컨텍스트에 저장합니다.
2. post.setContent(content)로 엔티티의 값을 수정합니다.
3. 메서드가 정상 종료되어 @Transactional 트랜잭션이 커밋될 때, JPA는 최초 스냅샷과 현재 엔티티의 상태를 비교(체킹)합니다.
4. 값이 다르면 변경된 부분을 감지하고 자동으로 UPDATE 쿼리를 생성해서 데이터베이스에 반영합니다.
*/