// 1. require / import
import { Row, Col, Form, Input, Button, Upload, Spin, message } from "antd";    
import { UploadOutlined } from "@ant-design/icons";   
// store: useSelector(전역), useDispatch(스토어이벤트알림)
// 감지: useEffect(이벤트변경감지), useState(변수)
// 경로: useRouter
import { useSelector, useDispatch } from "react-redux";
// import { useEffect, useState } from "react";
import React, { useEffect, useState, useRef } from "react";
import { useRouter } from "next/router";
import { signupRequest, resetUserState } from "../reducers/authReducer";
import Password from "antd/lib/input/Password";

import axios from "axios";



// 2. function (부품)
function SignupPage() {
    // 5개부품 - useEffect(이벤트변경감지), useState(변수)
    const dispatch = useDispatch();     // 이벤트변경감지   (Redux store에 액션 전달)
    const router = useRouter();         // 경로            (페이지 이동)
    const { user, error, success, loading } = useSelector((state) => state.auth);

    const [ fileList, setfileList ] = useState([]);
    const isSubmittedRef = useRef(false);

// 데이터 받아서 회원가입전송   - 네트워크가 느리면 0.5초동안 2~3회 연속으로 클릭 (회원가입 요청 중복)
    // ()=> {}
    const onFinish = ( values )=> {
        // const sendData = {
        //     email: values.email,
        //     password: values.password,
        //     nickname: values.nickname,
        // }

        if( isSubmittedRef.current ) return;
        isSubmittedRef.current = true;

        const formData = new FormData();
        formData.append("email", values.email);
        formData.append("password", values.password);
        formData.append("nickname", values.nickname);
        if(fileList.length > 0) {
            formData.append("ufile", fileList[0].originFileObj);
        }
        dispatch( signupRequest(formData) );
    };
    
    useEffect(()=> {
        if(success) {
            message.success("회원가입이 성공적으로 완료되었습니다.");
            // router.push('mypage');
            router.push('login');
            dispatch( resetUserState() );
        }
    }, [success, router, dispatch]);

    /////////////////////// Layout > Row > Col Col
    // 모바일제일작은사이즈: 24     xs={} 
    // 모바일2: 16                sm={}
    // 태블릿 : 8                 md={} / lg={}
    return (
        <Row justify="center" style={{padding:"20px"}}>
            <Col style={{background:"white", padding:"20px"}} xs={24} sm={16} md={8}>
                { loading && <Spin /> }
                {/* { error && <p style={{color:"red"}}>error</p> } */}
                {error && ( <p style={{ color: "red" }}>
                                {typeof error === "string"
                                ? error
                                : error?.message || JSON.stringify(error)}
                            </p>
                )}
                { !success && (
                    <Form layout="vertical" onFinish={onFinish}>
                        {/* 이메일입력 + 중복검사     Form.Item   > Input / name, hasFeedback 아이콘 */}
                        <Form.Item
                            label="이메일"
                            name="email"
                            hasFeedback
                            rules={[{ required: true, message: '이메일을 입력하세요.' } , 
                                { validator: async (_, value) => { // _ 필드관련정보 , value 사용자가 입력한값
                                    if (!value) return Promise.resolve(); //입력값이 없으면 검사 통과
                                    try {
                                        //서버에 이메일 중복여부확인
                                        const res = await axios.get(
                                        `http://localhost:8080/auth/check-email?email=${encodeURIComponent(value)}`
                                        );
                                        // 서버응답이 true라면  → 이미 사용중인 이메일
                                        if (res?.data === true) {
                                            return Promise.reject( new Error("이미 사용 중인 이메일입니다.") );
                                        }
                                        return Promise.resolve(); // 중복이 아니라면 검사 통과
                                    } catch (err) {
                                        console.error("이메일 중복 검사 오류: ", err); // 이메일 중복검사 오류
                                        return Promise.reject(new Error("중복 검사 실패")); // 검사 실패처리
                                    } 
                                },
                            }]}
                        >
                        <Input />
                        </Form.Item>

                        {/* 비밀번호 입력 */}
                        <Form.Item
                            label="비밀번호"
                            name="password"
                            rules={[ {required:true, message:'비밀번호를 입력하세요.'} ]}
                        >
                        <Input.Password />
                        </Form.Item>
                        
                        {/* 닉네임 입력 + 중복검사 */}
                        <Form.Item
                            label="닉네임"
                            name="nickname"
                            hasFeedback
                            rules={[ {required:true, message:'닉네임을 입력하세요.'},
                                { validator: async(_, value)=> {    // _: 필드관련정보, value: 사용자가 입력한 값
                                        if(!value) return Promise.resolve(); // 입력값이 없으면 검사 통과
                                        try {
                                            //서버에 이메일 중복여부확인
                                            const res = await axios.get(
                                            `http://localhost:8080/auth/check-nickname?nickname=${encodeURIComponent(value)}`
                                            );
                                            if(res?.data === true) {
                                                return Promise.reject( new Error("이미 사용중인 닉네임입니다."));
                                            }

                                        } catch(err) {
                                            console.error("닉네임 중복 검사 오류: ", err)   // 닉네임 중복검사 오류
                                            return Promise.reject(new Error("닉네임 검사 실패"));   // 검사 실패처리
                                        }
                                },
                            }]}
                        >
                        <Input />
                        </Form.Item>

                        {/* 프로필 이미지 업로드 */}
                        <Form.Item
                            label="프로필이미지"
                            name="ProfileImage"
                        >
                            <Upload
                                beforeUpload={ ()=> false }
                                fileList={fileList}
                                onChange={ ({fileList})=> setfileList(fileList) }
                                maxCount={1}
                            >
                                <Button icon={ <UploadOutlined/> }>이미지 선택</Button>
                            </Upload>
                        </Form.Item>

                        <Button type="primary" htmlType="submit">회원가입</Button>
                    </Form>
                )}
            </Col>
        </Row>
    );
}

// 3. export
export default SignupPage;

// export default function SignupPage() {
//     return "SIGNUP";
// } 