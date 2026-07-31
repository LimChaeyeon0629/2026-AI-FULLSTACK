// reducers/index.js

import { combineReducers } from "@reduxjs/toolkit";
import authReducer from './authReducer';
import postReducer from './postReducer';

const rootReducer = combineReducers({
    auth: authReducer,  // state.auth 유저정보
    post: postReducer,  // state.post 글정보
    // comment: commentReducer,     // state.comment 코멘트정보
});

export default rootReducer;