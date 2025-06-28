# Use Java 17 base image
FROM openjdk:17
VOLUME /tmp

# Copy the JAR file into the container
COPY target/skillsync-backend-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "/app.jar"]
