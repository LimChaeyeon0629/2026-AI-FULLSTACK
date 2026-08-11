// sagas/index.js

// all: 묶어주기, fork: 비동기
import { all, fork } from 'redux-saga/effects';

import authSaga from './authSaga';
import postSaga from './postSaga';
// import commentSaga from './commentSaga';

export default function* rootSage() {
    yield all([
        fork( authSaga ),
        fork( postSaga ),
        // fork( commentSaga ),
    ]);
}

// fork : 기다리지 않음 (다른 일을 할 수 있게 양보)     - 동시에 실행
// call : 기다림 (어떠한 일이 끝날 때까지 기다리기)     - 결과물 필수적