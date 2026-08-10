package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
		name = "FOLLOWS",
		uniqueConstraints = @UniqueConstraint(columnNames = {"FOLLOWER_ID", "FOLLOWEE_ID"})
)
@Getter @Setter @NoArgsConstructor
public class Follow {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follow_seq")
	@SequenceGenerator(name = "follow_seq", sequenceName = "FOLLOW_SEQ", allocationSize = 1)
	Long Id;
	
	@Column(name = "CREATED_AT", nullable = false)
	LocalDateTime createdAt;
	
	@PrePersist
	void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)	// 1. 연관된 엔티티(AppUser) 당장 가져오는 게 아니고
	@JoinColumn(name = "FOLLOWER_ID", nullable = false)
	AppUser follower;	// @ManyToOne	보는사람		팔로워: 내팬, 나를 구독하는 사람들

	@ManyToOne(fetch = FetchType.LAZY)	// 2. 실제 객체 사용하는 시점에서 쿼리 실행, 불필요한 join 줄이기
	@JoinColumn(name = "FOLLOWEE_ID", nullable = false)
	AppUser followee;	// @ManyToOne	보여지는사람	팔로잉: 내가 한 구독 (김우빈, 신민아, 카리나 등...)

	public Follow(AppUser follower, AppUser followee) {
		super();
		this.follower = follower;	// 팔로우한 사람
		this.followee = followee;	// 팔로우당한 사람
	}
}

//	follwer		followee
//	1(나)		2(김우빈)
//	1(나)		3(신민아)
//	2(김우빈)		3(신민아)

//	1: 나	2: 김우빈		3: 신민아		4: 카리나