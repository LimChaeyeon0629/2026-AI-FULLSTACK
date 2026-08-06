// reducers/postReducer.js

import { createSlice } from '@reduxjs/toolkit';
// import { resetUserState } from './authReducer';

const initialState= {
    posts: [],          // 전체게시글 목록
    currentPost: null,  // 단건 조회된 상세 게시글
    loading: false,
    error: null,
    success: false,
};

const postReducer = createSlice({
    name: "post",
    initialState,
    reducers: {
        // --- 전체 게시글 ---
        fetchPostsRequest: (state)=> {
            state.loading = true;
            state.success = false;
            state.error = null;
        },
        
        fetchPostsSuccess: (state, action)=> {
            state.loading = false;
            state.success = true;
            state.posts = action.payload;   // 전체게시글 목록
        },
        
        fetchPostsFailure: (state, action)=> {
            state.loading = false;
            state.success = false;
            state.error = action.payload;
        },
        
        // --- 단건 게시글 ---
        fetchPostsDetailRequest: (state)=> {
            state.loading = true;
            state.success = false;
            state.error = null;
        },
        
        fetchPostsDetailSuccess: (state, action)=> {
            state.loading = false;
            state.success = true;
            state.currentPost = action.payload;  // 단건 조회된 상세 게시글
        },
        
        fetchPostsDetailFailure: (state, action)=> {
            state.loading = false;
            state.success = false;
            state.error = action.payload;
        },
        
        // --- 게시글 작성 ---
        createPostRequest: (state)=> {
            state.loading = true;
            state.success = false;
            state.error = null;
        },
        
        createPostSuccess: (state, action)=> {
            state.loading = false;
            state.success = true;
            state.posts = [action.payload, ...state.posts];  // 새 글을 목록상단추가
        },
        
        createPostFailure: (state, action)=> {
            state.loading = false;
            state.success = false;
            state.error = action.payload;
        },
        
        // --- 게시글 수정 ---
        updatePostRequest: (state)=> {
            state.loading = true;
            state.success = false;
            state.error = null;
        },
        
        updatePostSuccess: (state, action)=> {
            state.loading = false;
            state.success = true;
            state.currentPost = action.payload;
            // 새 글을 목록상단추가
            state.posts = state.posts.map( post =>
                post.id === action.payload.id ? action.payload : post
            );
        },
        
        updatePostFailure: (state, action)=> {
            state.loading = false;
            state.success = false;
            state.error = action.payload;
        },
        
        // --- 게시글 삭제 ---
        deletePostRequest: (state)=> {
            state.loading = true;
            state.success = false;
            state.error = null;
        },
        
        deletePostSuccess: (state, action)=> {
            state.loading = false;
            state.success = true;
            // 삭제된 게시글의 id 받아서 목록에서 제외
            state.posts = state.posts.filter( post =>
                post.id !== action.payload
            );
        },
        
        deletePostFailure: (state, action)=> {
            state.loading = false;
            state.success = false;
            state.error = action.payload;
        },
        
        // --- 상태 초기화 ---
        resetUserState: (state)=> {
            state.loading = false;
            state.success = false;
            state.error = null;
        },
    }
});

export const {
    fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
    fetchPostsDetailRequest, fetchPostsDetailSuccess, fetchPostsDetailFailure,
    createPostRequest, createPostSuccess, createPostFailure,
    updatePostRequest, updatePostSuccess, updatePostFailure,
    deletePostRequest, deletePostSuccess, deletePostFailure,
    resetUserState
} = postReducer.actions;

export default postReducer.reducer;
