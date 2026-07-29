// sagas/authSaga.js    -   백엔드 서버와 통신

import { all, call, put, takeLatest } from 'redux-saga/effects';
import axios from 'axios';  // 프론트엔드나 Saga에서 백엔드 서버로 HTTP 요청을 보내는 라이브러리
import { signupRequest, signupSuccess, signupFailure,
        fetchUserRequest, fetchUserSuccess, fetchUserFailure,
        resetUserState } from '../reducers/authReducer';

const USER_API_BASE = 'http://localhost:8080/api/users';

// --- 회원가입 POST /api/users ---
export const signupApi = ( userData )=> axios.post( USER_API_BASE, userData );  // /api/users
// ■ 2. signup(action) - action.payload 사용자가 입력한 값 (회원정보)
export function* signup(action) {
    // action = { type: signupSuccess, payload: userData }
    //                                 payload: {email:'1@1', password:'1'} }
    try {   //                         result = 서버에서 받아온 값
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


// --- 단건조회 GET /api/users/1 ---
export const fetchUserApi = ( userId )=> axios.get( `${USER_API_BASE}/${userId}` );
// ■ 2)
export function* fetchUser(action) {
    // action = { type: user/fetchUserRequest , payload: 1 }
    try {
        const result = yield call(fetchUserApi, action.payload);    // ■ 3)
        yield put( fetchUserSuccess(result.data) );
        
    } catch (err) {
        yield put( fetchUserFailure(err.response?.data?.message || err.message) );
    }
}
// ■ 1) takeLatest : 여러 번 요청와도 1번만
function* watchFetchUser() {
    yield takeLatest( fetchUserRequest.type, fetchUser );
}

// 1. User Api  -   사용자 관련 API
// - POST   /api/users        회원가입
// -  GET   /api/users/{id}   사용자 단건조회
export default function* authSaga() {
    yield all([
        call(watchSignup),
        call(watchFetchUser),
    ]);
}

