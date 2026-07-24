// 사용자 목록, 정보페이지(수정 및 삭제)
// pages/users.js

import { useSelector, useDispatch } from "react-redux"; // 전역상태, 상태알림
import { useState, useEffect } from "react";            // 변수상태변경, 이벤트변경(감지)
import { useRouter } from "next/router";
import {    // 사용자목록불러오기, 닉네임수정, 유저삭제, 로그아웃
    LOAD_USERS_REQUEST, UPDATE_NICKNAME_REQUEST,
    DELETE_USER_REQUEST, LOG_OUT_REQUEST
} from "../reducers/user";

// useSelector  - 전역상태
// useState     - 변수
// useEffect    - 이벤트 변경감지
// dispatch     - store 알림
// useRouter    - 경로

export default function UsersPage() {
    // 1. 코드
    // 초기화
    const dispatch = useDispatch(); // 1) 전역상태 - store 변화감지
    const router = useRouter();     // 3) 경로 - useRouter
    const {users, isLoading, error, me} = useSelector( (state)=> state.user );  // 2) 전역상태
    //  전역유저,   로딩,   에러,   로그인한유저

    // 1-1. 사용자목록불러오기
    useEffect(()=> {
        if(!me) {
            router.push('/login');  // 로그인(me)이 안되어 있으면 login 페이지로
        } else {
            dispatch({type:LOAD_USERS_REQUEST});    // 사용자 목록 요청
        }
    }, [me, router])

    // 1-2. 로그아웃
    const onLogout = ()=> {
        dispatch({type:LOG_OUT_REQUEST});
    }
    useEffect(()=> {
        if(me === null) {
            router.push('/login');
        }
    }, [me, router])

    // 1-3. 유저삭제
    const onDelete = (id)=> {
        dispatch({ type:DELETE_USER_REQUEST, data:{id} });
    }
    
    // 1-4. 닉네임수정 - newNickname, setNewNickname, onUpdateNickname
    const [editId, setEditId] = useState(null); // 닉네임 수정할 id = useState 변수
    const onEdit = (id)=> {
        setEditId(id);
    }

    const [newNickname, setNewNickname] = useState('');
    const onUpdateNickname = (id)=> {
        dispatch({ type:UPDATE_NICKNAME_REQUEST, data:{id, nickname:newNickname}});
        setEditId(null);
        setNewNickname('');
    }
    

    // 2. view
    return (
        <div className="container my-4">
            <h3 className="mb-3">사용자 목록</h3>

            {/* 로딩/에러상태 표시 */}
            { isLoading && <div className="alert alert-info">로딩중...</div> }
            { error && <div className="alert alert-danger">에러메시지</div> }

            {/* 사용자 목록 테이블 */}
            <table className="table table-striped table-bordered table-hover">
                <caption>사용자 목록</caption>
                <thead>
                    <tr>
                        <th scope="col">이메일</th>
                        <th scope="col">닉네임</th>
                        <th scope="col">액션</th>
                    </tr>
                </thead>

                <tbody>
                    {users.map( (u)=> (
                        <tr key={u.id}>
                            <td>{u.email}</td>
                            <td>
                                { editId === u.id
                                    ? <input type="text" className="form-control" placeholder="새 닉네임 입력"
                                        value={newNickname} onChange={ (e)=> {setNewNickname(e.target.value) }}/>
                                    : (u.nickname)
                                }
                            </td>
                            <td>
                                { editId !== u.id
                                ? <button className="btn btn-primary btn-sm me-2" onClick={()=> onEdit(u.id)}>닉네임 수정</button>
                                : <button className="btn btn-primary btn-sm me-2" onClick={()=> onUpdateNickname(u.id)}>수정 완료</button>
                                }

                                <button className="btn btn-danger btn-sm"
                                        onClick={ ()=> onDelete(u.id) }>삭제</button>
                            </td>
                        </tr>)
                    )}
                </tbody>
            </table>

            {/* 로그아웃 버튼 */}
            {me && 
            <div className="my-3">
                <button className="btn btn-secondary" onClick={onLogout}>로그아웃</button>
            </div>
            }
        </div>
    );
}

// npm run dev
// 로그아웃 / 아이디중복검사