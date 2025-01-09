# Estágio de build
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copia os arquivos necessários para o build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .
RUN mvn clean package -DskipTests

# Estágio de execução
FROM openjdk:17-jdk-slim
WORKDIR /app
EXPOSE 8080

# Copia o artefato gerado no estágio de build
COPY --from=build /app/target/gestao_vagas-0.0.1-SNAPSHOT.jar app.jar

# Define o ponto de entrada da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
