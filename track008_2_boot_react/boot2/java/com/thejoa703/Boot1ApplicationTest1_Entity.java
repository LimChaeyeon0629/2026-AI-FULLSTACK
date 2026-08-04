package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.PostRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional		// 테스트 완료 후 데이터 자동롤백
class Boot1ApplicationTest1_Entity {

	@Autowired AppUserRepository appUserRepository;
	@Autowired PostRepository postRepository;
	
	private AppUser savedUser;
	private Post savedPost;
	// insert, update(save),	select(findBy필드명),		delete(deletedById)
	// ====================================
	// 1. CREATE (생성테스트)
	// ====================================
//	@Test
	@BeforeEach
	void createTest() {
		// AppUser	공통으로 사용할 테스트용 회원
		AppUser user = AppUser.builder()
				.email("z@z")
				.password("z")
				.nickname("first")
				.provider("local")
				.build();
		
		savedUser = appUserRepository.save(user);

		// Post		공통으로 사용할 테스트용 게시글
		Post post = new Post();
		post.setContent("CRUD 테스트용 게시글 내용입니다.");
		post.setUser(savedUser);
		
		savedPost = postRepository.save(post);
	}
	
	@Test
	@DisplayName("1. CREATE 생성테스트 (save)")
	void testCreate() {
		assertThat(savedUser.getId()).isNotNull();
		assertThat(savedPost.getId()).isNotNull();
	}

	@Test
	@DisplayName("2. READ 생성테스트 (findBy)")
	void testRead() {
		Optional<AppUser> foundUser = appUserRepository.findById( savedUser.getId() );
		assertThat(foundUser).isPresent();	// 유저있으면 true, false
		assertThat(foundUser.get().getNickname()).isEqualTo("first");
		
		Optional<AppUser> foundEmail = appUserRepository.findByEmail("z@z");
		assertThat(foundEmail).isPresent();	// 유저있으면 true, false
		assertThat(foundEmail.get().getEmail()).isEqualTo("z@z");
		
		savedPost.setDeleted(true);		// 안 비어있으면 논리삭제 delete
		
		List<Post> posts = postRepository.findByDeletedFalse();
		assertThat(posts).isEmpty();	// 비어있는지 안비어있는지 확인
	}
	
	@Test
	@DisplayName("3. UPDATE 생성테스트 (save)")
	void testUpdate() {
		savedUser.setNickname("zero");
		appUserRepository.save(savedUser);
		
		savedPost.setContent("new...... 20260727");
		postRepository.save(savedPost);
		
		AppUser updateUser = appUserRepository.findById( savedUser.getId() ).get();
		Post updatePost = postRepository.findById( savedPost.getId() ).get();
		
		assertThat(updateUser.getNickname()).isEqualTo("zero");
		assertThat(updatePost.getContent()).isEqualTo("new...... 20260727");
	}
	
	@Test
	@DisplayName("4. Delete 테스트 (delete)")
	void testDelete() {
		appUserRepository.delete(savedUser);
		postRepository.delete(savedPost);
		
		Optional<AppUser> deletedUser = appUserRepository.findById( savedUser.getId() );
		Optional<Post> deletedPost = postRepository.findById( savedPost.getId() );
		
		assertThat(deletedUser).isEmpty();
		assertThat(deletedPost).isEmpty();
	}
}


// jpa : save(insert, update) / delete(delete) / findBy필드명(select)