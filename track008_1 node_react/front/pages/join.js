// 회원가입페이지

// useSelector  - 전역상태
// useState     - 변수
// useEffect    - 이벤트 변경감지
// dispatch     - store 알림
// useRouter    - 경로
// * useRef 찾아보기
import { useSelector, useDispatch } from 'react-redux'; // 전역상태, 상태알림
import { useState,   useEffect    } from 'react';       // 변수상태변경, 이벤트변경
import { useRouter } from 'next/router';                // 경로
import { SIGN_UP_REQUEST, EMAIL_DOUBLECHECK_REQUEST, CHECK_EMAIL_REQUEST } from '../reducers/user';

export default function JoinPage() {
    // 1. 코드
    // let logo = "MyReact - 회원가입";
    const dispatch  = useDispatch();
    const router    = useRouter();
    const {me, isLoading, error, signUpDone, emailCheckLoading,
        checkEmailLoading, isEmailAvaliable
    } = useSelector( (state)=> state.user);  // 1. Store : 전역상태감지 useSelector
    // console.log("......", me);  // 회원가입 유저정보 test
    // console.log("......", isLoading);

    //      변수, 변수셋팅함수
    const [email, setEmail]         = useState('');     // let email=''
    const [password, setPassword]   = useState('');     // let password=''
    const [nickname, setNickname]   = useState('');     // 3. 변수 상태 변경 - REACT DOM ( useState )


    // // 이메일 중복체크 dispatch
    // const onEmailDoubleCheck = (e)=> {
    //     e.preventDefault();

    //     if (!email.trim()) {
    //         alert('이메일을 입력해주세요.');
    //         return;
    //     }
                
    //     dispatch({ type: EMAIL_DOUBLECHECK_REQUEST, data: { email } });
    // };

    // 회원가입 요청액션을 dispatch
    const onSubmit = (e)=> {
        e.preventDefault();

        // console.log(  email.trim() );
        // console.log( !email.trim() );    !값이있다 - true

        if(!email.trim()) {
            alert('이메일을 입력해주세요.');
            return;
        }
        if(!password.trim()) {
            alert('비밀번호를 입력해주세요.');
            return;
        }
        if(!nickname.trim()) {
            alert('닉네임을 입력해주세요.');
            return;
        }

        // 2. Store : 액션알림 useDispatch
        dispatch({type: SIGN_UP_REQUEST, data: {email, password, nickname} });
    };

    // 5. 상태변화 감지
    useEffect(()=> {        // 이벤트 변경
        if(signUpDone) {    // 회원가입 성공했다면
            router.push({   // 경로 넘겨주기
                pathname:'/login',
                query:{ signUpSuccess : 'true' } // 회원가입 성공여부 주소표시창줄
            });
        }
    }, [signUpDone, router]);

    // 로그인 시,,,,,, me 값이 있다면
    useEffect(()=> {
        if(me) {
            router.push('/users');
        }
    }, [me, router]);

    // function setChangeEmail() {
    //     setEmail('......');
    // }

    // 6. 이메일 중복검사
    const onCheckEmail = (e)=> {
        e.preventDefault();

        if (!email.trim()) {
            alert('이메일을 입력해주세요.');
            return;
        }
                
        // saga/user.js -           type,   action.data.email
        dispatch({ type: CHECK_EMAIL_REQUEST, data: { email } });
    };


    // 2. view - 레더링 <></>, 공백, 닫기태그 조심!
    return (
        <div className="container my-4">
            {/* <h3 className="mb-3" onClick={ ()=> console.log("......") }>{logo}</h3> */}
            {/* <h3 className="mb-3" onClick={setChangeEmail}>{email}</h3> */}
            <h3 className="mb-3">회원가입</h3>

            <form className="w-50 mx-auto" onSubmit={onSubmit}>
                {/* 이메일 입력 */}
                <div className="mb-3 input-group">
                    <input type="email" className="form-control"
                            placeholder="이메일" title="이메일입력"
                            value={email}
                            onChange={(e)=> { setEmail(e.target.value); }}
                            />
                    
                    <button type="button" className='btn btn-outline-secondary'
                            // onClick={onEmailDoubleCheck}
                            // disabled={emailCheckLoading}>중복확인
                            onClick={onCheckEmail}
                            disabled={checkEmailLoading}
                            >
                            {checkEmailLoading ? '확인중...' : '중복 확인'}
                    </button>
                </div>
                { isEmailAvaliable == true && 
                    <div className='text-success mb-2'>사용 가능한 이메일입니다.</div> }
                { isEmailAvaliable == false && 
                    <div className='text-danger mb-2'>이미 사용중인 이메일입니다.</div> }

                {/* 비밀번호 입력 */}
                <div className="mb-3">
                    <input type="password" className="form-control"
                            placeholder="비밀번호" title="비밀번호입력"
                            value={password}
                            onChange={(e)=> { setPassword(e.target.value); }}/>
                </div>
                {/* 닉네임 입력 */}
                <div className="mb-3">
                    <input type="text" className="form-control"
                            placeholder="닉네임" title="닉네임입력"
                            value={nickname}
                            onChange={(e)=> { setNickname(e.target.value); }}/>
                </div>
                {/* 버튼 입력 */}
                <div className="mb-3">
                    <button type="submit" className="btn btn-primary w-100"
                            disabled={isLoading}>회원가입</button>
                </div>

                {/* 에러 메시지 */}
                {error && <div className="alert alert-danger mt-3">{error}</div> }
            </form>
        </div>
    );
}

