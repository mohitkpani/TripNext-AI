# Stage 1 - Build
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copy Maven files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build application
RUN ./mvnw clean package -DskipTests

# Stage 2 - Run
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy jar from builder
COPY --from=builder /app/target/tripnext-0.0.1-SNAPSHOT.jar app.jar

# Railway/Render dynamic port
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]