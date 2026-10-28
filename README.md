# Campus Library (GraphQL + Node.js + MySQL) 📚

A full-stack GraphQL application built according to the **CS543 · Web Services** tutorial specification:  
**HTML/CSS → GraphQL API (Node.js + Apollo Server) → MySQL Database**

---

## 🏗️ Architecture

```text
Browser (Front-end)  ──HTTP POST { query }──>  GraphQL API (Node + Apollo)  ──SQL──>  MySQL (Database)
[public/index.html]                             [server.js :4000]                      [gqldemo]
```

- **Frontend**: Plain HTML5, CSS3, and JavaScript sending standard GraphQL `fetch()` requests.
- **Backend**: Node.js standalone server with `@apollo/server` running on port `4000`.
- **Database**: MySQL database `gqldemo` with relational `authors` and `books` tables.

---

## 📂 Project Structure

```text
campus-library/
├── schema.sql           # Database schema & sample rows
├── db.js                # MySQL connection pool (mysql2/promise)
├── server.js            # GraphQL schema (typeDefs) + resolvers + Apollo Server
├── package.json         # Node.js dependencies
├── .env.example         # MySQL credentials template
├── public/
│   ├── index.html       # Web dashboard (query list + add book mutation)
│   └── style.css        # Clean styling
└── demo/                # (Optional) Java Spring Boot alternative implementation
```

---

## ⚙️ Quick Start

### 1. Prerequisites
- **Node.js**: v18 or newer (`node -v`)
- **MySQL Server**: Running on `localhost:3306` (`mysql --version`)

### 2. Set Up the MySQL Database
Log into MySQL and execute `schema.sql`:
```bash
mysql -u root -p < schema.sql
```
*(Or run the SQL statements inside `schema.sql` directly in MySQL Workbench / CLI).*

### 3. Install Dependencies
```bash
npm install
```

### 4. Configure Database Password
Copy `.env.example` to `.env` (this file is ignored by git to keep passwords private):
```bash
cp .env.example .env
```
Edit `.env` with your local MySQL password:
```env
DB_PASSWORD=your_mysql_password
```
*(Alternatively, you can export `DB_PASSWORD=your_password` in your terminal or edit `db.js`).*

### 5. Start the GraphQL API Server
```bash
npm start
# or: node server.js
```
The console will display:
```text
GraphQL API ready at http://localhost:4000/
```

### 6. Open the Web Frontend
Open `public/index.html` in your browser (e.g. using VS Code **Live Server** or double-clicking the file).  
The page will immediately fetch and display the authors and their books.

---

## 📜 GraphQL Operations

### Query: List Authors with Nested Books
```graphql
query {
  authors {
    name
    country
    books {
      title
      year
    }
  }
}
```

### Mutation: Add a New Book
```graphql
mutation {
  addBook(title: "GraphQL for Beginners", year: 2025, authorId: 2) {
    id
    title
    year
    author {
      name
    }
  }
}
```

---

## 👤 Author
**Bhupesh Kumar**  
GitHub: [@khatribhupesh1000](https://github.com/khatribhupesh1000)  
Email: [khatribhupesh1000@gmail.com](mailto:khatribhupesh1000@gmail.com)
