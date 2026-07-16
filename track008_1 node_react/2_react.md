### 1. 프로젝트

1. 프로젝트만들기
2. 프로그램설치
3. 서버진입점

```
front/
├── .next/                  # ✅ Next.js 빌드 결과물 (자동 생성, 배포 시 사용)
├── components/             # ✅ 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js           # 페이지 공통 레이아웃 컴포넌트
├── node_modules/           # ✅ 설치된 npm 패키지들
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── index.js            # 메인 페이지
│   ├── login.js            # 로그인 페이지
│   ├── signup.js           # 회원가입 페이지
│   └── users.js            # 사용자 목록 또는 정보 페이지 
├── reducers/               # ✅ Redux 리듀서 폴더
│   ├── index.js            # 루트 리듀서 (combineReducers)
│   ├── user.js             # 사용자 관련 리듀서
│   └── user.test.js        # 리듀서 테스트 코드
├── sagas/                  # ✅ Redux-Saga 폴더
│   ├── index.js            # 루트 사가
│   ├── user.js             # 사용자 관련 사가
│   └── user.test.js        # 사가 테스트 코드
├── store/                  # ✅ Redux 스토어 설정 폴더
│   ├── configureStore.js   # Redux 스토어 설정
│   └── configureStore.test.js # 스토어 테스트 코드
├── styles/                 # ✅ CSS 스타일 폴더
│   └── globals.css         # 글로벌 스타일
├── .babelrc                # Babel 설정 파일
├── .eslintrc               # ESLint 설정 파일
├── package-lock.json       # npm 의존성 잠금 파일
├── package.json            # 프로젝트 메타 정보 및 의존성
└── setupTests.js           # 테스트 환경 설정 파일
```


#### 1. 프로젝트만들기
```js
npm init
```
```
> 실습)
```
mkdir front
ls
cd front
npm init

#### 2. 프로그램설치
```
npm instaill
```
```js
- package.json

{
  "name": "front",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "dev": "next -p 3000",  // 3000 포트로 로컬개발
    "build": "cross-env ANALYZE=true NODE_ENV=production next build",   // 배포빌드
    "start": "cross-env NODE_ENV=production next start -p 3060",    // 배포 - 3060 포트실행
    "test": "jest"  // jest 활용해서 테스트코드 실행
  },
  "author": "sally",
  "license": "ISC",
  "dependencies": {
    "@ant-design/icons": "^4.3.0",  // ant design UI 라이브러리
    "@next/bundle-analyzer": "^12.3.4", // 사용하는 용량 - 시각분석도구
    "@reduxjs/toolkit": "^1.9.7",   // 전역저장공간
    "antd": "^4.8.6",
    "axios": "^1.3.4",  // 백엔드 api 서버와 통신하는 http 라이브러리
    "babel-plugin-styled-components": "^1.12.0",    // ssr환경 클래스명 충돌방지
    "bootstrap": "^5.3.8",  // 전반적인 웹스타일링
    "cross-env": "^7.0.2",  // 운영체제 상관없이 (window, mac, linux) 환경변수 설정
    "dotenv": "^16.0.1",    // 중요키
    "express": "^5.2.1",    // 웹서버
    "faker": "^4.1.0",      // 가짜데이터 무작위생성도구
    "immer": "^9.0.19",     // 코드 짧게 줄이기
    "jest": "^29.7.0",      // 테스트도구
    "moment": "^2.29.1",    // 날짜 및 시간데이터 포맷팅
    "next": "^12.3.4",      // react 에서 ssr 지원프레임워크
    "next-redux-wrapper": "^6.0.2", // 연결
    "pm2": "^4.5.0",            // 배포환경에서 node.js 프로세스 계속실행되게 관리
    "prop-types": "^15.7.2",    // 전달되는 props 타입 검사
    "react": "^17.0.2",
    "react-dom": "^17.0.2",     // 브라우저 dom 렌더링
    "react-redux": "^8.0.5",
    "react-slick": "^0.28.1",   // 이미지 슬라이더 및 캐러셀
    "redux": "^4.0.5",
    "redux-devtools-extension": "^2.13.8",
    "redux-saga": "^1.1.3",     // 비동기처리
    "shortid": "^2.2.16",       // 고유id
    "styled-components": "^5.2.1",  // css 작성가능하게
    "swr": "^0.3.9"
  },
  "devDependencies": {
    "@testing-library/jest-dom": "^6.0.0",
    "@testing-library/react": "12.1.5",
    "babel-eslint": "^10.1.0",
    "babel-jest": "^30.2.0",
    "eslint": "^7.14.0",
    "eslint-config-airbnb": "^18.2.1",
    "eslint-plugin-import": "^2.22.1",
    "eslint-plugin-jsx-a11y": "^6.4.1",
    "eslint-plugin-react": "^7.21.5",
    "eslint-plugin-react-hooks": "^4.2.0",
    "identity-obj-proxy": "^3.0.0",
    "jest-environment-jsdom": "^29.7.0",
    "nodemon": "^2.0.4",
    "webpack": "^5.65.0"
  },
  "jest": {
    "testEnvironment": "jsdom", // 테스트 가상환경 dom
    "setupFilesAfterEnv": [
      "<rootDir>/setupTests.js"
    ],
    "moduleNameMapper": {
      "\\.(css|less|scss|sass)$": "identity-obj-proxy",
      "\\.(jpg|jpeg|png|gif|webp|svg)$": "<rootDir>/__mocks__/fileMock.js"
    }
  }
}

```

