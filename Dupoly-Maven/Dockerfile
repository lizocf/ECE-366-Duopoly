FROM maven:3.9.6-eclipse-temurin-21 AS build
ADD . /project
WORKDIR /project
RUN mvn -e -Dmaven.test.skip package

FROM eclipse-temurin:latest
COPY --from=build /project/target /app/target
ENTRYPOINT java -jar /app/target/Dupoly-Maven-1.0-SNAPSHOT.jar