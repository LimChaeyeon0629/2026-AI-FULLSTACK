// pages/mypage.js

// 1. import
import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useRouter } from "next/router";
import {
    Card, Avatar, Spin, Descriptions, Form, Input, Button, Upload, List, Tabs, message,
} from "antd";
import { updateNicknameRequest, updateProfileImageRequest } from "../reducers/authReducer";
import { UploadOutlined } from "@ant-design/icons"

import { END } from "redux-saga";
import { loadUserRequest } from "../reducers/authReducer";
import { wrapper } from "../store/configureStore";

// BEFORE
// 1) 사용자가 마이페이지(/mypage) 주소로 접속합니다.
// 2) 서버에서 getServerSideProps가 실행되면서 loadUserRequest 액션을 디스패치합니다.
// 3) 문제점: Redux-Saga는 비동기(Asynchronous)로 동작하기 때문에,
//      서버는 사가가 백그라운드에서 백엔드 API(/auth/me)를 부르든 말든
//      기다리지 않고 곧바로 return { props: {} }를 실행해버립니다.
// 4) 결과적으로 브라우저는 유저 정보가 아직 담기지 않은 텅 빈 스토어 상태로
//      페이지를 먼저 그려버리게 되므로, 새로고침 시 로그인 정보가
//      안 뜬 것처럼 보이거나 깜빡임 현상이 발생합니다.

// 직접 API를 부르지 않고, loadUserRequest 디스패치 해서 사가 완료 기다림
// 마이페이지 접근 권한 검사    &&      새로고침했을 때 로그인 사용자 정보 복구
export const getServerSideProps = wrapper.getServerSideProps((store) => async (ctx) => { 
    // 1. 요청헤더의 쿠키를 담아서 사용자 정보를 조회를 위한 사가 액션 디스패치
    // 브라우저가 보낸 쿠키를 가져오기
    store.dispatch(loadUserRequest({ cookie: ctx.req.headers.cookie || "" }));
    
    // 2. 서버 사이드에서 사가 작업이 끝날 때까지 대기
    store.dispatch(END);                // Saga 종료 신호 (채널닫기 신호)
    await store.sagaTask.toPromise();   // (비동기요청) Saga가 끝날 때까지 기다림

    // 3. 스토어 상태를 확인해서 유저 정보 없으면 로그인 페이지로 리다이렉트
    const state = store.getState();     // Redux store 상태 가져오기
    const user = state.auth.user;
    
    if (!user || !user.nickname) {      // user 정보 없으면 로그인 페이지로
        return {
            redirect: {
                destination: "/login",  
                permanent: false,  
            },
        };
    }

    return { props: {} };
});

// 2. 부품 + export
function Mypage() {
    // Redux에서 회원가입 시 저장된 사용자 정보 가져오기 - user
    // useSelector(전역) useDispatch(스토어알림)
    // useEffect(이벤트변경감지) useState(변수)
    // useRouter(경로)
    const dispatch = useDispatch();
    const router = useRouter();
    const { user } = useSelector((state)=> state.auth);   // Redux에서 회원가입 시 저장된 사용자 정보 가져오기 - user

    const [ fileList, setFileList ] = useState([]);

    if(!user) {
        return (
            <div style={{maxWidth:600, margin:"40px auto"}}>
                <p>로그인된 사용자가 없습니다.</p>
                <Button type="primary" onClick={()=> router.push("/signup")}>
                    회원가입 하러가기
                </Button>
            </div>
        );
    }
    
    const onFinishUpdateNickname = (value)=> {
        // const sendData = {
        //     userId: user.id,
        //     nickname: value.nickname
        // }
        // dispatch( updateNicknameRequest({sendData}))
        dispatch( updateNicknameRequest({userId: user.id, nickname: value.nickname}) );
    }

    const onFinishUpdateProfileImage = (value)=> {
        dispatch( updateProfileImageRequest({userId: user.id, file: value.file}) );
    }

    

    ////////////////////////
    return (
        <div style={{maxWidth:600, margin:"40px auto"}}>
            <Card title="마이페이지 (회원정보)">
                <div style={{ display:"flex", alignItems:"center", gap:"20px" }}>
                    <Avatar src={`http://localhost:8080/${user.ufile}`} size={64}>{user.nickname?.[0]}</Avatar>
                    <Descriptions title="User Info" bordered column={1}>
                        <Descriptions.Item label="회원 번호">{user.id}</Descriptions.Item>
                        <Descriptions.Item label="이메일">{user.email}</Descriptions.Item>
                        <Descriptions.Item label="닉네임">{user.nickname}</Descriptions.Item>
                    </Descriptions>
                </div>
            
                {/* 닉네임 수정 - Q1. updateNicknameRequest 호출 */}
                <Form  
                    layout="inline"
                    style={{ marginBottom: 20 }}
                    onFinish={onFinishUpdateNickname}
                    >
                    <Form.Item name="nickname">
                        <Input placeholder="새 닉네임" />
                    </Form.Item>
                    <Button type="primary" htmlType="submit">닉네임 변경</Button>
                </Form>

                {/* 프로필이미지 수정 */}
                <Form
                    layout="inline"
                    style={{ marginBottom: 20 }}
                    onFinish={onFinishUpdateProfileImage}
                    >
                    <Form.Item>
                        <Upload 
                            beforeUpload={()=> false}
                            fileList={fileList}
                            onChange={ ({fileList})=> setFileList(fileList)  }
                            maxCount={1}>
                            <Button icon={<UploadOutlined />}>이미지 선택</Button>
                        </Upload>
                    </Form.Item>
                    <Button
                        type="primary"
                        onClick={()=> {
                            if(!user || fileList.length === 0) {
                                message.warning("변경할 이미지를 선택해주세요.");   return;
                            }
                            const file = fileList[0]?.originFileObj;
                            dispatch( updateProfileImageRequest({userId: user.id, file})  );
                            setFileList([]);    // 전송 후 파일 선택 목록 초기화
                        }}
                    >
                        프로필 이미지 변경
                    </Button>
                </Form> 
            </Card>
        </div>
    );
}


// 3.
export default Mypage;

// export default function MypagePage() {
//     return "Mypage";
// };