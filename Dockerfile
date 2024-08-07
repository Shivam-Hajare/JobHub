# Use an official JDK as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file into the container
COPY target/JobHub-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/application.properties /app/application.properties

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
