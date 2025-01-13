FROM ubuntu:latest AS build

# Atualiza e instala as dependências necessárias
RUN apt-get update && apt-get install -y openjdk-17-jdk maven

# Define o diretório de trabalho
WORKDIR /app

# Copia todos os arquivos para o contêiner
COPY . .

# Executa o build do projeto, ignorando os testes
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim
# Expõe a porta 8080
EXPOSE 8080

# Copia o arquivo JAR gerado no estágio de build
COPY --from=build /app/target/gestao_vagas-0.0.1-SNAPSHOT.jar app.jar

# Define o comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
