day001

 ## Part001 
- TODO1:  GITHUB

■ 1. git, github
- git : 내 컴퓨터에서 파일의 변화를 기록
- github : 협업 시 저장공간

■ 2. 실습
1. Git 설치
   - [Git 공식 사이트](https://git-scm.com)에서 다운로드 후 설치.
   https://git-scm.com
   터미널 체크 후 설치
   - 설치 후 git --version 으로 정상 설치 확인.

 
2. 사용자 정보 설정
   git config --list
   git config --global user.name "LimChaeyeon0629"
   git config --global user.email "ssjm0629@gmail.com"
   git config --list

 
3. GitHub 계정 준비
  - GitHub 회원가입 및 로그인.
  - 새 레포지토리(repository) 생성.                   


4. 레포지토리 연결
   - 새 컴퓨터에서 원하는 폴더로 이동 후: 
     git clone https://github.com/아이디/레포지토리명.git

     cd D:\lcy
     git clone https://github.com/LimChaeyeon0629/2026-AI-FULLSTACK.git
     ( lcy 폴더에 2026-AI-FULLSTACK 파일 생성 확인 )
     5번으로


- 이미 만든 프로젝트를 올리고 싶다면: 
  git init
  git remote add origin https://github.com/아이디/레포지토리명.git 

 
5. 작업 파일 올리기
   git add .
   git commit -m "README" ("첫 커밋 메시지")
   git push origin main
   ( 깃허브 새로고침 README.md 파일 확인 )
   // git commit -m "track001-github-setting"

   2026-AI-FULLSTACK 파일 안에
   - track001_git
   - track002_html
   - track003_java 파일 생성

   ⚠️ 여기서 main 대신 master 일 수도 있으니, 
   레포지토리 기본 브랜치 이름 확인 필요.
 
 
6. gitinore
- Git에게 “이건 안 가져가도 돼!”라고 알려주는 메모지

- Git = 장난감상자 (모든 장난감을  넣어두는 곳)  
- 파일들 = 장난감들  
- .gitignore - “이 장난감은 상자에 넣지 마!”라고 붙여둔 스티커   


※ vs code 설치
   track001_git -> 001_setting.md
   Markdown Preview Enhanced 설치 (우클릭)
   Ctrl + `

--- 
 ## Part002 
- TODO2: 마크다운 문법

# 제목 ( 제일 큰 제목 )
## 중간제목
### 작은제목
#### step4
##### step5
###### step6

나나나~