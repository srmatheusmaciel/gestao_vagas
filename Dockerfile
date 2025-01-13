FROM maven:3.9.0-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .

# Ignorar testes no build
RUN mvn clean install -DskipTests

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app
COPY --from=build /app/target/gestao_vagas-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
