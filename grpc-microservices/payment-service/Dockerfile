# Use an official OpenJDK runtime as the base image
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/payment-service-1.0-SNAPSHOT-jar-with-dependencies.jar payment-service.jar

# Expose the service port
EXPOSE 50053

# Run the application
CMD ["java", "-jar", "payment-service.jar"]
