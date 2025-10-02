# 🐱‍👤 Pokémon API

This project is a **Spring Boot REST API** to manage Pokémon with CRUD operations.  
It uses **PostgreSQL** as the database, is **Docker-ready**, and includes **Swagger/OpenAPI** documentation.

---

## 🚀 Features
- Spring Boot 3 (REST API)
- PostgreSQL database integration
- JPA / Hibernate
- JSON column support
- Docker & Docker Compose setup
- Swagger UI for API documentation

---

## 📦 Requirements
Make sure you have installed:
- Java 17+
- Maven 3+
- Docker & Docker Compose
- PostgreSQL (if not using Docker)

---

## ⚙️ Environment Variables
The application uses a `.env` file. Example:

```properties
DB_HOST=
DB_PORT=
DB_NAME=
DB_USER=
DB_PASSWORD=

SPRING_PORT=
```
---
## 🛠️ Build & Run
### Run with Maven
``` cmd
mvn spring-boot:run
```
## Run with Docker

### Build the image:
```cmd
docker build -t pokemon-api .
```

### Start with Docker Compose:
``` cmd
docker-compose up -d
```
### 🔗 API Endpoints

| Method | Endpoint            | Description             |
| ------ |---------------------|-------------------------|
| GET    | `/pokemon/{name}`   | Get Pokémon by Name     |

### 📖 Swagger UI

Once the project is running, access Swagger at:

👉 http://localhost:8080/swagger-ui.html

There you can explore all endpoints, request/response examples, and test directly.

### 🗄️ Database

If you run PostgreSQL locally:
```bash
psql -U postgres -d Pruebas_Java
```


Or via Docker Compose, the container postgres will be started automatically with the credentials in .env.

## 📂 Project Structure
```
src/main/java/com/tecknei/pokemon
│── controllers/    # REST Controllers
│── dto/            # Data Transfer Objects
│── repository/     # Spring Data Repositories
│── config/         # Configurations (Swagger, Cors, etc.)
│── converters/     # converters
│── models/         # JPA Entities
│── services/       # services

```
# PostgreSQL Tables

### Table pokemon_cat: 
```sql
CREATE TABLE IF NOT EXISTS public.pokemon_cat
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    species character varying(255) COLLATE pg_catalog."default",
    type character varying(255) COLLATE pg_catalog."default",
    skills jsonb,
    attacks jsonb,
    statistics jsonb,
    img bytea,
    CONSTRAINT pokemon_cat_pk PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pokemon_cat
    OWNER to postgres;

REVOKE ALL ON TABLE public.pokemon_cat FROM user_test;

GRANT ALL ON TABLE public.pokemon_cat TO postgres;

GRANT DELETE, UPDATE, INSERT, SELECT ON TABLE public.pokemon_cat TO user_test;
```
