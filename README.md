# A First Hands-On GraphQL Tutorial (Node + Apollo + MySQL) 📚

CS543 · Web Services · GraphQL  
**Build one small app end to end — HTML/CSS → GraphQL (Node) → MySQL**

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
└── public/
    ├── index.html       # Web dashboard (query list + add book mutation)
    └── style.css        # Clean styling
```

---

## ⚙️ Quick Start

### 1. Prerequisites
- **Node.js**: v18 or newer (`node -v`)
- **MySQL Server**: Running on `localhost:3306` (`mysql --version`)

### 2. Set Up the MySQL Database
Log into MySQL and source `schema.sql`:
```bash
mysql -u root -p < schema.sql
```

### 3. Install Dependencies
```bash
npm install
```

### 4. Database Credentials
The connection is configured in `db.js`:
- **User**: `root`
- **Password**: `bUPESH100@`
- **Database**: `gqldemo`

### 5. Start the GraphQL API Server
```bash
node server.js
```
The terminal will display:
```text
GraphQL API ready at http://localhost:4000/
```

### 6. Run the Frontend
Open `public/index.html` in your browser (e.g. using VS Code **Live Server** or double-clicking the file).  
The page immediately displays all authors and their books fetched from the GraphQL API.

---

## 📜 GraphQL Operations

### 1. Query: List Authors with Nested Books
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

### 2. Mutation: Add a New Book
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
