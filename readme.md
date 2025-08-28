# Nexum
**Version:** 1.1  
**Author:** Abhijeet Singh  
**Date:** [Insert Date]

---

## Introduction
Nexum is a **modular, scalable e-commerce backend** designed for **portfolio and learning purposes**.  
It includes a **Customer Application**, a **Seller Dashboard**, and a **non-redeemable in-app credit system**.

The project models **real-world backend complexity** while **omitting admin functionality in V1**.  
It is **AI-ready**, supporting **modern search features**, **social login**, and **caching**.

---

## Features

### Customer Module
- Register/Login via **email, phone, or Google OAuth2**
- Browse, search, and filter products
- **Smart search with auto-suggestions** (voice & image planned in V1.1+)
- Cart and checkout (**Razorpay integration**)
- Earn and redeem in-app credits
- Order tracking, returns, and **downloadable PDF invoices**

### Seller Module
- Register and access **Seller Dashboard**
- Add/edit/delete products with **media uploads**
- Manage stock, orders, and discounts
- Seller analytics & sales reporting

### Security & Authentication
- **Role-based access control:** `CUSTOMER`, `SELLER`
- **Stateless JWT authentication**
- **Google OAuth2 social login**

---

## Tech Stack
- **Backend:** Java 21, Spring Boot 3.2.x
- **Database:** PostgreSQL
- **Cache:** Redis
- **AI Layer:** Spring AI (for voice & image search)
- **Frontend:** Flutter Web *(external repo)*
- **Payment Gateway:** Razorpay API
- **File Storage:** Local (dev), AWS S3 (production optional)
- **Documentation:** Swagger/OpenAPI 3

---

## Architecture
- **Monolithic Spring Boot backend** with modular, feature-based structure
- Stateless authentication using **JWT**
- **Redis caching** for performance + rate-limiting
- **AI-ready design** (future integration with PGVector / Elasticsearch)
- **Docker-ready** for cloud deployment

---

## Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/abhijeet4725/Nexum.git
cd nexum
```
text

### 2. Configure Database & Cache
Set up **PostgreSQL** and **Redis**.

Configure `application.properties` or `.env` with:
- DB connection URL & credentials
- JWT secret key
- Razorpay API keys

### 3. Build the Project
```mvn clean install```


### 4. Run with Docker Compose
```docker compose up```


### 5. Access API Docs
Open Swagger UI:  
http://localhost:8080/swagger-ui.html


## Next Steps
- Add **voice & image search** (AI-powered)
- Optional **Elasticsearch integration**
- Deploy with **Docker + Cloud Provider**

---

## License
This project is for **educational & portfolio purposes**.  
Not intended for production use (yet).