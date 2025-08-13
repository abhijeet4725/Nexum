FROM openjdk:21-jdk-slim
WORKDIR /nexum
COPY target/nexum-0.0.1-SNAPSHOT.jar nexum.jar
EXPOSE 8080
CMD ["java", "-jar", "nexum.jar"]
