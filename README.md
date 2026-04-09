# Budget Tracker API 💰

A personal finance REST API built with Java Spring Boot and Spring Data JPA. Manages multiple account types — checking, savings, credit card, and transactions — across a fully normalized PostgreSQL schema. Built independently after completing Tech Elevator to practice production-style backend API development using Spring Initializr and AI-assisted engineering workflows.

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java |
| Framework | Spring Boot |
| ORM | Spring Data JPA / Hibernate |
| Database | PostgreSQL |
| API | Spring Web MVC (REST) |
| Build Tool | Maven |

---

## Features

- **Account Management** — Full CRUD REST endpoints for checking accounts, savings accounts, and credit cards
- **Transaction Tracking** — Create, retrieve, update, and delete transactions linked to specific accounts
- **Account-Level Filtering** — Custom Spring Data query (`findByAccountType_AccountId`) returns all transactions for a given account
- **Relational Data Modeling** — Advanced JPA relationships including `@OneToOne` with shared primary key via `@MapsId` and `@ManyToOne` on transactions
- **Financial Precision** — All monetary values use `BigDecimal` to avoid floating-point rounding errors
- **Layered Architecture** — Clean separation across controller → service → repository → model layers

---

## Project Architecture

```
src/main/java/com/budget/budgettracker/
├── controller/     # REST controllers — HTTP request handling for each resource
├── service/        # Service layer — business logic between controllers and repositories
├── repository/     # JpaRepository interfaces — Spring Data query derivation
└── model/          # JPA entities — AccountType, CheckingAccount, SavingsAccount, CreditCard, Transaction
```

---

## Data Model

```
account_type
├── account_id   BIGINT PK (auto-generated)
└── name         VARCHAR(100)

checking_account
├── account_id   BIGINT PK → account_type(account_id)  [@OneToOne @MapsId]
└── total_amount DECIMAL(12,2)

savings_account
├── account_id   BIGINT PK → account_type(account_id)  [@OneToOne @MapsId]
└── total_amount DECIMAL(12,2)

credit_card
├── account_id   BIGINT PK → account_type(account_id)  [@OneToOne @MapsId]
└── total_due    DECIMAL(12,2)

transactions
├── transactions_id  BIGINT PK (auto-generated)
├── account_id       BIGINT → account_type(account_id)  [@ManyToOne]
├── transaction_date DATE
├── description      VARCHAR(100)
└── amount           DECIMAL(12,2)
```

---

## API Endpoints

### Account Types
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/account-types` | Get all account types |
| GET | `/api/account-types/{id}` | Get account type by ID |
| POST | `/api/account-types` | Create new account type |
| PUT | `/api/account-types/{id}` | Update account type |
| DELETE | `/api/account-types/{id}` | Delete account type |

### Checking Accounts
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/checking` | Get all checking accounts |
| GET | `/api/checking/{id}` | Get checking account by ID |
| POST | `/api/checking` | Create checking account |
| PUT | `/api/checking/{id}` | Update checking account balance |
| DELETE | `/api/checking/{id}` | Delete checking account |

### Credit Cards
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/credit-cards` | Get all credit cards |
| GET | `/api/credit-cards/{id}` | Get credit card by ID |
| POST | `/api/credit-cards` | Create credit card |
| PUT | `/api/credit-cards/{id}` | Update credit card balance |
| DELETE | `/api/credit-cards/{id}` | Delete credit card |

### Transactions
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/transactions` | Get all transactions |
| GET | `/api/transactions/{id}` | Get transaction by ID |
| GET | `/api/transactions/account/{accountId}` | Get all transactions for an account |
| POST | `/api/transactions` | Create transaction |
| PUT | `/api/transactions/{id}` | Update transaction |
| DELETE | `/api/transactions/{id}` | Delete transaction |

---

## Setup & Installation

### Prerequisites
- Java 17+
- Maven
- PostgreSQL
- pgAdmin or `psql` CLI

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/Romero-Greer/BudgetTracker.git
cd BudgetTracker
```

**2. Create the database**

Open pgAdmin and create a new database called `budget-app`, then run the provided SQL setup script to create the required tables.

**3. Configure your database connection**

Create `src/main/resources/application.properties` and add your credentials:

```properties
spring.application.name=budgettracker
spring.datasource.url=jdbc:postgresql://localhost:5432/budget-app
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
```

> `ddl-auto=validate` is used because the tables are created via the SQL script. JPA validates the schema on startup without modifying it.

**4. Run the application**
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

**5. Test the endpoints**

Use Postman or any REST client to hit the endpoints listed above.

---

## What I Learned

This project was built independently post-bootcamp to practice production-style backend development:

- **Spring Data JPA** — First project using JPA annotations and `JpaRepository` instead of raw JDBC, including advanced relationship patterns like `@OneToOne` with `@MapsId` for shared primary keys
- **ORM vs raw JDBC** — Experienced firsthand the tradeoff between the control of raw SQL (Couples Trivia Game) and the abstraction of Spring Data query derivation
- **BigDecimal for financial data** — Learned why `double` is inappropriate for monetary values and how `BigDecimal` prevents floating-point precision errors
- **Layered architecture** — Enforced strict separation between controller, service, repository, and model layers following production patterns
- **AI-assisted development** — Used Spring Initializr and AI tools to scaffold and accelerate backend development, practicing an AI-fluent engineering workflow

---

## Future Improvements

- [ ] Add Spring Security with JWT authentication
- [ ] Add a budget goal / monthly limit feature per account
- [ ] Build a React.js frontend to visualize spending
- [ ] Add summary endpoints (total balance across all accounts, monthly spending by category)
- [ ] Write unit and integration tests with JUnit and MockMvc

---

## Author

**Romero Greer**
[LinkedIn](https://www.linkedin.com/in/romero-greer/) · [GitHub](https://github.com/Romero-Greer)
