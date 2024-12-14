# Use an official OpenJDK runtime as the base image
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/tracking-service-1.0-SNAPSHOT-jar-with-dependencies.jar tracking-service.jar

# Expose the service port
EXPOSE 50054

# Run the application
CMD ["java", "-jar", "tracking-service.jar"]

