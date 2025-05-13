# --- Stage 1: Build with Maven + JDK 11 ---
FROM maven:3.9.6-eclipse-temurin-11 AS builder

WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

# --- Stage 2: Run WAR using JDK 11 (standalone WAR case) ---
FROM eclipse-temurin:11-jre

WORKDIR /app
COPY --from=builder /app/target/customer-app-0.0.1-SNAPSHOT.war app.war

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.war"]
