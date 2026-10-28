// db.js -- one shared connection pool to MySQL
try {
  require('dotenv').config();
} catch (e) {}

const mysql = require('mysql2/promise');

const pool = mysql.createPool({
  host: process.env.DB_HOST || 'localhost',
  user: process.env.DB_USER || 'root',
  password: process.env.DB_PASSWORD || 'YOUR_MYSQL_PASSWORD',
  database: process.env.DB_NAME || 'gqldemo',
});

module.exports = pool;
