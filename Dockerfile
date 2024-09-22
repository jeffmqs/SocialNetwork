
FROM maven:3.8.6-openjdk-17 AS build


WORKDIR /app


COPY pom.xml .

RUN mvn dependency:go-offline


COPY . .


RUN mvn clean install


FROM openjdk:17-jdk-slim


WORKDIR /app

EXPOSE 8082


COPY --from=build /app/target/jshare-0.0.1-SNAPSHOT.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]