#### 3. 서버진입점
```
front/
├── .next/                  # ✅ Next.js 빌드 결과물 (자동 생성, 배포 시 사용)
├── node_modules/           # ✅ 설치된 npm 패키지들
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   └── index.js            # 메인 페이지
├── package-lock.json       # npm 의존성 잠금 파일
└── package.json            # 프로젝트 메타 정보 및 의존성
```

1. [pages] - index.js
```
export default function Home() {
    return <h1>REACT PROJECT 정상실행</h1>;
}
```
2. 서버실행
```
npm run dev
```






### 2. 구조안내, 개발시작
```
front/
├── .next/                  # ✅ Next.js 빌드 결과물 (자동 생성, 배포 시 사용)
├── components/             # ✅ 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js           # 페이지 공통 레이아웃 컴포넌트
├── node_modules/           # ✅ 설치된 npm 패키지들
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── index.js            # 메인 페이지
│   ├── login.js            # 로그인 페이지
│   ├── signup.js           # 회원가입 페이지
│   └── users.js            # 사용자 목록 또는 정보 페이지 
├── reducers/               # ✅ Redux 리듀서 폴더
│   ├── index.js            # 루트 리듀서 (combineReducers)
│   ├── user.js             # 사용자 관련 리듀서
│   └── user.test.js        # 리듀서 테스트 코드
├── sagas/                  # ✅ Redux-Saga 폴더
│   ├── index.js            # 루트 사가
│   ├── user.js             # 사용자 관련 사가
│   └── user.test.js        # 사가 테스트 코드
├── store/                  # ✅ Redux 스토어 설정 폴더
│   ├── configureStore.js   # Redux 스토어 설정
│   └── configureStore.test.js # 스토어 테스트 코드
├── styles/                 # ✅ CSS 스타일 폴더
│   └── globals.css         # 글로벌 스타일
├── .babelrc                # Babel 설정 파일
├── .eslintrc               # ESLint 설정 파일
├── package-lock.json       # npm 의존성 잠금 파일
├── package.json            # 프로젝트 메타 정보 및 의존성
└── setupTests.js           # 테스트 환경 설정 파일
```


1. 각 구조만들기 (폴더생성)
2. 설정파일
front/
├── .babelrc                # Babel 설정 파일 : jsx → 일반 js로 변환 브라우저 이해할 수 있게
                                            최신문법( async/await, optional chaining 등 )
├── .eslintrc               # ESLint 설정 파일 : 일관된 코드스타일 유지 (들여쓰기, 세미콜론 , 따옴표 = 팀 규칙 쓰는 곳)
└── setupTests.js           # 테스트 환경 설정 파일 : 테스트환경 설정파일 환경초기

> setupTests.js
```
// 1. React Test Library - dom
import '@testing-library/jest-dom';

// 2. react 테스트 끝나면 cleanup 자동실행 - dom 정리
import { cleanup } from '@testing-library/react';
afterEach(() => {
  cleanup();
});
```

3. 글로벌 css
```
front/
├── styles/                 # ✅ CSS 스타일 폴더
│   └── globals.css         # 글로벌 스타일
```
```
/* styles/globals.css */
body {
  margin: 0;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Noto Sans KR', sans-serif;
  background-color: #f8f9fa; /* Bootstrap 기본 배경색 */
} 
```

4. page
```
front/
├── components/             # ✅ 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js           # 페이지 공통 레이아웃 컴포넌트
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── index.js            # 메인 페이지
```

1) [components] - Layout.js 공통틀 (헤더, 네비게이션, 푸터)
2) [pages]      - _app.js   모든 페이지들을 'Layout' 감싸는 진입점
3) [pages]      - index.js  본문콘텐츠

> _app.js   Layout 감싸서 영역안에 (children)
step1) localhost:3000 접속
step2) Layout에서의 헤더, 네비게이션, 푸터
step3) 본문영역 main.container 안에 콘텐츠 출력


##### 1) [components] - Layout.js 공통틀 (헤더, 네비게이션, 푸터)
```
```
##### 2) [pages]      - _app.js   모든 페이지들을 'Layout' 감싸는 진입점
```
```
##### 3) [pages]      - index.js  본문콘텐츠
```
```