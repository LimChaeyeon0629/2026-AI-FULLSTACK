// 로그인페이지

// useSelector  - 전역상태
// useState     - 변수
// useEffect    - 이벤트 변경감지
// dispatch     - store 알림
// useRouter    - 경로

import { useSelector, useDispatch } from "react-redux";
import { useState, useEffect } from "react";            // 변수관련
import { useRouter } from "next/router";                // 경로
import { LOG_IN_REQUEST } from "../reducers/user";

export default function LoginPage() {
    // 1. 코드
    // 초기화
    const dispatch  = useDispatch();
    const router    = useRouter();
    const {me, isLoading, error} = useSelector( (state)=> state.user );
    // console.log('현재 me:', me);

    // form 연결
    const [email, setEmail]         = useState('');     // email변수, email셋팅함수
    const [password, setPassword]   = useState('');

    // 1-1. 회원가입했다 - 회원가입 알림창 - http://localhost:3000/login?signUpSuccess=true
    useEffect(()=> {
        if(router.query.signUpSuccess == 'true') {
            alert('회원가입이 완료되었습니다. 로그인 해주세요!');
            // replace = 주소표시창줄 안바뀜, push = 주소표시창줄 바뀜
            // 알림창 띄우고 쿼리제거 / 새로고침해도 알림창이 다시 안뜨게
            // ( 주소표시창줄을 /login 으로 바꾸기,
            //      주소표시창줄 감출 필요 없어서 undefined,
            //              페이지 새로고침 하거나 로드 해도 알림창 no )
            router.replace('/login', undefined, {shallow:true} );
        }
    }, [router.query])
    
    // 1-2. 로그인
    // 로그인 버튼 요청액션
    const onSubmit = (e)=> {
        e.preventDefault();

        if(!email.trim()) {
            alert('이메일을 입력해주세요');
            return;
        }
        if(!password.trim()) {
            alert('비밀번호를 입력해주세요');
            return;
        }

        // dispatch 로그인요청 액션 알림
        dispatch({type:LOG_IN_REQUEST, data:{email, password}});
    }

    // 1-3. 로그인 후 사용자 목록 페이지 이동
    useEffect(()=> {
        if(me) {                    // replace  = 주소표시창줄 변경ㄴ history 추가 x
            router.push('/users');  // push     = 주소표시창줄 변경ㅇ history 추가 o
        }
    }, [me, router]);



    // 2. view
    return (
        <div className="container my-4">
            <h3 className="mb-3">로그인</h3>

            <form className="w-50 mx-auto" onSubmit={onSubmit}>
                {/* 이메일 입력 */}
                <div className="mb-3">
                    <input type="email" className="form-control"
                            placeholder="이메일" title="이메일입력"
                            value={email}
                            onChange={(e)=> { 
                                // console.log(e.target.value);
                                setEmail(e.target.value); }}/>
                </div>
                {/* <button type="submit" className="btn btn-seren">중복 확인</button> */}
                {/* 비밀번호 입력 */}
                <div className="mb-3">
                    <input type="password" className="form-control"
                            placeholder="비밀번호" title="비밀번호입력"
                            value={password}
                            onChange={(e)=> { 
                                // console.log(e.target.value);
                                setPassword(e.target.value); }}/>
                </div>
                {/* 버튼 입력 */}
                <div className="mb-3">
                    <button type="submit" className="btn btn-primary w-100"
                            disabled={isLoading}>로그인</button>
                </div>

                {/* 에러 메시지 */}
                { error && <div className="alert alert-danger mt-3">{error}</div> }
            </form>
        </div>
    );
}

// npm run dev