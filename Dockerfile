# Etapa 1: Build
FROM maven:3.9.3-eclipse-temurin-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo pom.xml e baixa as dependências do projeto
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copia o código-fonte do projeto para o container
COPY src ./src

# Executa o Maven para construir o projeto
RUN mvn clean package -DskipTests

# Etapa 2: Executar a aplicação
FROM eclipse-temurin:17-jdk-alpine

# Define o diretório de trabalho para a aplicação no container
WORKDIR /app

# Copia o arquivo JAR gerado da etapa de build para o container
COPY --from=build /app/target/*.jar app.jar

# Define o comando para executar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expondo a porta 8080, que é a padrão de uma aplicação Spring Boot
EXPOSE 8080
