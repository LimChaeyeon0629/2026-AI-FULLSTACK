// pages/login.js

// 1. import / require
import { useSelector, useDispatch } from "react-redux";
import { useRouter } from "next/router";
import { loginRequest } from "../reducers/authReducer";

// 2+3. 부품 + export
export default function LoginPage() {
    return "login";
}

/*
// 이렇게 처리하려면?
Q1. 로그인한 상태: 글쓰기(post/new) / 마이페이지(mypage) / 로그아웃(logout)
Q2. 로그인 안한 상태: 로그인(login) / 회원가입(signup)
*/