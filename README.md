# SpringBoot-postgresql 🐘🌱

A small Spring Boot example that demonstrates CRUD operations against a PostgreSQL database.

This repo contains a simple user service implemented with Spring Data JPA and a REST controller.

Key files

- `src/main/java/com/example/springbootPostgresql/controllers/UserController.java` — REST endpoints for Users
- `src/main/java/com/example/springbootPostgresql/entity/UserEntity.java` — JPA entity
- `src/main/java/com/example/springbootPostgresql/repository/UserRepository.java` — Spring Data repository
- `src/main/resources/application.yaml` / `application.properties` — configuration

## Table of contents

- What this is
- Prerequisites
- Quick start (run locally)
- API endpoints & examples
- Configuration notes
- Development tips
- License

## What this is

A compact demo project showing how to wire Spring Boot + Spring Data JPA + PostgreSQL and expose a small REST API for user CRUD.

The controller mounts under `/api/users` and exposes endpoints to list, create, read, update and delete users.

## Prerequisites

- Java JDK matching the project configuration (see `pom.xml` property `java.version`).
  - The repo sets `<java.version>` in `pom.xml` (change or install matching JDK if necessary).
- Maven (or use the included Maven wrapper `./mvnw`).
- A running PostgreSQL instance.

## Quick start — run locally (fish shell examples)

1. Create a PostgreSQL database and user, for example:

```bash
# (run in psql)
# CREATE DATABASE springboot_demo;
# CREATE USER demo WITH ENCRYPTED PASSWORD 'demo_pass';
# GRANT ALL PRIVILEGES ON DATABASE springboot_demo TO demo;
```

2. Configure the datasource. You can either edit `src/main/resources/application.yaml` or set environment variables in your shell.

# Example using fish shell environment variables (temporary for current session):

```fish
set -x SPRING_DATASOURCE_URL "jdbc:postgresql://localhost:5432/springboot_demo"
set -x SPRING_DATASOURCE_USERNAME demo
set -x SPRING_DATASOURCE_PASSWORD demo_pass
./mvnw spring-boot:run
```

# SpringBoot-postgresql 🐘🌱

A small Spring Boot demo showing CRUD against PostgreSQL (users example).

Key files

- `src/main/java/com/example/springbootPostgresql/controllers/UserController.java` — REST endpoints
- `src/main/java/com/example/springbootPostgresql/entity/UserEntity.java` — JPA entity
- `src/main/java/com/example/springbootPostgresql/repository/UserRepository.java` — repository

## Table of contents

- What this is ✨
- Prerequisites 🧰
- Quick start ⚡
- API endpoints 🔌
- Configuration notes ⚙️
- Development tips 💡
- Where to look next 🔎
- License 📜

## What this is

Tiny example wiring Spring Boot + Spring Data JPA + PostgreSQL with a small REST API.

Controller base path: `/api/users` — list, create, read, update, delete.

## Prerequisites 🧰

- Java JDK (see `pom.xml` property `java.version`)
- Maven or use the wrapper `./mvnw`
- PostgreSQL running locally or remotely

## Quick start ⚡

1. Create a DB and user in psql:

```sql
CREATE DATABASE springboot_demo;
CREATE USER demo WITH ENCRYPTED PASSWORD 'demo_pass';
GRANT ALL PRIVILEGES ON DATABASE springboot_demo TO demo;
```

2. Run with fish env vars (temporary):

```fish
set -x SPRING_DATASOURCE_URL "jdbc:postgresql://localhost:5432/springboot_demo"
set -x SPRING_DATASOURCE_USERNAME demo
set -x SPRING_DATASOURCE_PASSWORD demo_pass
./mvnw spring-boot:run
```

Or build and run the JAR:

```fish
./mvnw -DskipTests package
java -jar target/springbootPostgresql-0.0.1-SNAPSHOT.jar
```

Run tests:

```fish
./mvnw test
```

## API endpoints 🔌

Base: `/api/users`

- GET `/api/users/getUsers` — list users
- POST `/api/users/createUser` — create user (JSON)
- GET `/api/users/getUserById/{id}` — get user
- PUT `/api/users/updateUser/{id}` — update user (JSON)
- DELETE `/api/users/deleteUser/{id}` — delete user

Example (create):

```bash
curl -X POST http://localhost:8080/api/users/createUser \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice","email":"alice@example.com"}'
```

## Configuration notes ⚙️

- Uses Spring Data JPA and Postgres driver (see `pom.xml`).
- Configure DB via `application.yaml`/`application.properties` or `SPRING_` env vars.
- Swagger UI (springdoc) available at `/swagger-ui/index.html` when running.

## Development tips 💡

- Use `./mvnw` for consistent builds.
- `spring-boot-devtools` is included for quick restarts.

## Where to look next 🔎

- Controller: `src/main/java/com/example/springbootPostgresql/controllers/UserController.java`
- Entity: `src/main/java/com/example/springbootPostgresql/entity/UserEntity.java`
- Repo: `src/main/java/com/example/springbootPostgresql/repository/UserRepository.java`

## License 📜

No license file included. Add `LICENSE` if needed.

---

## Quick conclusion ✨

Short and friendly: run the app, try the endpoints, and iterate. Want a Postgres `docker-compose` or a tiny integration test next? I can add it. Happy coding! 🚀
