// db.js -- one shared connection pool to MySQL
const mysql = require('mysql2/promise');

const pool = mysql.createPool({
  host: process.env.DB_HOST || 'localhost',
  user: process.env.DB_USER || 'root',
  password: process.env.DB_PASSWORD || 'bUPESH100@',
  database: process.env.DB_NAME || 'gqldemo',
});

module.exports = pool;
