// sagas/__test__/postSaga.test.js

import { call, put } from 'redux-saga/effects';
import axios from 'axios';  // 외부 연동
import  {
    fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
    fetchPostsDetailRequest, fetchPostsDetailSuccess, fetchPostsDetailFailure,
    createPostRequest, createPostSuccess, createPostFailure,
    updatePostRequest, updatePostSuccess, updatePostFailure,
    deletePostRequest, deletePostSuccess, deletePostFailure,
    resetUserState } from '../../reducers/postReducer';
import { fetchPosts, fetchPostsDetail, createPost, updatePost, deletePost } from '../postSaga';


jest.mock('axios');     // mock: 테스트용 가짜 객체로 바꾸는 Jest 함수

describe('auth saga', ()=> {
    afterEach(()=> {
        jest.clearAllMocks()
    });
    
    // --- 전체 게시글 조회 ---
    it('fetchUser success', ()=> {
        // 1. 화면요청
        const generator = fetchPosts(fetchPostsRequest());
        expect(generator.next().value.type).toBe('CALL');   // call() = 동기
        
        // 2. 결과물받기
        const mockData = [{id:1, content:'post 1'}];
        const putStep = generator.next( {data: mockData} ).value;
        
        // 3. 결과물확인
        expect( putStep ).toEqual( put(fetchPostsSuccess(mockData)) );
    });
    
    // --- 단건 게시글 조회 ---
    it('fetchPostsDetail success', ()=> {
        // 1. 화면요청
        const generator = fetchPostsDetail(fetchPostsDetailRequest(1));
        expect(generator.next().value.type).toBe('CALL');

        // 2. 결과물받기
        const mockData = {id:1, content:'detail'};
        const putStep = generator.next( {data: mockData} ).value;
        
        // 3. 결과물확인
        expect( putStep ).toEqual( put(fetchPostsDetailSuccess(mockData)) );
    });

    // --- 게시글 작성 ---
    it('createPost success', () => {
        const payload = { content: 'new' };
        const generator = createPost(createPostRequest(payload));
        expect(generator.next().value.type).toBe('CALL');
        
        const mockData = { id: 10, content: 'new' };
        const putStep = generator.next({ data: mockData }).value;
        
        expect(putStep).toEqual(put(createPostSuccess(mockData)));
    });

    // --- 게시글 수정 ---
    it('updatePost success', () => {
        const payload = { id: 10, content: 'updated' };
        const generator = updatePost(updatePostRequest(payload));
        expect(generator.next().value.type).toBe('CALL');
        
        const putStep = generator.next({ data: payload }).value;
        
        expect(putStep).toEqual(put(updatePostSuccess(payload)));
    });

    // --- 게시글 삭제 ---
    it('deletePost success', ()=> {
        const generator = deletePost(deletePostRequest(1));
        expect(generator.next().value.type).toBe('CALL');

        const putStep = generator.next().value;

        expect(putStep).toEqual( put(deletePostSuccess(1)) );
    });
});

// npm test postSaga