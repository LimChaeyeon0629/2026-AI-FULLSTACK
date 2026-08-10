package com.thejoa703.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.PostDto.PostRequestDto;
import com.thejoa703.dto.PostDto.PostResponseDto;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.PostRepository;
import com.thejoa703.service.AuthUserJwtService;
import com.thejoa703.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Posts Api", description = "게시판 관련 API")	// swagger test tag name
@RestController											// @Controller + @ResponseBody	(객체형식)
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;
	private final PostService postService;
	private final AuthUserJwtService authUserJwtService;	// ###
	
	// 게시글 작성
//	post로 내보내게 되면 password 같은 기능도 같이 나감 꼭 PostResponseDto로 필요한 기능만 내보내기 ... ...
//	public ResponseEntity<Post> createPost( @RequestBody PostRequestDto requestDto ) {		(X)
	@Operation(summary = "게시글 작성", description = "특정유저 ID와 내용을 받아 게시글을 작성합니다.")
	@PostMapping( consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
	public ResponseEntity<PostResponseDto> createPost(
			Authentication	authentication,
			@Parameter(description = "작성자 사용자 ID") @RequestParam("userId") Long userId,
			@ModelAttribute PostRequestDto dto,						// multipart/form-data
			@Parameter(description = "업로드할 이미지 파일 리스트")		// swagger
				@RequestPart(name="files", required=false) List<MultipartFile> files
	) {
		return ResponseEntity.ok( postService.createPost(userId, dto, files));	// 성공 200
	}

	// 게시글 단건조회
	@Operation(summary = "게시글 단건조회", description = "게시글을 조회합니다.")
	@GetMapping("/{id}")
	public ResponseEntity<PostResponseDto> selectPost(@PathVariable("id") Long id) {
		
		Post post = postService.getPostById(id);
		return ResponseEntity.ok( new PostResponseDto(post) );	// 200
	}
	
	// 게시글 수정		-	수정 put(전체데이터 수정), patch(데이터 일부수정)
	@Operation(summary = "게시글 수정", description = "userId와 postId를 받아와서 게시글을 수정합니다.")
	// Put 리소스 전체교체 / Patch 부분수정
	@PatchMapping(value = "/{postId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )	
	public ResponseEntity<PostResponseDto> updatePost(
			Authentication	authentication,
			// 파라미터로 받겠다 하면 @RequestParam
//			@Parameter(description = "작성자 사용자 ID") @RequestParam("userId") Long userId,
			// 주소표시창 안에 있으면 @PathVariable
			@Parameter(description = "수정할 게시글 ID") @PathVariable(name = "postId") Long postId,
			// 게시글내용 + 댓글
			@ModelAttribute PostRequestDto requestDto,
			//
			@Parameter(description = "수정 시 업로드할 이미지 파일 리스트")
				@RequestPart(name = "files", required = false) List<MultipartFile> files
	) {
//		Post updatePost = postService.updatePost(id, requestDto.getContent() );
//		return ResponseEntity.ok( new PostResponseDto(updatePost) );
		Long userId =  authUserJwtService.getCurrentUserId(authentication);
		return ResponseEntity.ok( postService.updatePost(userId, postId, requestDto, files) );
	}
	
	// 게시글 삭제
	@Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deletePost( Authentication	authentication, @PathVariable("id") Long id ) {
		
		Long userId =  authUserJwtService.getCurrentUserId(authentication);
		postService.deletePost(userId, id);
		return ResponseEntity.ok(id);
	}
	
	// 전체 게시글 조회
	@Operation(summary = "전체 게시글 조회", description = "전체 게시글을 조회합니다.")
	@GetMapping
	public ResponseEntity<List<PostResponseDto>> getAllPost() {
		return ResponseEntity.ok( postService.getAllPost() );
	}
//	@Operation(summary = "전체 게시글 조회", description = "전체 게시글을 조회합니다.")
//	@GetMapping
//	public ResponseEntity<List<PostResponseDto>> getAllPost() {
//		
//		List<Post> posts = postService.getAllPost();
//		List<PostResponseDto> lists = posts.stream()
//				.map(PostResponseDto::new)
//				.collect(Collectors.toList());
//		return ResponseEntity.ok(lists);	// 성공 200
//	}

	

}

//2. Post API     - 게시글 관련 API
//- GET     /api/posts/{id}   게시글 단건 조회   ※ getPostById
//- PUT     /api/posts/{id}   게시글 수정       ※ updatePost
//- DELETE  /api/posts/{id}   게시글 삭제       ※ deletePost
//- GET     /api/posts        전체 게시글 조회   ※ getAllPosts, getPostPaged
//- POST    /api/posts        게시글 작성       ※ createPost

// (mapping) 수정 put(전체데이터 수정), patch(데이터 일부수정)