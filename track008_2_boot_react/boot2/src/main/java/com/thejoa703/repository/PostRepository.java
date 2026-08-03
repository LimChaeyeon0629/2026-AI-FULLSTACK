package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Post;

@Repository										// Entity, PK-자료형
public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByDeletedFalse();	// List<Post>		결과가 여러 개일 때	: List
										// Optional<Post>	결과가 한 개일 때	: Optional
	
	// 오라클 네이티브페이징조회
	// 비교 - 결과값이 1개거나 없을 때(null) - Optional 사용
	// Optional<AppUser> findByEmail(String email);
	@Query(value =	"SELECT * FROM ( " +
            		"SELECT p.*, ROWNUM AS rnum " +
            		"FROM (SELECT * FROM POSTS WHERE DELETED = 0 ORDER BY CREATED_AT DESC) p " + 
            		") " +
            		"WHERE rnum BETWEEN :start AND :end",
            		nativeQuery=true
    )
	
	List<Post> findPostsWithPaging(	@Param("start") int start,
									@Param("end") int end); 
}

/*	(1) 사용할 수 있는 기본 SQL
		1. create	:	save		- insert into posts (컬럼1, 컬럼2,,,) values (?, ?,,,)
		2. read		:	findAll		- select * from posts
						findById	- select * from posts where id=?
		3. update	:	save		- update posts set 컬럼1=? where id=?
		4. delete	:	deleteById	- delete from posts where id=?

	(2) 삭제 안 된 게시글 찾기 findBy필드명
		findBy

	(3) 복잡한 sql - @Query
*/