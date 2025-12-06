
# ---------- STAGE 1 : Build the JAR using Maven ----------
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app

# Copy entire project
COPY . .

# Build Spring Boot JAR
RUN mvn -e -X clean package -DskipTests

# ---------- STAGE 2 : Run the JAR ----------
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
