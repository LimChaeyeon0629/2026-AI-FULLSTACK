//__test__/postReducer.test.js

import { exact } from 'prop-types';
import postReducer , { 
    fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
    fetchPostsDetailRequest, fetchPostsDetailSuccess, fetchPostsDetailFailure,
    createPostRequest, createPostSuccess, createPostFailure,
    updatePostRequest, updatePostSuccess, updatePostFailure,
    deletePostRequest, deletePostSuccess, deletePostFailure,
    resetUserState } from '../postReducer';
import reducer from '../authReducer';

describe('post', ()=> {
    const initialState= {
        posts: [],          // 전체게시글 목록
        currentPost: null,  // 단건 조회된 상세 게시글
        loading: false,
        error: null,
        success: false,
    };

    // --- 전체 게시글 ---
    it('fetchPostsRequest & fetchPostsSuccess', ()=> {
        let state = postReducer( initialState, fetchPostsRequest() );
        // 1. fetchPostsRequest() 실행 - 인자 없음
        // 2. 리듀서툴킷 - { type: fetchPostsRequest, payload: undefined } 객체만들기
        // 3. 리듀서 fetchPostsRequest: (state, action)=> {} 액션받아서 처리
        //
        expect( state.loading ).toBe( true );
        
        const posts = [{id:1, content:'첫 번째 글'}];
        state = postReducer( initialState, fetchPostsSuccess(posts) );
        expect( state.loading ).toBe( false );
        expect( state.success ).toBe( true );
        expect( state.posts ).toEqual(posts);
    });

    it('fetchPostsFailure', ()=> {
        let state = postReducer( initialState, fetchPostsFailure('전체 게시글 조회 실패') );
        expect(state.loading).toBe( false );
        expect(state.success).toBe( false );
        expect(state.error).toEqual('전체 게시글 조회 실패');
    });

    // --- 단건 게시글 ---
    it('fetchPostsDetailRequest & fetchPostsDetailSuccess', ()=> {
        let state = postReducer( initialState, fetchPostsDetailRequest() );
        expect(state.loading).toBe(true);

        const post = {id:1, content:'첫 번째 글'};
        state = postReducer( initialState, fetchPostsDetailSuccess(post) );
        expect(state.loading).toBe( false );
        expect(state.success).toBe( true );
        expect(state.currentPost).toEqual(post);
    });
    
    it('fetchPostsDetailFailure', ()=> {
        let state = postReducer( initialState, fetchPostsDetailFailure('단건 게시글 조회 실패') );
        expect(state.loading).toBe( false );
        expect(state.success).toBe( false );
        expect(state.error).toEqual('단건 게시글 조회 실패');
    });
    
    // --- 게시글 작성 ---
    it('createPostRequest & createPostSuccess', ()=> {
        let state = postReducer( initialState, createPostRequest() );
        expect(state.loading).toBe(true);
        
        const newPost = {id:1, content:'게시글 작성 성공'};
        state = postReducer( initialState, createPostSuccess(newPost) );
        expect(state.loading).toBe(false);
        expect(state.success).toBe(true);
        expect(state.posts[0]).toEqual(newPost);
    });

    it('createPostFailure', ()=> {
        let state = postReducer(initialState, createPostFailure('게시글 작성 실패') );
        expect(state.loading).toBe( false );
        expect(state.success).toBe( false );
        expect(state.error).toEqual('게시글 작성 실패');
    });
    
    // --- 게시글 수정 ---
    it('updatePostRequest & updatePostSuccess', ()=> {
        let state = postReducer(initialState, updatePostRequest() );
        expect(state.loading).toBe(true);
        
        const prev = { ... initialState, posts: [{id:3, content:'게시글 수정 전'}] };
        const updated = {id:3, content:'게시글 수정 후'};   // 서버에서 받아온 값
        state = postReducer(prev, updatePostSuccess(updated) );
        expect(state.loading).toBe(false);
        expect(state.success).toBe(true);
        expect(state.currentPost).toEqual(updated);
        expect(state.posts[0].content).toBe('게시글 수정 후');
    });

    it('updatePostFailure', ()=> {
        const state = postReducer( initialState, updatePostFailure('게시글 수정 실패') );
        expect(state.loading).toBe(false);
        expect(state.success).toBe(false);
        expect(state.error).toEqual('게시글 수정 실패');
    })

    // --- 게시글 삭제 ---
    it('deletePostRequest & deletePostSuccess', ()=> {
        let state = postReducer( initialState, deletePostRequest() );
        expect(state.loading).toBe(true);

        // const prev = {
        //     posts: [{id:1, content:'첫 번째 게시 글'}],
        //     currentPost: null,
        //     loading: true,
        //     error: null,
        //     success: false,
        // }

        // const delPost = {id:1};
        
        const prev = { ...initialState, posts: [{id:1, content:'새 글'}] };
        state = postReducer( prev, deletePostSuccess(1) );
        expect(state.posts).toHaveLength(0);
        expect(state.loading).toBe(false);
        expect(state.success).toBe(true);
    });

    it('deletePostFailure', ()=> {
        const state = postReducer(initialState, deletePostFailure('게시글 삭제 실패'));
        expect(state.loading).toBe(false);
        expect(state.success).toBe(false);
        expect(state.error).toEqual('게시글 삭제 실패');
    });

    // --- 상태 초기화 ---
    it('resetUserState', ()=> {
        const prev = { ...initialState, loading:true, error:'error', success: true };
        const state = postReducer(initialState, resetUserState());
        expect(state.loading).toBe(false);
        expect(state.success).toBe(false);
        expect(state.error).toBeNull();
    });
});

// npm test postReducer