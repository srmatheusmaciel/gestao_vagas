# Gestão de Vagas - Spring Boot

Este repositório contém uma aplicação de **Gestão de Vagas** desenvolvida com o framework **Spring Boot**. A aplicação permite a gestão de candidatos para vagas de emprego, com funcionalidades para cadastro, atualização e visualização de candidatos e suas respectivas informações.

## Funcionalidades

- Cadastro de candidatos com informações como nome, email, username, senha, descrição e currículo.
- Validação de dados de entrada (como formato de email e senha).
- Criação e persistência dos dados no banco de dados **PostgreSQL**.

## Tecnologias

- **Java 17** - Linguagem de programação utilizada.
- **Spring Boot 3.x** - Framework principal para desenvolvimento de aplicações Java.
- **PostgreSQL** - Banco de dados utilizado para persistência de dados.
- **Docker** - Utilizado para criar e gerenciar o ambiente de banco de dados.
- **JPA (Hibernate)** - Utilizado para mapeamento objeto-relacional (ORM) com o banco de dados.
- **Lombok** - Biblioteca para simplificar o código Java, reduzindo a verbosidade.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter o seguinte instalado na sua máquina:

- [Java 17](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)

