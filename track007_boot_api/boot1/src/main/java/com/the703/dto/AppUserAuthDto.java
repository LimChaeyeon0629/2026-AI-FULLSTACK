package com.the703.dto;

import java.util.List;

import lombok.Data;

@Data
public class AppUserAuthDto {
	private String email;
	private String password;
	private List<AuthDto> authList;
}


//이름           널?       유형            
//------------ -------- ------------- 
//APP_USER_ID  NOT NULL NUMBER(5)     
//EMAIL        NOT NULL VARCHAR2(100) 
//PASSWORD              VARCHAR2(100) 
//MBTI_TYPE_ID          NUMBER(3)     
//CREATED_AT            DATE          
//UFILE                 VARCHAR2(255) 
//MOBILE                VARCHAR2(50)  
//NICKNAME              VARCHAR2(50)  
//PROVIDER     NOT NULL VARCHAR2(50)  
//PROVIDER_ID           VARCHAR2(100) 

//이름          널?       유형            
//----------- -------- ------------- 
//AUTH_ID     NOT NULL NUMBER(5)     
//EMAIL                VARCHAR2(255) 
//AUTH        NOT NULL VARCHAR2(255) 
//APP_USER_ID          NUMBER(5)   