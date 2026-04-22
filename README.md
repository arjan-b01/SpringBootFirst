# Task Management API – Spring Boot

A production-ready REST API built with Spring Boot that demonstrates clean backend architecture, JWT authentication, role-based access control, and PostgreSQL integration.

---

## Key Features

- Full CRUD for Users and Tasks  
- JWT-based authentication with Spring Security  
- Role-Based Access Control (ADMIN / USER)  
- Pagination for scalable APIs  
- DTO-based architecture (clean separation from entities)  
- Custom Exception Handling using Global Exception Handler (@RestControllerAdvice) 
- JPA relationships (User ↔ Tasks)  
- Structured and consistent API responses  

---

## Tech Stack

- Java  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Spring Security + JWT  
- PostgreSQL  
- Maven  

---

## API Highlights

### Authentication
- `POST /api/auth/login`

### Users (Protected)
- `GET /api/_users`
- `GET /api/_users/{id}`
- `GET /api/_users/{id}/tasks`
- `POST /api/_users` (ADMIN)
- `DELETE /api/_users/{id}` (ADMIN)
- `PUT /api/_users/{id}`

### Tasks (Protected)
- `POST /api/tasks/{userID}`

---

## Security

- JWT-based authentication  
- Stateless session management  
- Public endpoints: `/api/auth/**`  
- Protected endpoints: `/api/users/**`

Roles:
- **ADMIN** → Creates/Deletes Users 
- **USER** →  View Users and Create Tasks

---

## Run Locally

```bash
mvn clean install
mvn spring-boot:run
```

Configure PostgreSQL in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/user_management_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

---

## Why This Project Matters

This project demonstrates:

- Real-world backend design with layered architecture  
- Secure API development using JWT  
- Clean code practices using DTOs  
- Handling production concerns like pagination and exceptions  

---

## Future Improvements
- Testing using JUnit5 and Mockito
- Search and filtering (status, due date, etc.)  
- Swagger/OpenAPI documentation  
- Docker deployment  
- Advanced role/permission system  

---

## Author

Arjan A Bhargava
