FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

FROM openjdk:17-jdk-slim
COPY --from=build /app/target/seu-app.jar /app/seu-app.jar
ENTRYPOINT ["java", "-jar", "/app/seu-app.jar"]
