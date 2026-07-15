// Oracle DB 설정

require('dotenv').config();

console.log('DB_USER:', process.env.DB_USER);
console.log('DB_PASSWORD 존재:', !!process.env.DB_PASSWORD);
console.log('DB_CONNECT:', process.env.DB_CONNECT);

module.exports={
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    connectString: process.env.DB_CONNECT
};
// config/db.js