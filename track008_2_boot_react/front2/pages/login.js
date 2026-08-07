// pages/login.js

// 1. import / require
import React, { useEffect } from "react";   // 4. 이벤트 변경감지, useState
import { Provider, useDispatch, useSelector } from "react-redux"; // 2. 스토어알림,   1. 전역상태
import { useRouter } from "next/router";    // 3. 경로
import { Row, Col, Form, Input, Button, Spin, message } from "antd";  
import { loginRequest } from "../reducers/authReducer";

// 2+3. 부품 + export
export default function LoginPage() { 
    // Q1. useDispatch, useRouter 초기화
    const dispatch = useDispatch();
    const router = useRouter();

    // Q2. useSelector 이용해서 user 상태 가져오기 -    user, loading, error
    const { user, loading, error } = useSelector((state)=> state.auth);

    // Q3. 로그인 버튼을 누르고나면 -   스토어알림(dispatch) 이용해서 loginRequest 처리
    const onFinish = (values)=> {
        console.log(values);
        dispatch( loginRequest({ ...values, provider:'local' }) );
    };
    
    // Q4. 로그인 성공 시 oo님 환영합니다 메시지 띄우고 (message), 마이페이지로 이동 (router.push)
    useEffect(()=> {
        if(user && user.email) {
            message.success( `${user.nickname || user.email} 님 환영합니다!` );
            router.push('/mypage');
        }
    }, [user, router]);


    //////////////////////////////////////////////////
    /* Q5. justify 이용해서 중앙으로 배치, 위로 여백 40 */
    return (
        <Row justify="center"   style={{marginTop:40}}>
            <Col xs={24} sm={16} md={8}>
                { loading && <Spin /> }  
                { error && <p style={{color:"red"}}>{error}</p> }

                <Form  layout="vertical" onFinish={onFinish}> 
                    <Form.Item 
                        label="이메일"
                        name="email"
                        rules={[ {required:true, message:"이메일을 입력하세요."} ]} 
                    >
                        <Input placeholder="aaa@email.com"/>
                    </Form.Item>

                    <Form.Item 
                        label="비밀번호"
                        name="password" 
                        rules={[ {required:true, message:"비밀번호를 입력하세요."} ]}
                    >
                        <Input.Password  placeholder="********"/>
                    </Form.Item>         

                    <div style={{ textAlign: 'center', marginTop: 20 }}>
                        <Button 
                            type="primary" 
                            htmlType="submit"   
                            style={{ width: '200px', height: '50px' }}
                        >
                            로그인
                        </Button>
                    </div>
                </Form> 
            </Col>
        </Row>
    );
}

export async function getServerSideProps() {
  return { props: {} };
}

/*
// 이렇게 처리하려면?
Q1. 로그인한 상태: 글쓰기(post/new) / 마이페이지(mypage) / 로그아웃(logout)
Q2. 로그인 안한 상태: 로그인(login) / 회원가입(signup)
*/