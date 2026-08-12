// sagas/authSaga.js    -   백엔드 서버와 통신

import { all, call, put, takeLatest } from 'redux-saga/effects';
import { signupRequest, signupSuccess, signupFailure,
    loginRequest, loginSuccess, loginFailure,   
    logoutRequest, logoutSuccess, logoutFailure,
    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
    // deleteUserRequest, deleteUserSuccess, deleteUserFailure,
    refreshTokenRequest, refreshTokenSuccess, refreshTokenFailure,
    loadUserRequest, loadUserSuccess, loadUserFailure,  // ###
    resetUserState } from '../reducers/authReducer';
import { func } from 'prop-types';
// import axios from 'axios';  // 프론트엔드나 Saga에서 백엔드 서버로 HTTP 요청을 보내는 라이브러리
import api from '../api/axios';     // ###
import Cookies from 'js-cookie';    // ###



// const USER_API_BASE = 'http://localhost:8080/api/users';
// const USER_API_BASE = 'http://localhost:8080/auth';
const USER_API_BASE = '/auth';      // ###

// --- 회원가입 (POST : http://localhost:8080/auth/signup) ---
export const signupApi = ( formData )=>
    api.post(`${USER_API_BASE}/signup`, formData,
        {headers: {"Content-Type": "multipart/form-data"}}
    );

// ■ 2. signup(action) - action.payload 사용자가 입력한 값 (회원정보)
export function* signup(action) {
    // action = { type: signupSuccess, payload: {email:'1@1', password:'1'} }
    try {
        const result = yield call(signupApi, action.payload);   // ■ 3.result.data
        yield put(signupSuccess(result.data));  // 처리결과 put
        
    } catch(err) {
        yield put(signupFailure(err.response?.data?.message || err.message));
    }
}
// ■ 1. takeLatest( signupRequest.type, signup ) : takeLatest - 요청이 여러 번, 가장 마지막 발생 요청 처리
function* watchSignup() {
    yield takeLatest( signupRequest.type, signup );
}



// --- 로그인 POST ---
// POST :       /api/login
export const loginApi = ( payload )=> api.post(`${USER_API_BASE}/login`, payload );

export function* login(action) {
    // { email:'1@1', password:'1', provider:'local'}
    // action = {type:user/fetchUserRequest, payload:1}
    try {
        const result = yield call(loginApi, action.payload);
        // result = ResponseEntity<Map<String, Object>>
        /* return ResponseEntity.ok(Map.of(
                    "accessToken", accessToken,
                    "user", user
            )); */
        const accessToken = result.data?.accessToken;
        const user = result.data?.user;

        if(user && accessToken) {
            if(typeof window != "undefined") {
                // JWT 저장
                localStorage.setItem("accessToken", accessToken);
                // 쿠키에도 저장
                Cookies.set("accessToken", accessToken);
            }
            // Redux에 로그인 성공 전달
            yield put(loginSuccess({user, accessToken}));
        }

    } catch(err) {
        yield put(loginFailure(err.response?.data?.message || err.message));
    }
}



// --- 토큰 재발급 @PostMapping("/refresh") ---
export const refreshApi = ()=> { return api.post(`${USER_API_BASE}/refresh`); };
export function* refresh() {
     try {
        const result = yield call(refreshApi);
        const newAccessToken = result.data?.accessToken || null;

        // CSR 환경에서 localStorage와 쿠키에 저장
        // 브라우저 환경인가?   &&    새 Access Token이 실제로 존재하는가?
        if(typeof window != "undefined" && newAccessToken) {
            localStorage.setItem("accessToken", newAccessToken); // JWT newAccessToken 지정
            Cookies.set("accessToken", newAccessToken); // 쿠키에도 newAccessToken 지정
        }

    } catch(err) {
        yield put(refreshFailure(err.response?.data?.message || err.message));
        yield put( logout() );
    }
}



// --- 로그아웃 POST ---
// POST :       /api/logout    넘겨줄 데이터 x
export const logoutApi = ()=> api.post(`${USER_API_BASE}/logout`);

export function* logout() {
    try {
        // 백엔드 로그아웃
        yield call(logoutApi);
        
        // 브라우저에 저장된 accessToken 삭제
        if(typeof window != "undefined") {
            localStorage.removeItem("accessToken"); // JWT remove
            Cookies.remove("accessToken"); // 쿠키에도 remove
            // localStorage.removeItem("accessToken", accessToken); // JWT remove
            // Cookies.remove("accessToken", accessToken); // 쿠키에도 remove
        }
        // Redux 로그인 정보 삭제
        yield put(logoutSuccess());
        
    } catch(err) {
        yield put(logoutFailure(err.response?.data?.message || err.message));
    }
}



// --- 닉네임 수정 Patch ---
// PATCH :       /auth/{userId}/nickname,   params를 통해서 닉네임넘기기
export const updateNicknameApi = ( {userId, nickname} )=>
    api.patch(`${USER_API_BASE}/${userId}/nickname`, null, {params:{nickname}});

export function* updateNickname(action) {
    try {
        const result = yield call(updateNicknameApi, action.payload);
        yield put(updateNicknameSuccess(result.data));
        
    } catch(err) {
        yield put(updateNicknameFailure(err.response?.data?.message || err.message));
    }
}



// --- 프로필이미지 수정 Patch ---
// PATCH :       /auth/{userId}/profile-image,  formData
export function updateProfileImageApi( {userId, file} ) {
    const formData = new FormData();
    formData.append("ufile", file);

    return api.patch(`${USER_API_BASE}/${userId}/profile-image`, formData,
        { headers: {"Content-Type": "multipart/form-data"} }
    )
}
export function* updateProfileImage(action) {
    try {
        const result = yield call(updateProfileImageApi, action.payload);
        yield put(updateProfileImageSuccess(result.data));
        
    } catch(err) {
        yield put(updateProfileImageFailure(err.response?.data?.message || err.message));
    }
}

// --- 유저 정보 로드 ---
const loadUserApi = (cookieHeader)=> api.get(`${USER_API_BASE}/me`, {
    headers: { cookie:cookieHeader || "" },
    withCredentials: true,  // 요청 보낼 때 쿠키도 같이 받기
});
export function* loadUser(action) {
    try {
        const result = yield call(loadUserApi, action.payload?.cookie);
        yield put(loadUserSuccess(result.data));
        
    } catch(err) {
        yield put(loadUserFailure(err.response?.data?.message || err.message));
    }
}




// ■ takeLatest : 여러 번 요청와도 맨마지막 1번만
function* watchLogin() { yield takeLatest( loginRequest.type, login ); }
function* watchLogout() { yield takeLatest( logoutRequest.type, logout ); }
function* watchUpdateNickname() { yield takeLatest( updateNicknameRequest.type, updateNickname ); }
function* watchUpdateProfileImage() { yield takeLatest( updateProfileImageRequest.type, updateProfileImage ); }
function* watchLoadUser() { yield takeLatest( loadUserRequest.type, loadUser ); }

export default function* authSaga() {
    yield all([
        call(watchSignup),              // - POST   /api/users        회원가입
        // call(watchFetchUser),        // -  GET   /api/users/{id}   사용자 단건조회
        call(watchLogin),
        call(watchLogout),
        call(watchUpdateNickname),
        call(watchUpdateProfileImage),
        call(watchLoadUser),            // 유저 조회 (현재 로그인한 사용자 정보 조회)
    ]);
}

