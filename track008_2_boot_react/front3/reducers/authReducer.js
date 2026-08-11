// reducers/authReducer.js  -   Redux 저장소 상태 변경
// =   reducers/userSlice.js

import { createSlice } from "@reduxjs/toolkit";

// 1. 초기화 상태 (공용)
const initialState = {
    user: null,     // 단건 조회된 사용자 정보
    accessToken: null,  // ####
    loading: false, // 로딩상태
    error: null,    // 에러메시지
    success: false, // 성공여부 ( insert 할때 )
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
            // state.user = action.payload;    // 가입(단건 조회)된 사용자 정보
            state.loading = false;           // 로딩상태
            state.success = true;          // 성공여부
        },
        signupFailure: (state, action)=> {
            state.loading = false; 
            // state.success = false;          // 성공여부
            state.error   = action.payload; // 에러메시지
        },

        // --- 상태 초기화 ---
        // 로딩 에러 성공여부 초기화하는 코드 넣기
        resetUserState: (state)=> {
            state.loading = false;
            state.success = false;
            state.error   = null;
        },
        
        // --- 로그인 (jwt 기반 user 정보 관리) ---
        loginRequest: (state)=> {
            state.loading = true;
            // state.success = false;
            state.error   = null;
        },
        loginSuccess: (state, action)=> {
            state.user = action.payload.user || null;   // #### Map<String, Object>   key
            state.accessToken = action.payload.accessToken || null;   // #### Map<String, Object>   key
            state.loading = false;
            // state.success = true;
            
            // 4. 사용자 정보 반환 - boot (userController) 에서 넘겨주는 값
            // return ResponseEntity.ok(Map.of(
                //         "accessToken", accessToken,
                //         "user", user
                // ));
        },
        loginFailure: (state, action)=> {
            state.loading = false;
            // state.success = false;
            state.error = action.payload;
            state.user = null;
        },



        // --- 토큰재발급 ---
        refreshTokenRequest: (state)=> {
            state.loading = true;
        },
        refreshTokenSuccess: (state, action)=> {
            state.loading = false;
            state.accessToken = action.payload?.accessToken || null;
        },
        refreshTokenFailure: (state, action)=> {
            state.loading = false;
            state.error = action.payload;
        },
            

        
        // --- 로그아웃 ---
        logoutRequest: (state)=> {
            state.loading = true;
            // state.success = false;
            // state.error = null;
        },
        logoutSuccess: (state)=> {
            state.user = null;
            state.loading = false;
            state.success = true;
            state.error = null;
            state.accessToken = null;
        },
        logoutFailure: (state, action)=> {
            state.loading = false;
            // state.success = false;
            state.error = action.payload;
        },
        
        // --- 닉네임 변경 ---
        updateNicknameRequest: (state)=> {
            state.loading = true;
            // state.success = false;
            state.error = null;
        },
        updateNicknameSuccess: (state, action)=> {
            state.user = action.payload;
            state.loading = false;
            // state.success = true;
        },
        updateNicknameFailure: (state, action)=> {
            state.loading = false;
            // state.success = false;
            state.error = action.payload;
        },
        


        // --- 프로필이미지 변경 ---
        updateProfileImageRequest: (state)=> {
            state.loading = true;
            // state.success = false;
            // state.error = null;
        },
        updateProfileImageSuccess: (state, action)=> {
            state.user = action.payload || null;
            state.loading = false;
            // state.success = true;
        },
        updateProfileImageFailure: (state, action)=> {
            state.loading = false;
            // state.success = false;
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


        // --- 유저 추가 (현재 로그인한 사용자 정보 조회) ---
        loadUserRequest: (state)=> {
            state.loading = true;
        },
        loadUserSuccess: (state, action)=> {
            // return ResponseEntity.ok(user);   // 사용자 반환
            state.user = action.payload || null;
            state.loading = false;
        },
        loadUserFailure: (state, action)=> {
            state.user = null;
            state.loading = false;
            // return ResponseEntity.status(401).build();   // 인증실패 401
            state.error = action.payload || null;
        },
    }
});

// 3. action
export const { signupRequest, signupSuccess, signupFailure,
                loginRequest, loginSuccess, loginFailure,
                logoutRequest, logoutSuccess, logoutFailure,
                updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
                updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
                // deleteUserRequest, deleteUserSuccess, deleteUserFailure,
                refreshTokenRequest, refreshTokenSuccess, refreshTokenFailure,
                loadUserRequest, loadUserSuccess, loadUserFailure,
                resetUserState } = authReducer.actions;

// 4. export
export default authReducer.reducer;