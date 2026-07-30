// sagas/__test__/authSaga.test.js

// 1. all        - 여러 saga를 동시에 실행
// 2. fork       - [비동기]로 saga 실행
// 3. call       - api를 호출하고 결과를 기다림 (blocking) > 동기
// 4. put        - redux 액션을 dispatch
// 5. takeLatest - 특정 액션을 감지하고 가장 마지막 액션만 처리
//                 * request 요청 중 가장 마지막 액션만.

// call - 동기 ( 하나 끝나고 결과물 받을 때까지 다음 할일 실행 x ) 제너레이터함수 function*
// fork - 비동기
// put  - redux 액션처리

import { call, put } from 'redux-saga/effects';
import axios from 'axios';  // 외부 연동
import userReducer, { signupRequest, signupSuccess, signupFailure,
                    fetchUserRequest, fetchUserSuccess, fetchUserFailure,
                    resetUserState } from '../../reducers/authReducer';
import { signup, fetchUser } from '../authSaga';

jest.mock('axios');     // mock: 테스트용 가짜 객체로 바꾸는 Jest 함수

describe('auth saga', ()=> {
    afterEach(()=> {
        jest.clearAllMocks()
    });
    
    // --- 회원가입 ---
    it('signup success', ()=> {
        const userData = { email:'1@1', password:1 };   // ##1
        const action = signupRequest(userData);         // ##2
        const generator = signup(action);
        
        // 1. API 호출 (call)
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');
        
        // 2. api 성공했다는 가정하에 결과 값을 전달
        const mockResponse = { data: {id:1, email:'1@1'} }  // ##3
        const putStep = generator.next( mockResponse ).value;
        
        // 3. 성공 액션 디스패치                             결과물
        expect(putStep).toEqual( put(signupSuccess(mockResponse.data)) );
        expect(generator.next().done).toBe(true);   // 제너레이터 완전종료 done
    });
    
    // --- 단건조회 ---
    it('fetchUser', ()=> {
        const action = fetchUserRequest(1);
        const generator = fetchUser(action);
        
        // 1. API 호출 (call)
        // const callStep = generator.next().value;
        // expect(callStep.type).toBe('CALL');
        expect(generator.next().value.type).toBe('CALL');
        
        // 2. api 성공했다는 가정하에 결과 값을 전달
        const mockUser = { data: {id:1, email:'1@1'} };     // ## 서버에서 전달된 값
        const putStep = generator.next( mockUser ).value;
        
        // 3. 성공 액션 디스패치
        expect(putStep).toEqual( put(fetchUserSuccess(mockUser.data)) );
    });
});

// npm test authSaga