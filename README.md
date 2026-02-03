# GadgetStock API

A RESTful API built with **Spring Boot 4.0.1** and **Java 21** for managing gadgets inventory. This project implements a clean 3-layer architecture (Controller/Service/Repository) following enterprise Java best practices.

## 🚀 Technologies

- **Java 21** (LTS)
- **Spring Boot 4.0.1**
- **Spring Data JPA** (Hibernate)
- **MySQL 5.5+**
- **Maven** (dependency management)
- **Swagger/OpenAPI** (API documentation)

## 📋 Features

- Full CRUD operations for gadgets
- Search gadgets by name
- RESTful API design
- Interactive API documentation with Swagger UI
- Clean architecture with separation of concerns

## 🏗️ Architecture
┌─────────────────┐
│ Controller │ ← HTTP requests/responses (Presentation Layer)
└────────┬────────┘
│
┌────────▼────────┐
│ Service │ ← Business logic
└────────┬────────┘
│
┌────────▼────────┐
│ Repository │ ← Data access (JPA/Hibernate)
└────────┬────────┘
│
┌────────▼────────┐
│ MySQL DB │ ← Persistence
└─────────────────┘


## 🔌 API Endpoints

| Method | Endpoint             | Description              |
|--------|---------------------|--------------------------|
| GET    | `/gadget`           | Get all gadgets          |
| POST   | `/gadget`           | Create a new gadget      |
| PUT    | `/gadget`           | Update an existing gadget|
| GET    | `/gadget/find?name={name}` | Search gadgets by name |

## 📦 Installation

### Prerequisites

- JDK 21 or higher
- MySQL 5.5+
- Maven 3.6+
- XAMPP (or any MySQL server)

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/Perdomazo/GadgetStock.git
   cd GadgetStock
2. **Create the database**
CREATE DATABASE ProjectGadgets;

3. **Configure database connection**
Edit src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/ProjectGadgets
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
server.port=8081

4. **Build and run**
mvn clean install
mvn spring-boot:run
Or run directly from IntelliJ IDEA.

5. **Build and run**
Base URL: http://localhost:8081
Swagger UI: http://localhost:8081/swagger-ui.html

### Usage Examples
Create a Gadget
curl -X POST http://localhost:8081/gadget \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Smartphone X",
    "brand": "TechCorp",
    "price": 599.99,
    "stock": 50
  }'

Get all gadgets
curl http://localhost:8081/gadget

Search by name
curl "http://localhost:8081/gadget/find?name=Smartphone"

### 🧪 Testing
Test the API using:

Swagger UI: http://localhost:8081/swagger-ui.html
Postman: Import the endpoints manually
cURL: See usage examples above

###📂 Project Structure
src/
├── main/
│   ├── java/com/perdomazo/firstproject/
│   │   ├── Controllers/       # REST controllers (presentation layer)
│   │   ├── Services/          # Business logic
│   │   ├── Repositories/      # Data access layer
│   │   ├── Models/            # Entity classes
│   │   └── FirstprojectApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/

### Next Steps
 Add DELETE endpoint
 Add GET by ID endpoint
 Implement input validation
 Add exception handling
 Create DTOs for request/response
 Add unit tests
 Implement Spring Security

### License
This project is for educational purposes.

### Author
Perdomazo
GitHub: @Perdomazo


