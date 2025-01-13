FROM ubuntu:latest AS build

# Atualiza pacotes e instala Java 17
RUN apt-get update && apt-get install -y openjdk-17-jdk maven

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto para a imagem
COPY . .

# Compila o projeto com Maven, ignorando os testes
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim

# Define a porta exposta
EXPOSE 8080

# Copia o arquivo JAR gerado para a nova imagem
COPY --from=build /app/target/gestao_vagas-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
