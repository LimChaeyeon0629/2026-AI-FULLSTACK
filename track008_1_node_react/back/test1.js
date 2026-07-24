// 모델함수 테스트

const {createUser, findUserByEmail, findUserById,
    verifyUser, getAllUsers, updateUserNickname,
    deleteUser, findUserByNickname
    } = require('./models/users');

async function runTests() {
    try {
        // 1. 회원가입
        // await createUser('1@1', '1', '1', '01011111111', 1, '1.png');
        // console.log('✅ createUser 성공');
        
        // 2. 이메일로 조회
        // const userByEmail = await findUserByEmail('w@w');
        // console.log('✅ findUserByEmail 성공');
        
        const doubleCheck = await findUserByEmail('w@w');
        console.log('조회 결과:', doubleCheck);

        if(doubleCheck) {
            console.log('❌ findUserByEmail 이미 사용중인 이메일');
        } else {
            console.log('✅ findUserByEmail 사용 가능한 이메일~');
        }
        

    } catch(err) {
        console.error('❌테스트중 오류 발생', err); // window + .
    }
}

runTests();

// node test1.js