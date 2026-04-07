# Experiment 7 – Role-Based Authorization with Spring Boot

## Overview
This project implements Role-Based Access Control (RBAC) using Spring Boot and Spring Security.

## Tech Stack
- Java 17
- Spring Boot 3.2.0
- Spring Security (HTTP Basic Auth)
- Spring Data JPA
- H2 In-Memory Database
- Lombok

## Project Structure
```
src/
├── main/
│   ├── java/com/example/experiment7/
│   │   ├── config/SecurityConfig.java       ← Security rules & BCrypt
│   │   ├── controller/
│   │   │   ├── PublicController.java        ← /api/public/**
│   │   │   ├── UserController.java          ← /api/user/**
│   │   │   └── AdminController.java         ← /api/admin/**
│   │   ├── entity/User.java                 ← DB entity
│   │   ├── repository/UserRepository.java   ← JPA repository
│   │   ├── service/CustomUserDetailsService.java
│   │   └── Experiment7Application.java
│   └── resources/
│       ├── application.properties
│       └── data.sql                         ← Pre-loaded users
└── test/
```

## How to Run in IntelliJ IDEA
1. Open IntelliJ IDEA
2. File → Open → select the `experiment7` folder
3. Wait for Maven to download dependencies (bottom progress bar)
4. Open `Experiment7Application.java`
5. Click the green ▶ Run button
6. App starts at http://localhost:8080

## API Endpoints

| Endpoint | Access | Role Required |
|----------|--------|---------------|
| GET /api/public/hello | Public | None |
| GET /api/user/profile | Protected | USER or ADMIN |
| GET /api/admin/dashboard | Protected | ADMIN only |

## Test Users (pre-loaded)

| Username | Password | Role |
|----------|----------|------|
| user1 | user123 | ROLE_USER |
| admin1 | admin123 | ROLE_ADMIN |

## Postman Testing Guide

### Setup: Use Basic Auth in Postman
- Go to Authorization tab → Type: Basic Auth → enter username & password

### Test Cases:
1. **Public endpoint** – GET `http://localhost:8080/api/public/hello` (no auth) → 200 OK
2. **User profile** – GET `http://localhost:8080/api/user/profile` (user1/user123) → 200 OK
3. **User denied admin** – GET `http://localhost:8080/api/admin/dashboard` (user1/user123) → 403 Forbidden
4. **Admin dashboard** – GET `http://localhost:8080/api/admin/dashboard` (admin1/admin123) → 200 OK
5. **No auth** – GET `http://localhost:8080/api/user/profile` (no auth) → 401 Unauthorized

## H2 Database Console
Access at: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave blank)

## Authorization Rules
- 401 Unauthorized → No credentials provided
- 403 Forbidden → Valid credentials but insufficient role
