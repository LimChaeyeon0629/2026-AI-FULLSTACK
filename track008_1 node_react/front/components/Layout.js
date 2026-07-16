// components/Layout.js

import Link from 'next/link';
// 1. 부품 export default function 부품명
// 2. code  / return (a 태그말고 → Link 이용)      // { children } 자바스크립트 객체 인식
export default function Layout( { children } ) { // children(x) 문자열인식 → 렌더링 안됨
    return(
        <div>
            {/* 헤더 */}
            <div className="p-5 bg-primary text-white text-center">
                <h1>My First React Page</h1>
                <p>Resize this responsive page to see the effect!</p> 
            </div>

            {/* 네비게이션바 */}
            <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
            <div className="container-fluid">
                <ul className="navbar-nav">
                <li className="nav-item">
                    {/* Home */}
                    <Link href="/users">
                        <a className="nav-link active" href="#">HOME</a>
                    </Link>
                </li>
                <li className="nav-item">
                    {/* 로그인 */}
                    <Link href="/login">
                        <a className="nav-link" href="#">로그인</a>
                    </Link>
                </li>
                <li className="nav-item">
                    {/* 회원가입 */}
                    <Link href="/join">
                        <a className="nav-link" href="#">회원가입</a>
                    </Link>
                </li>
                </ul>
            </div>
            </nav>

            {/* 본문 className */}
            <main className="container mt-5">{ children }</main>

            {/* 푸터 */}
            <div className="mt-5 p-4 bg-dark text-white text-center">
                <p>Footer</p>
            </div>
        </div>
    );
}