# Use a lightweight base image with JDK 11
FROM openjdk:11-jdk-slim

# Set working directory in the container
WORKDIR /app

# Copy JAR file into the container
COPY target/review-service-1.0-SNAPSHOT-jar-with-dependencies.jar review-service.jar

# Expose the service port
EXPOSE 50055

# Command to run the application
ENTRYPOINT ["java", "-jar", "review-service.jar"]
