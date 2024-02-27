FROM maven:3.9.6-eclipse-temurin-21 AS build
ADD . /project
WORKDIR /project
RUN mvn -e package

FROM eclipse-temurin:latest
COPY --from=build /project/target /app/target
ENTRYPOINT java -jar /app/target/jdbc_prep-1.0-SNAPSHOT.jar