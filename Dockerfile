
FROM ubuntu:latest AS build


ENV DEBIAN_FRONTEND=noninteractive


RUN apt-get update && apt-get install -y openjdk-17-jdk maven


WORKDIR /app


COPY pom.xml .


RUN mvn dependency:go-offline


COPY . .


RUN mvn clean install


FROM openjdk:17-jdk-slim


EXPOSE 8082


COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

