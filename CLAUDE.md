# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Spring Boot 4.0.3 microservices template with 4 independent services. There is **no root parent pom.xml** — each service is a standalone Maven project that must be built and run independently.

## Services

| Service | Port | Package |
|---------|------|---------|
| `api-gateway-bff` | 8080 | `com.example.api_gateway_bff` |
| `master-service` | 8081 | `com.example.master_service` |
| `sub-service` | 8082 | `com.example.sub_service` |
| `notification-service` | 8083 | `com.example.notification_service` |

## Build & Run Commands

All commands must be run from within the specific service directory (e.g., `cd api-gateway-bff`).

```bash
./mvnw clean package          # Build JAR
./mvnw spring-boot:run        # Run the service
./mvnw test                   # Run all tests
./mvnw test -Dtest=ClassName  # Run a single test class
./mvnw clean install          # Build and install to local Maven repo
```

## Technology Stack

- **Java 17**, Spring Boot 4.0.3
- **Lombok** — used across all services for boilerplate reduction (`@Data`, `@Getter`, `@Setter`, etc.)
- **Spring Web MVC** — REST controllers
- **Spring Boot Test** (JUnit 5, MockMvc) — testing

## Architecture Notes

- The `api-gateway-bff` service is intended as the BFF (Backend for Frontend) entry point on port 8080; the other three services are backend services.
- No inter-service communication (RestTemplate, WebClient, FeignClient) is implemented yet — this is a template to build upon.
- No Docker or docker-compose setup exists — containerization must be added if needed.
- Package names use underscores (`api_gateway_bff`) because service directory names use hyphens, which are invalid in Java identifiers.
