package com.thejoa703.domain;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="DEPTUSER")
@Getter @Setter
public class DeptUser {
	
	@Id
	private Long deptno;
	
	private String dname;
	private String loc;
	
	
}
