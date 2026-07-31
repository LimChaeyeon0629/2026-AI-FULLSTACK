// 1. import
import { useSelector, useDispatch } from "react-redux"; // 전역정보, 이벤트발생
import { useRouter } from "next/router";    // 화면이동
import { createPostRequest } from "../../reducers/postReducer"; // 액션
import { Card, Form, Input, Button, message } from 'antd';


// 2. export + 부품
export default function NewPostPage() {
    //     글정보(state.post),  → reducer/index.js
    // 1. 유저정보(state.user) 가져오기 ( useSelector: 전역정보 )   Q2.
    const router = useRouter();
    const dispatch = useDispatch();
    const { loading, error } = useSelector( (state)=> state.post ); // 글정보
    const { user } = useSelector( (state)=> state.auth );           // 유저정보

    // 2. 게시글작성 ( dispatch(createPostRequest(dto)): 이벤트발생알림 )   Q3.
    //    글쓰고나면 /
    const onFinish = (values)=> {
        const dto = {
            content: values.content,
            userId: 103 // user.id 있는번호(66, 81, 101, 102, 103), 어떤유저
        };
        dispatch(createPostRequest(dto));
        message.success("게시글 작성요청 완료");
        router.push("/");
    };

    //////////////////////////////////////  Q1. view
    return (
        <Card title="게시글 작성" style={{maxWidth:600, margin:"0 auto"}}>
            <Form layout="vertical" onFinish={onFinish}>
                <Form.Item
                    label="내용"
                    name="content"
                    hasFeedback
                    rules={[ {required:true, message:'내용을 입력하세요.'} ]}
                >
                    <Input.TextArea rows={4} placeholder="게시글 내용을 입력하세요."/>
                </Form.Item>

                <Button type="primary" htmlType="submit">
                    게시글 작성
                </Button>
                { error && <p style={{color:"red"}}>{error}</p>}
            </Form>

        </Card>
    );
}