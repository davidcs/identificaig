# Etapa de construção
FROM ubuntu:latest AS build

# Atualiza pacotes e instala o JDK 17
RUN apt-get update && apt-get install openjdk-17-jdk maven -y

# Copia o conteúdo da aplicação para o contêiner
COPY . .

# Executa o Maven para compilar o projeto, sem rodar os testes
RUN mvn clean install -DskipTests

# Etapa de execução
FROM openjdk:17-jdk-slim

# Expõe a porta 8080
EXPOSE 8080

# Copia o JAR gerado da etapa de build para a imagem final
COPY --from=build /target/deploy_render-1.0.0.jar app.jar

# Define o comando de entrada para rodar o JAR
ENTRYPOINT [ "java", "-jar", "app.jar" ]
