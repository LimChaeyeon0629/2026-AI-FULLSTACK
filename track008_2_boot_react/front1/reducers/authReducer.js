// reducers/authReducer.js  -   Redux 저장소 상태 변경
// =   reducers/userSlice.js

import { createSlice } from "@reduxjs/toolkit";

// 1. 초기화 상태 (공용)
const initialState = {
    user: null,     // 단건 조회된 사용자 정보
    loading: false, // 로딩상태
    error: null,    // 에러메시지
    success: false, // 성공여부
};

// 2. 상태변화
const authReducer = createSlice({
    name: "user",
    initialState,
    reducers: {
        // --- 회원가입 ---
        signupRequest: (state)=> {
            state.loading = true;   // 로딩상태
            state.error   = null;   // 에러메시지
            state.success = false;  // 성공여부
        },
        signupSuccess: (state, action)=> {
            state.user = action.payload;    // 가입(단건 조회)된 사용자 정보
            state.loading = false;           // 로딩상태
            state.success = true;          // 성공여부
        },
        signupFailure: (state, action)=> {
            state.loading = false; 
            state.success = false;          // 성공여부
            state.error   = action.payload; // 에러메시지
        },
        
        // --- 사용자 단건조회 ---
        // 서버에서 받을 거 없으면 state, 서버에서 받을 거 있으면 action
        fetchUserRequest: (state)=> {
            state.loading = true;   // 로딩상태
            state.error   = null;   // 에러메시지
            state.success = false;  // 성공여부
        },
        fetchUserSuccess: (state, action)=> {
            state.loading = false;
            state.user    = action.payload;
            state.success = true;
        },
        fetchUserFailure: (state, action)=> {
            state.loading = false;
            state.success = false;
            state.error   = action.payload;
        },
        
        // --- 상태 초기화 ---
        // 로딩 에러 성공여부 초기화하는 코드 넣기
        resetUserState: (state)=> {
            state.loading = false;
            state.success = false;
            state.error   = null;
        },
    }
});

// 3. action
export const { signupRequest, signupSuccess, signupFailure,
                fetchUserRequest, fetchUserSuccess, fetchUserFailure,
                resetUserState } = authReducer.actions;

// 4. export
export default authReducer.reducer;