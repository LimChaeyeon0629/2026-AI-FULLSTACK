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
    name: "auth",
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

        // --- 상태 초기화 ---
        // 로딩 에러 성공여부 초기화하는 코드 넣기
        resetUserState: (state)=> {
            state.loading = false;
            state.success = false;
            state.error   = null;
        },
        
        // --- 로그인 (세션 기반이므로 user 정보만 관리) ---
        loginRequest: (state)=> {
            state.loading = true;
            state.success = false;
            state.error   = null;
        },
        loginSuccess: (state, action)=> {
            state.user = action.payload || null;
            state.loading = false;
            state.success = true;
        },
        loginFailure: (state, action)=> {
            state.loading = false;
            state.success = false;
            state.error = action.payload;
            state.user = null;
        },
        
        // --- 로그아웃 ---
        logoutRequest: (state)=> {
            state.loading = true;
            state.success = false;
            state.error = null;
        },
        logoutSuccess: (state)=> {
            state.user = null;
            state.loading = false;
            state.success = true;
            state.error = null;
        },
        logoutFailure: (state, action)=> {
            state.loading = false;
            state.success = false;
            state.error = action.payload;
        },
        
        // --- 닉네임 변경 ---
        updateNicknameRequest: (state)=> {
            state.loading = true;
            state.success = false;
            state.error = null;
        },
        updateNicknameSuccess: (state, action)=> {
            state.user = action.payload;
            state.loading = false;
            state.success = true;
        },
        updateNicknameFailure: (state, action)=> {
            state.loading = false;
            state.success = false;
            state.error = action.payload;
        },
        
        // --- 프로필이미지 변경 ---
        updateProfileImageRequest: (state)=> {
            state.loading = true;
            state.success = false;
            state.error = null;
        },
        updateProfileImageSuccess: (state, action)=> {
            state.user = action.payload || null;
            state.loading = false;
            state.success = true;
            
        },
        updateProfileImageFailure: (state, action)=> {
            state.loading = false;
            state.success = false;
            state.error = action.payload;
        },
        
        // --- 유저 삭제 ---
        // deleteUserRequest: (state)=> {
        //     user: null,     // 단건 조회된 사용자 정보
        //     loading: false, // 로딩상태
        //     error: null,    // 에러메시지
        //     success: false, // 성공여부
        // },
        // deleteUserSuccess: (state)=> {
        //     user: null,     // 단건 조회된 사용자 정보
        //     loading: false, // 로딩상태
        //     error: null,    // 에러메시지
        //     success: false, // 성공여부
        // },
        // deleteUserFailure: (state)=> {
        //     user: null,     // 단건 조회된 사용자 정보
        //     loading: false, // 로딩상태
        //     error: null,    // 에러메시지
        //     success: false, // 성공여부
        // },
    }
});

// 3. action
export const { signupRequest, signupSuccess, signupFailure,
                loginRequest, loginSuccess, loginFailure,
                logoutRequest, logoutSuccess, logoutFailure,
                updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
                updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
                // deleteUserRequest, deleteUserSuccess, deleteUserFailure,
                resetUserState } = authReducer.actions;

// 4. export
export default authReducer.reducer;