FROM openjdk:21-jdk-slim
VOLUME /tmp
COPY target/voll.med-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
