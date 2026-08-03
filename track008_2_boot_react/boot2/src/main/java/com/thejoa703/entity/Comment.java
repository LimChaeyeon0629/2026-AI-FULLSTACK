package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="COMMENTS")
@Getter @Setter
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commment_seq")
	@SequenceGenerator(name = "commment_seq", sequenceName = "COMMENTS_SEQ", allocationSize = 1)
	Long Id;
	
	@Lob
	@Column(nullable = false)
	String content;
	
	@ManyToOne
	@JoinColumn(name="APP_USER_ID", nullable = false)
	AppUser user;
	
	@ManyToOne
	@JoinColumn(name="POST_ID", nullable = false)
	Post post;
	
	@Column
	private Boolean deleted = false;

	@Column(name = "CREATED_AT", nullable = false)
	LocalDateTime createdAt;
	@Column(name = "UPDATED_AT", nullable = false)
	LocalDateTime updatedAt;
	
	@PrePersist
	void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	@PreUpdate
	void onUpdated() {
		this.updatedAt = LocalDateTime.now();
	}
}



//String content;
//AppUser user;		@ManyToOne	/	@OneToMany AppUser user
//Post post;		@ManyToOne	/	@OneToMnay Post post
//boolean deleted;
//LocalDateTime createdAt;
//LocalDateTime updatedAt;