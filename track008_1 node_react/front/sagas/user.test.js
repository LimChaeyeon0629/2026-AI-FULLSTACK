// # 사가 테스트 코드
// npx jest sagas/user.test.js

import {call, put} from 'redux-saga/effects';    // saga 기본함수
import {
    login, logout, signUp, loadUsers, updateNickname, deleteUser, emailDoubleCheck,
    loginApi, logoutApi, signUpApi, loadUsersApi, updateNicknameApi, deleteUserApi, emailDoubleCheckApi
} from './user';

import reducer, {
    initialState,
    LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_IN_FAILURE,
    LOG_OUT_REQUEST, LOG_OUT_SUCCESS, LOG_OUT_FAILURE,
    SIGN_UP_REQUEST, SIGN_UP_SUCCESS, SIGN_UP_FAILURE,
    LOAD_USERS_REQUEST, LOAD_USERS_SUCCESS, LOAD_USERS_FAILURE,
    UPDATE_NICKNAME_REQUEST, UPDATE_NICKNAME_SUCCESS, UPDATE_NICKNAME_FAILURE,
    DELETE_USER_REQUEST, DELETE_USER_SUCCESS, DELETE_USER_FAILURE,
    EMAIL_DOUBLECHECK_REQUEST,
    EMAIL_DOUBLECHECK_SUCCESS,
    EMAIL_DOUBLECHECK_FAILURE
} from '../reducers/user';  // 액션 타입 불러오기

describe('user saga', ()=> {
    // ===== 회원가입 =====     watchSignUp
    // ===== 회원가입 =====     watchSignUp
    it('signup success', ()=> {
        const action = {type:SIGN_UP_REQUEST,
                        data:{email:'z@z', password:'z', nickname:'zzz'}};
        const gen = signUp(action);

        expect(gen.next().value).toEqual( call(signUpApi, action.data) );
        expect(gen.next({}).value).toEqual( put({type:SIGN_UP_SUCCESS}) );

        const error = {response:{ data:'이미 존재하는 이메일' }};
        expect(gen.throw(error).value)
                .toEqual(put( {type:SIGN_UP_FAILURE, error:'이미 존재하는 이메일'} ));
    });

    // ===== 로그인 =====       watchLogin
    // ===== 로그인 =====       watchLogin
    it( 'login success' , ()=>{
        const action = {type:LOG_IN_REQUEST, data:{ email:'1@1' , password:'1' }};
        const gen    = login(action);

        expect(gen.next().value).toEqual(call(loginApi, action.data));

        const apiResponse = {APP_USER_ID:1, EMAIL : '1@1', NICKNAME:'1'};
        expect(gen.next({ data: { user: apiResponse } }).value)
                    .toEqual( put({type:LOG_IN_SUCCESS,
                                data:{id:1 , email:'1@1' , nickname:'1'}
                    }));
    });


    // ===== 로그아웃 =====     watchLogout
    // ===== 로그아웃 =====     watchLogout
    it( 'logout success' , ()=>{
    const action = { type: LOG_OUT_REQUEST};
    const gen    = logout(action);

    expect(gen.next().value).toEqual( call(logoutApi) );
    expect(gen.next({}).value).toEqual( put({type:LOG_OUT_SUCCESS}) );

    const error = {response:{ data:'로그아웃 실패' }};
    expect(gen.throw(error).value)
            .toEqual(put( {type:LOG_OUT_FAILURE, error:'로그아웃 실패'} ));
    });


    // ===== 사용자 조회 =====  watchLoadUsers
    // ===== 사용자 조회 =====  watchLoadUsers
    it( 'loadUsers success' , ()=>{
    const action = { type: LOAD_USERS_REQUEST};
    const gen    = loadUsers(action);

    expect(gen.next().value).toEqual(call(loadUsersApi));
    // expect(gen.next({}).value).toEqual(put({type: LOAD_USERS_SUCCESS}));
    // * result = {} → result.data.map() → {}.data

    const fakeUsers = [{APP_USER_ID:1,  EMAIL : 'z@z' , NICKNAME:'zzz'}];
    expect(gen.next({ data:fakeUsers} ).value).toEqual(put( {type:LOAD_USERS_SUCCESS, 
                                        data: [{id:1,  email : 'z@z' , nickname:'zzz'}]
            }) );
    const error = {response: {data:'조회 실패'}};
    expect(gen.throw(error).value)
            .toEqual(put( {type:LOAD_USERS_FAILURE, error:'조회 실패'} ));
    });



    // ===== 닉네임 수정 =====  watchUpdateNickname
    // ===== 닉네임 수정 =====  watchUpdateNickname
    it( 'updateNickname success' , ()=>{
    const action = { type: UPDATE_NICKNAME_REQUEST, data: {id:1, nickname:'new'}};
    const gen    = updateNickname(action);

    expect(gen.next().value).toEqual(call(updateNicknameApi, action.data));

    expect(gen.next({}).value).toEqual(put({type: UPDATE_NICKNAME_SUCCESS,
                                            data: {id:1, nickname:'new'}
    }));

    const error = {response: {data:'수정 실패'}};
    expect(gen.throw(error).value)
            .toEqual(put( {type:UPDATE_NICKNAME_FAILURE, error:'수정 실패'} ));
    });


    
    // ===== 사용자 삭제 =====  watchDeleteUser
    // ===== 사용자 삭제 =====  watchDeleteUser  
    it( 'deleteUser success' , ()=>{
        const action = { type: DELETE_USER_REQUEST, data: {id:1}};
        const gen    = deleteUser(action);

        expect(gen.next().value).toEqual(call(deleteUserApi, action.data.id));

        expect(gen.next({}).value).toEqual(put({type: DELETE_USER_SUCCESS,
                                                data: {id:1}
        }));

        const error = {response: {data:'삭제 실패'}};
        expect(gen.throw(error).value)
                .toEqual(put( {type:DELETE_USER_FAILURE, error:'삭제 실패'} ));
    });
    
    // ===== 이메일 중복확인 =====       watchEmailDoubleCheck
    // ===== 이메일 중복확인 =====       watchEmailDoubleCheck 
    it( 'emailDoubleCheck success' , ()=>{
        const action = { type: EMAIL_DOUBLECHECK_REQUEST, data: {email:'1@1'}};
        const gen    = emailDoubleCheck(action);

        expect(gen.next().value).toEqual(call(emailDoubleCheckApi, action.data.email));

        //  expect(gen.next({}).value).toEqual(put({type: EMAIL_DOUBLECHECK_SUCCESS,
        //                                         data: {email:'1@1'}
        //  }));                        // back router
        const apiResponse = { isAvailable: true, message: '사용 가능한 이메일입니다.' };
        expect( gen.next({ data: apiResponse }).value).toEqual(
                put({ type: EMAIL_DOUBLECHECK_SUCCESS, data: apiResponse })
        );

        const error = {response: {data:'이메일 더블체크 에러'}};
        expect(gen.throw(error).value)
                .toEqual(put( {type:EMAIL_DOUBLECHECK_FAILURE, error:'이메일 더블체크 에러'} ));
        });
    });

// npm run test
// npx jest sagas/user.test.js