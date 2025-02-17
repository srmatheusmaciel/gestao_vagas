# Gestao Vagas API

## Descrição

Gestao Vagas é uma API desenvolvida com Spring Boot para gerenciar vagas de emprego. Ele oferece funcionalidades para autenticacao, cadastro, listagem e gerenciamento de vagas, candidatos e empresas, utilizando um banco de dados PostgreSQL e seguranca com JWT.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.0**
- **Spring Security** (JWT para autenticacao)
- **Spring Data JPA** (persistencia de dados)
- **PostgreSQL** (banco de dados)
- **H2 Database** (para testes)
- **Lombok** (para reduzir codigo boilerplate)
- **Springdoc OpenAPI** (documentacao da API com Swagger)
- **Prometheus & Actuator** (monitoramento da aplicacao)
- **JUnit & Spring Security Test** (testes unitarios e de seguranca)

## Funcionalidades

- **Autenticacao e Autorizacao:** Utilizacao de JWT para seguranca dos endpoints.
- **Gerenciamento de Vagas:** Criacao e listagem de vagas.
- **Cadastro e Gerenciamento de Empresas:** Registro e administracao de empresas.
- **Cadastro e Gerenciamento de Candidatos:** Registro e listagem de candidatos.
- **Associacao de Vagas a Empresas:** Permite vincular vagas a empresas especificas.
- **Testes Automatizados:** Implementacao de testes com JUnit e Spring Security Test.
- **Monitoramento:** Integracao com Prometheus e Actuator para metricas da aplicacao.
- **Documentacao da API:** Integracao com Springdoc OpenAPI para geracao automatica da documentacao via Swagger.

## Como Executar o Projeto

### Pre requisitos

- Java 17+
- Maven 3+
- PostgreSQL configurado

### Configuração do Banco de Dados

Configure o arquivo `application.properties` com as credenciais do seu banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gestao_vagas
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### Executando o Projeto

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/gestao_vagas.git
   ```
2. Acesse a pasta do projeto:
   ```sh
   cd gestao_vagas
   ```
3. Compile e execute a aplicacao:
   ```sh
   mvn spring-boot:run
   ```
4. A aplicação estará disponível em `http://localhost:8080`

## Endpoints Principais

### Autenticação

- `POST /candidate/auth/` - Realiza login e retorna o token JWT
- `POST /company/auth/` - Realiza login e retorna o token JWT

### Empresas

- `POST /company` - Cria uma nova empresa

### Vagas

- `GET /company/job"` - Lista todas as vagas
- `POST /company/job` - Cria uma nova vaga (requer autenticacao)

### Candidatos

- `GET /candidate` - Lista todos os candidatos
- `POST /candidate` - Cria novos candidatos

### Monitoramento

- `GET /actuator/health` - Verifica a saude da aplicacao
- `GET /actuator/prometheus` - Exibe metricas para Prometheus

## Testes

Para executar os testes, utilize:

```sh
mvn test
```

## Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Fork o repositório
2. Crie um branch para sua feature: `git checkout -b minha-feature`
3. Faça commit das mudanças: `git commit -m 'Adiciona minha feature'`
4. Faça push para o branch: `git push origin minha-feature`
5. Abra um Pull Request

## Licença

Este projeto esta sob a licença MIT. Para mais detalhes, consulte o arquivo `LICENSE`.

