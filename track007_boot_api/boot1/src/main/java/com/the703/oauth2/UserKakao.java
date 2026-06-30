package com.the703.oauth2;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserKakao implements UserInfoOAuth2 {
	
	private final Map<String, Object> attributes;
	
	@Override
	public String getProvider() {
		return "kakao";
	}

	@Override
	public String getProviderId() { 
		if(attributes == null) {
			return null;
		}
		Object id = attributes.get("id");
		return id != null ? id.toString() : null;
	}

	
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> getAccount() {
		if(attributes == null) {
			return null;
		}
		Object account = attributes.get("kakao_account");
		return account instanceof Map? (Map<String, Object>)account : null;
	}

	@Override
	public String getEmail() { // email=sally03915@naver.com
		if(attributes == null) {
			return null;
		}
		Map<String, Object> account = getAccount();
		return account != null ? String.valueOf( account.get("email") ) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getNickname() { // profile={nickname=효정}
		Map<String, Object> account = getAccount();
		Object profile = account.get("profile");
		Map<String, Object> nickname = (Map<String, Object>) profile;
		return String.valueOf( nickname.get("nickname") );
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getImage() {
		Map<String, Object> account = getAccount();
		Object profileObj = account.get("profile");
		Map<String, Object> profile = (Map<String, Object>) profileObj;
		Object imageUrl = profile.get("profile_image_url");
		return imageUrl != null ? imageUrl.toString() : null;
	}

}

///////// 1) 기본뼈대작성
///////// 2) 예외상황에 대한 방어코드로 개선 코드 보여줘