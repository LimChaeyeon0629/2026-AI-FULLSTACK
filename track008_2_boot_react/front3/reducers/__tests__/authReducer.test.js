//__test__/authReducer.test.js

import userReducer, { signupRequest, signupSuccess, signupFailure,
                    loginRequest, loginSuccess, loginFailure,
                    logoutRequest, logoutSuccess, logoutFailure,
                    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
                    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
                    // deleteUserRequest, deleteUserSuccess, deleteUserFailure,
                    resetUserState } from '../authReducer';

describe('user slice reducer', ()=> {
    const initialState = {
        user: null,     // 단건 조회된 사용자 정보
        loading: false, // 로딩상태
        error: null,    // 에러메시지
        success: false, // 성공여부
    };

    it('signupRequest', ()=> {      // state        action 호출
        const state = userReducer( initialState, signupRequest() );
        expect( state.loading ).toBe( true );
        expect( state.error ).toBeNull();
        expect( state.success ).toBe( false );
    });

    it('signupSuccess', ()=> {
        const userData = { id:1, email:'1@1' };
        const state = userReducer( initialState, signupSuccess(userData) );
        // 1. signupSuccess(userData) 실행하면      - { id:1, email:'1@1' };
        // 2. 리듀서 툴킷에서 { type: signupSuccess, payload: userData } 객체만들기
        // 3. 리듀서의 signupSuccess: (state, action)=> {} 액션받아서 처리
        expect( state.loading ).toBe( false );
        expect( state.user ).toEqual( userData );   // state.user = action.payload
        expect( state.success ).toBe( true );
    });
    
    it('signupFailure', ()=> {
        const state = userReducer( initialState, signupFailure('회원가입 실패') );
        // 1. signupFailure('회원가입 실패') 실행하면
        // 2. 리듀서 툴킷에서 { type: signupFailure, payload: '회원가입 실패' } 객체만들기
        // 3. 리듀서의 signupFailure: (state, action)=> {} 액션받아서 처리
        //      action = { type: signupFailure, payload: '회원가입 실패' }
        expect( state.loading ).toBe( false );
        expect( state.error ).toBe('회원가입 실패');    // state.error = action.payload
    });
    
    ///////////////////////////////////////////
    ///////////////////////////////////////////
    it('resetUserState', ()=> {
        const prev = {user: {id:1}, loading: true, error: 'err', success: true};    // 상태꼬임
        const state = userReducer(prev, resetUserState());
        // 1. resetUserState() 실행 - 인자없음
        // 2. 리듀서 툴킷 - { type: resetUserState, payload: undefined } 객체만들기
        // 3. 리듀서의 resetUserState: (state, action)=> {} 액션받아서 처리 - 상태초기화
        //      action = { type: resetUserState, payload: undefined }
        expect( state.loading ).toBe( false );
        expect( state.success ).toBe( false );
        expect( state.error ).toBe( null );
    });

    /////////////////////////////////////////// 로그인
    it('loginSuccess', ()=> {
        const prev = {
            user: null,
            loading: true,
            success: false,
            error: null,
        };
        const payload = { id:1, email:'1@1' };
        const state = userReducer(prev, loginSuccess(payload));
        expect( state.user ).toEqual(payload);
        expect( state.loading ).toBe(false);
        expect( state.success ).toBe(true);
    });

    /////////////////////////////////////////// 로그아웃
    it('logoutSuccess', ()=> {
        const prev = { ...initialState, user:{id:1} };
        const state = userReducer(prev, loginSuccess);
        expect( state.user ).toBeNull();
        expect( state.loading ).toBe(false);
        expect( state.success ).toBe(true);
        expect( state.error ).toBeNull();
    });

    /////////////////////////////////////////// 닉네임 변경
    if('updateNicknameSuccess', ()=> {
        const payload = {id:1, email:'1@1', nickname:'new'};
        const state = userReducer(initialState, updateNicknameSuccess(payload));
        expect( state.loading ).toBe(false);
        expect( state.success ).toBe(true);
        expect( state.user ).toEqual(payload);
    });

    /////////////////////////////////////////// 프로필이미지 변경
    if('updateProfileImageSuccess', ()=> {
        const payload = {id:1, email:'1@1', nickname:'new', ufile:'1.png'};
        const state = userReducer(initialState, updateProfileImageSuccess(payload));
        expect( state.loading ).toBe(false);
        expect( state.success ).toBe(true);
        expect( state.user ).toEqual(payload);
    });
});

// npm test
// npm run test
// npm test authReducer