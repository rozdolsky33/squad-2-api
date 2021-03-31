FROM openjdk:8-jdk-alpine

VOLUME /tmp

COPY target/squad2-api-0.0.1-SNAPSHOT.jar squad2-api.jar

ENTRYPOINT ["java", "-jar","/squad2-api.jar"]