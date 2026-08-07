// components/EditPostModal
import { useState } from 'react';
import { useSelector } from 'react-redux';
import { Modal, Form, Input, Button, Select, Upload } from 'antd';
import { UploadOutlined } from '@ant-design/icons';

export default function EditPostModal({visible, onCancel, editPost, onSubmit, uploadFiles, setUploadFiles}) {
    // Redux에서 회원가입 시 저장된 사용자 정보 가져오기 - user
    const { user } = useSelector((state)=> state.auth);

    const [fileList, setFileList] = useState([]);

    console.log("🔥 fileList:", fileList);
    console.log("🔥 editPost.images:", editPost?.images);

    ///////////////////////////////////
    return (
        <Modal title="글 수정" open={visible} onCancel={onCancel} footer={null}>
            <Form 
                initialValues={{
                    content: editPost?.content,
                    hashtags: editPost?.hashtags,
                }}
                onFinish={onSubmit}
                layout='vertical'
            >   
                {/* 게시글 내용 수정 */}
                <Form.Item name="content" label="내용">
                    <Input.TextArea rows={4} />
                </Form.Item>

                {/* 해시태그 수정 */}
                <Form.Item name="hashtags" label="해시태그">
                    <Select mode="tags" style={{width:"100%"}} />
                </Form.Item>

                {/* 이미지 수정     ## 5. 파일 변경 시 변경되는 값 추가 */}
                <Form.Item label="이미지업로드">
                    <Upload
                        multiple
                        beforeUpload={()=> false}
                        fileList={fileList}
                        // onChange={({fileList})=>
                        //     setFileList(fileList)
                        // }
                        onChange={({fileList})=>
                            setFileList(fileList.map((f)=> f.originFileObj))
                        }
                    >
                        <Button
                            type="primary"
                            htmlType="button"
                            icon = {<UploadOutlined />}
                        >
                            이미지 선택
                        </Button>
                    </Upload>
                </Form.Item>

                <Button type="primary" htmlType="submit">
                    수정완료
                </Button>
            </Form>
        </Modal>
    );
}