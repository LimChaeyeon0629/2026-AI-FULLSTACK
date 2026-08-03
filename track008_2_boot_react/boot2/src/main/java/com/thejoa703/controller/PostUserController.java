package com.thejoa703.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thejoa703.dto.PostDto.PostRequestDto;
import com.thejoa703.dto.PostDto.PostResponseDto;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.PostRepository;
import com.thejoa703.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Posts Api", description = "게시판 관련 API")	// swagger test tag name
@RestController											// @Controller + @ResponseBody	(객체형식)
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class PostUserController {

    private final PostRepository postRepository;
	
	private final PostService postService;

	// 게시글 단건조회
	@Operation(summary = "게시글 단건조회", description = "게시글을 조회합니다.")
	@GetMapping("/{id}")
	public ResponseEntity<PostResponseDto> selectPost(@PathVariable("id") Long id) {
		
		Post post = postService.getPostById(id);
		return ResponseEntity.ok( new PostResponseDto(post) );	// 200
	}
	
	// 게시글 수정		-	수정 put(전체데이터 수정), patch(데이터 일부수정)
	@Operation(summary = "게시글 수정", description = "게시글을 수정합니다.")
	@PutMapping("/{id}")
	public ResponseEntity<PostResponseDto> updatePost(	@PathVariable("id") Long id,
														@RequestBody PostRequestDto requestDto ) {
		
		Post updatePost = postService.updatePost(id, requestDto.getContent());
		return ResponseEntity.ok( new PostResponseDto(updatePost) );
	}
//	@Operation(summary = "게시글 수정", description = "게시글을 수정합니다.")
//	@PutMapping("/{id}")
//	public ResponseEntity<PostResponseDto> updatePost( @RequestBody PostRequestDto requestDto ) {
//		
//		Post updatePost = postService.updatePost(requestDto.getUserId(), requestDto.getContent());
//		return ResponseEntity.ok( new PostResponseDto(updatePost) );
//	}
	
	// 게시글 삭제
	@Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deletePost( @PathVariable("id") Long id ) {

		postService.deletePost(id);
		return ResponseEntity.ok(id);
	}
//	@Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
//	@DeleteMapping("/{id}")
//	public ResponseEntity<PostResponseDto> deletePost( @RequestBody PostRequestDto requestDto ) {
//		Post deletePost = postService.deletePost(requestDto.getUserId());
//		return deletePost;
//	}
	
	// 전체 게시글 조회
	@Operation(summary = "전체 게시글 조회", description = "전체 게시글을 조회합니다.")
	@GetMapping
	public ResponseEntity<List<PostResponseDto>> getAllPost() {
		
		List<Post> posts = postService.getAllPost();
		List<PostResponseDto> lists = posts.stream()
											.map(PostResponseDto::new)
											.collect(Collectors.toList());
		return ResponseEntity.ok(lists);	// 성공 200
	}
//	@Operation(summary = "전체 게시글 조회", description = "전체 게시글을 조회합니다.")
//	@GetMapping
//	public List<Post> selectAllPost() {
//		List<Post> allPosts = postService.getAllPost();
//		return ResponseEntity.ok(posts);
//	}

	// 게시글 작성
	@Operation(summary = "게시글 작성", description = "게시글을 작성합니다.")
	@PostMapping
//	post로 내보내게 되면 password 같은 기능도 같이 나감 꼭 PostResponseDto로 필요한 기능만 내보내기 ... ...
//	public ResponseEntity<Post> createPost( @RequestBody PostRequestDto requestDto ) {		(X)
	public ResponseEntity<PostResponseDto> createPost( @RequestBody PostRequestDto requestDto ) {
		
		Post createdPost = postService.createPost(requestDto.getUserId(), requestDto.getContent());
		return ResponseEntity.ok( new PostResponseDto(createdPost));	// 성공 200
	}

}

//2. Post API     - 게시글 관련 API
//- GET     /api/posts/{id}   게시글 단건 조회   ※ getPostById
//- PUT     /api/posts/{id}   게시글 수정       ※ updatePost
//- DELETE  /api/posts/{id}   게시글 삭제       ※ deletePost
//- GET     /api/posts        전체 게시글 조회   ※ getAllPosts, getPostPaged
//- POST    /api/posts        게시글 작성       ※ createPost

// (mapping) 수정 put(전체데이터 수정), patch(데이터 일부수정)