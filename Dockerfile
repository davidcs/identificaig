# Etapa de construção
FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y openjdk-17-jdk maven

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean install -DskipTests

# Etapa de execução
FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

# Defina variáveis de ambiente (substitua pelos valores reais)
ENV DATABASE_URL=jdbc:postgres://dpg-crmcgo23esus73fqv200-a:5432/potencial_ig
ENV DATABASE_USERNAME=admin
ENV DATABASE_PASSWORD=7ceZef7YUfCnSnIsKV6OoXubBq75RwSs
ENV DATABASE_DRIVER_CLASS=org.postgresql.Driver

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
