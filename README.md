# Campus Library Management System 📚

A modern, full-stack library management application powered by **Spring Boot**, **Spring for GraphQL**, **Spring Data JPA**, and **MySQL**, featuring an interactive web interface and integrated **GraphiQL** developer playground.

---

## 🚀 Features

- **GraphQL API**: Flexible schema with support for querying authors, books, and relational data trees without over-fetching.
- **Mutations**: Dynamically add books assigned to authors with immediate relationship persistence.
- **Integrated GraphiQL Playground**: In-browser interactive GraphQL IDE available at `/graphiql` for testing queries and mutations.
- **Built-in Web UI**: Responsive, lightweight dashboard served directly at `/index.html` allowing users to view authors, their books, and add new titles.
- **Auto Data Seeding**: Automatically seeds initial sample authors (*Asha Patel*, *Ravi Kumar*) and books on the first application startup.
- **Secure Configuration**: Production-ready configuration separating sensitive credentials from version control using local property overlays.

---

## 🛠️ Tech Stack

- **Language & Runtime**: Java 21
- **Framework**: Spring Boot 4.x
- **API Architecture**: Spring for GraphQL (GraphQL Java)
- **Persistence & ORM**: Spring Data JPA & Hibernate
- **Database**: MySQL 8.x / 9.x
- **Frontend**: Vanilla JavaScript (Fetch API), HTML5, CSS3
- **Build Tool**: Apache Maven (Maven Wrapper included)

---

## 📂 Project Structure

```text
CAMPUS LIBRARY/
├── .gitignore
├── README.md
└── demo/
    ├── pom.xml
    ├── mvnw
    ├── mvnw.cmd
    └── src/
        ├── main/
        │   ├── java/
        │   │   └── com/example/campuslibrary/
        │   │       ├── CampusLibraryApplication.java   # Main entry point & data seeder
        │   │       ├── controller/
        │   │       │   └── LibraryController.java      # GraphQL Query & Mutation mappings
        │   │       ├── model/
        │   │       │   ├── Author.java                 # Author JPA Entity
        │   │       │   └── Book.java                   # Book JPA Entity
        │   │       └── repository/
        │   │           ├── AuthorRepository.java       # JPA repository for authors
        │   │           └── BookRepository.java         # JPA repository for books
        │   └── resources/
        │       ├── application.properties              # Core configuration template
        │       ├── application-local.properties.example # Sample local credentials
        │       ├── graphql/
        │       │   └── schema.graphqls                 # GraphQL SDL schema definition
        │       └── static/
        │           ├── index.html                      # Frontend library dashboard
        │           └── style.css                       # Dashboard styling
        └── test/
```

---

## ⚙️ Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Version 21 or newer
- **MySQL Server**: Running on `localhost:3306`

### 1. Clone the Repository

```bash
git clone https://github.com/khatribhupesh1000/Campus-Library.git
cd Campus-Library/demo
```

### 2. Set Up the Database

Open your MySQL client or CLI and create the database:

```sql
CREATE DATABASE gqldemo;
```

### 3. Configure Credentials

To keep credentials secure, the repository does not track passwords. You have two options:

#### Option A: Using `application-local.properties` (Recommended)
Copy the template inside `demo/src/main/resources/`:
```bash
cp src/main/resources/application-local.properties.example src/main/resources/application-local.properties
```
Edit `src/main/resources/application-local.properties` and set your MySQL password:
```properties
spring.datasource.password=your_mysql_password
```

#### Option B: Using Environment Variables
Set the environment variable in your terminal or IDE:
```bash
export DB_PASSWORD="your_mysql_password"
```

---

## ▶️ Running the Application

### Via Maven Wrapper:
```bash
./mvnw spring-boot:run
```

### Via IDE (IntelliJ IDEA / Eclipse / VS Code):
Run the `main` method in:
`com.example.campuslibrary.CampusLibraryApplication`

---

## 🌐 Endpoints & Usage

Once started, the application runs on `http://localhost:8080`:

| Component | URL | Description |
| :--- | :--- | :--- |
| **Web Dashboard** | [http://localhost:8080/index.html](http://localhost:8080/index.html) | Interactive web page to view & add books |
| **GraphiQL Playground** | [http://localhost:8080/graphiql](http://localhost:8080/graphiql) | In-browser GraphQL query editor |
| **GraphQL Endpoint** | `POST http://localhost:8080/graphql` | API endpoint for client applications |

---

## 📜 Example GraphQL Operations

### 1. Query All Authors and Their Books

```graphql
query {
  authors {
    id
    name
    country
    books {
      id
      title
      year
    }
  }
}
```

### 2. Query All Books with Author Details

```graphql
query {
  books {
    id
    title
    year
    author {
      id
      name
      country
    }
  }
}
```

### 3. Query a Single Author by ID

```graphql
query {
  author(id: "1") {
    name
    country
    books {
      title
      year
    }
  }
}
```

### 4. Mutation: Add a New Book

```graphql
mutation {
  addBook(title: "Designing Data-Intensive Applications", year: 2017, authorId: "1") {
    id
    title
    year
    author {
      id
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
