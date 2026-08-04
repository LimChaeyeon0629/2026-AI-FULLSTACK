package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thejoa703.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	// 기본키처럼 결과가 한 개면				Optional<Comment>
	// 조건에 맞는 결과가 여러 개일 수 있으면		List<Comment>
	
	// 특정 게시글에 남아 있는 삭제되지 않은 댓글 전체 개수
	// @ManyToOne - (comment 입장에서) post가 1개여서 join 쿼리를 만들어줌
	// findBy	조건1		AND		조건2
	// SELECT c		FROM Comments c		WHERE c.post.id = :postId		AND c.deleted = false
	List<Comment>	findByPostIdAndDeletedFalse(Long postId);
	
	// 삭제되지 않은 댓글 수 집계
	// SELECT COUNT(c.id)	FROM Comments c		WHERE c.post.id = :postId		AND c.deleted = false
	long			countByPostIdAndDeletedFalse(Long postId);
}

/*
1. findBy조건명	조회			+	And
2. countBy		갯수			+	Or
3. existsBy		존재여부		+	엔티티안에 다른엔티티		Post엔티티안에 Long Id
4. deleteBy
*/

/*
create	- save		: insert
read	- findAll	: select * from 테이블명
		  findById	: select * from 테이블명 where id=?
update	- save		: update 테이블명 set 컬럼1=? ,,, where id=?
delete	- delete	: delete from 테이블명 where id=?
*/