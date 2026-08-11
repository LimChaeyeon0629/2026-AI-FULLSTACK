// pages/_app.js        # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
// import, require

import React from 'react';          // React 불러오기
import { wrapper } from '../store/configureStore';  // 치킨집 (전역상태 + 서버연동)
import AppLayout from '../components/AppLayout.js';    // 공통레이아웃
import 'antd/dist/antd.css';        // ant 디자인
import '../styles/global.css';      // 전역 css

// 부품
// Component: 현재 렌더링할 페이지 컴포넌트
// pageProps: 해당 페이지에 전달되는 초기 props
function MyApp({ Component , pageProps }) {  // ## 부품, 초기설정값
  return (
    <AppLayout initialUser={pageProps.user}>
      <Component {...pageProps}/>
    </AppLayout>
  );
}

// export
export default wrapper.withRedux(MyApp);    // 스토어 전역사용
