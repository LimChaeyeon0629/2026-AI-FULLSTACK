// sagas/postSaga.js

import { actionChannel, all, call, put, takeLatest } from 'redux-saga/effects';
import axios from 'axios';  // 프론트엔드나 Saga에서 백엔드 서버로 HTTP 요청을 보내는 라이브러리
import  {
    fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
    fetchPostsDetailRequest, fetchPostsDetailSuccess, fetchPostsDetailFailure,
    createPostRequest, createPostSuccess, createPostFailure,
    updatePostRequest, updatePostSuccess, updatePostFailure,
    deletePostRequest, deletePostSuccess, deletePostFailure,
    resetPostState  // 초기화
} from '../reducers/postReducer';
import { Form } from 'antd';


const POST_API_BASE = 'http://localhost:8080/api/posts';

// watchFetchPosts          - GET       /api/posts        전체 게시글 조회
export const fetchPostsAPI = ()=> axios.get(POST_API_BASE);
export function* fetchPosts() {
    try {
        const result = yield call(fetchPostsAPI);
        yield put(fetchPostsSuccess(result.data));
    
    } catch(err) {
        yield put(fetchPostsFailure(err.response?.data?.message || err.message));
    }
}

// watchFetchPostsDetail    - GET       /api/posts/{id}   게시글 단건 조회
export const fetchPostsDetailAPI = (id)=> axios.get(`${POST_API_BASE}/${id}`);
export function* fetchPostsDetail(action) {
    try {
        const result = yield call(fetchPostsDetailAPI, action.payload);
        yield put(fetchPostsDetailSuccess(result.data));

    } catch(err) {
        yield put(fetchPostsDetailFailure(err.response?.data?.message || err.message));
    }
}

// watchCreatePost          - POST      /api/posts        게시글 작성
export const createPostAPI = (payload)=> {
    const { userId, dto, files } = payload;         // 1. boot의 컨트롤러 - postController return 값
    const formData = new FormData();                // 2. form 만들기

    Object.entries(dto || {}).forEach(([k, v]) => { // 3. dto - content / hashtags
        if (v !== undefined && v !== null) {
            formData.append(k, v);
        }
    });

    if (files && files.length > 0) {                // 4. 이미지 파일들
        files.forEach((f) => formData.append('files', f));
    }

    // POST_API_BASE =  http://localhost:8080/api/posts
    //                  http://localhost:8080/api/posts?userId
    return axios.post(`${POST_API_BASE}?userId=${userId}`, formData, {
        headers: { 'Content-Type': 'multipart/form-data' },
    });
}
export function* createPost(action) {
    try {
        const result = yield call(createPostAPI, action.payload);   // action.payload 사용자가 넘겨준 값
        yield put(createPostSuccess(result.data));
        
    } catch(err) {
        yield put(createPostFailure(err.response?.data?.message || err.message));
    }
}

// watchUpdatePost          - PATCH       /api/posts/{id}   게시글 수정
// export const updatePostAPI = (id, postData)=> axios.put(`${POST_API_BASE}/${id}`, postData);
// ...화살표 함수(=>) 줄바꿈 오류
export const updatePostAPI = (payload)=> {
    const { userId, postId, dto, files } = payload;     // 1. boot의 컨트롤러 - postController return 값
    const formData = new FormData();                    // 2. form 만들기
    
    Object.entries(dto || {}).forEach(([k, v]) => {     // 3. dto - content / hashtags
        if (v !== undefined && v !== null) {
            formData.append(k, v);
        }
    });

    if (files && files.length > 0) {                    // 4. 이미지 파일들
        files.forEach((f) => formData.append('files', f));
    }
    
    // POST_API_BASE =  http://localhost:8080/api/posts
    //                  http://localhost:8080/api/posts/${postId}?userId=1
    return axios.patch(`${POST_API_BASE}/${postId}?userId=${userId}`, formData, {
        headers: { 'Content-Type': 'multipart/form-data' },
    });
}
    
export function* updatePost(action) {
    try {
        const result = yield call(updatePostAPI, action.payload);
        yield put(updatePostSuccess(result.data));
        
    } catch(err) {
        yield put(updatePostFailure(err.message?.data?.message || err.message));
    }
}

// watchDeletePost          - DELETE    /api/posts/{id}   게시글 삭제
export const deletePostAPI = (id)=> axios.delete(`${POST_API_BASE}/${id}`);
export function* deletePost(action) {
    // action = { type: , payload:{} }
    try {
        yield call(deletePostAPI, action.payload);
        yield put(deletePostSuccess(action.payload));   // action.payload 사용자 글 번호 넘기기
        
    } catch(err) {                  // 서버가 보낸 에러 메시지 || java 기본 에러 메시지
        yield put(deletePostFailure(err.response?.data?.message || err.message));
    }
}

// --- watch saga들 ---     ■ takeLatest : 여러 번 요청와도 1번만
function* watchFetchPosts() {
    yield takeLatest( fetchPostsRequest.type, fetchPosts );
}
function* watchFetchPostsDetail() {
    yield takeLatest( fetchPostsDetailRequest.type, fetchPostsDetail );
}
function* watchCreatePost() {
    yield takeLatest( createPostRequest.type, createPost );
}
function* watchUpdatePost() {
    yield takeLatest( updatePostRequest.type, updatePost );
}
function* watchDeletePost() {
    yield takeLatest( deletePostRequest.type, deletePost );
}

export default function* postSaga() {
    yield all([
        call(watchFetchPosts),
        call(watchFetchPostsDetail),
        call(watchCreatePost),
        call(watchUpdatePost),
        call(watchDeletePost),
    ]);
}