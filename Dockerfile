# Build stage - could use maven or our image
FROM maven:3.3-jdk-8 as builder

COPY . .
RUN mvn clean install

FROM openliberty/open-liberty:springBoot2-ubi-min as staging

COPY --chown=1001:0 --from=builder /target/squad2-api-0.0.1-SNAPSHOT.jar squad2-api.jar

ENTRYPOINT ["java", "-jar","/squad2-api.jar"]