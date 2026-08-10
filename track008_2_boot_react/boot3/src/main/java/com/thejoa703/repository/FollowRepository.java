package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long>{

	// 팔로우 단건조회 - 팔로잉/팔로워
	Optional<Follow>	findByFollower_IdAndFollowee_Id(Long followerId, Long followeeId);
	
	// 팔로잉 목록 조회		→ AppUser(엔티티) follower(필드)	id 찾기
	// 1) 쿼리1개		: findByFollower_Id(1L) 팔로잉 목록 10명		1
	// 2) 추가쿼리10개	: 각각의 정보를 가져오려면 쿼리 10번 더				N	(11번의 쿼리)	→	11번의 쿼리실행 x
	// -----------------
	// 3) @EntityGraph(attributePaths = {"followee"})			쿼리실행할 때 Followee 데이터까지 한꺼번에 조회
	@EntityGraph(attributePaths = {"followee"})
	List<Follow> findByFollower_Id(Long followerId);
	
	// 팔로워 목록 조회		→ AppUser(엔티티) followee(필드)	id 찾기
	@EntityGraph(attributePaths = {"follower"})
	List<Follow> findByFollowee_Id(Long followeeId);
	
	// 팔로잉 수 집계		→ AppUser(엔티티) follower(필드)	id 찾기
	long countByFollower_Id(Long followerId);
	
	// 팔로워 수 집계		→ AppUser(엔티티) followee(필드)	id 찾기
	long countByFollowee_Id(Long followeeId);
}
