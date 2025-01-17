# ☕ Coffee Haven

> A premium coffee bean e-commerce platform built with Spring Boot and AI-powered recommendations

## 🌟 Features

### Customer Features
- Browse premium coffee bean catalog
- AI-powered coffee recommendations
- Shopping cart management
- Order tracking
- View order history

**Note:** The Shopping Cart and My Orders functionalities for the Customer's view has errors in them currently.

### Admin Features
- Inventory management
- Order status updates
- Stock monitoring
- Product catalog maintenance

## 🛠️ Tech Stack

### Backend
- Java 17
- Spring Boot 3.4.1
- Spring Security
- Spring Data JPA 
- MySQL Database
- Groq AI API

### Frontend
- Thymeleaf
- Bootstrap 5
- JavaScript
- Font Awesome


## 🚀 Quick Start

### Prerequisites
- Java 17
- Maven 
- MySQL

### Installation

1. Clone the repository
```bash
git clone https://github.com/yourusername/coffee-haven.git
```

2. Configure database

Make a MySQL database called 'coffeehavenDB'.
```bash
# src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/coffeehavenDB
spring.datasource.username=root
spring.datasource.password=password
```

3. Set environment variables
```bash
set GROQ_API_KEY=your_api_key_here
```

4. Build and run
```bash
mvn clean install
mvn spring-boot:run
```

5. Access the application at http://localhost:8080

## ✨ Contributors
Java Brewers Team (Radowan, Ahmed, Rafi, Mouaz) - Studnts of UTM KL



<p align="center">Made with ❤️ by Java Brewers</p>


