# 1. Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine

# 2. Set working directory inside container
WORKDIR /app

# 3. Copy the JAR file from target folder to container
COPY target/Student-management.jar app.jar

# 4. Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
