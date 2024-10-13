# Projeto HotelEase - Backend (trabalho-api)

## Descrição

Este projeto é uma API RESTful desenvolvida em java utilizando o framework Spring Boot. O objetivo principal é gerenciar hóspedes em uma rede de hotéis, permitindo operações de criação, leitura, atualização e exclusão (CRUD). A API está documentada com Swagger para facilitar o entendimento e a integração com outros serviços. 

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Boot Starter web
- Spring Boot Starter Data JPA
- H2 Database
- Lombok
- MapStruct
- Sringdoc OpenAPI
- Therapi
- Jacoco
- Maven

## Pré-requisitos

- JDK 17
- Maven 3.8+
- Git

## Instalação

1. **Clone o repositório:**

     ```bash
     git clone https://link-do-repo.git
     ```

2. **Navegue até o diretório do projeto:**

      ```bash
     cd diretorio-do-projeto
     ```

3. **Configure o banco de dados:**

     Edite o arquivo [application.yaml](src/main/resources/application.yaml) com as configurações do seu banco de dados.

4. **Compile e execute o projeto:**

     ```bash
     mvn clean install
     mvn spring-boot:run
     ```

   A API estará disponível em `http://localhost:8080`.

## Documentação da API (Swagger)

A documentação da API pode ser acessada por meio do Swagger. Após iniciar o backend, você pode acessar a documentação por meio da seguinte URL:

[/swagger-ui/index.html](http://localhost:8080//swagger-ui/index.html)

## Endpoints

Abaixo está a descrição dos principais endpoints da API:


### **1. GET /api/hospede**

- **Descrição:** Retorna uma lista de hospedes.
- **Parâmetros de Consulta:**
  - `page` (opcional): Número da página.
  - `size` (opcional): Número de itens por página.
- **Resposta:**
  - **200 OK**
    ```json
    [
      {
        "id": 1,
        "name": "João",
        "email": "joao@exemplo.com",
        "phone": "123456789",
        "address": "Rua exemplo, 123",
        "birthDate": "1980-01-01",
        "checkIn": "2024-10-01",
        "checkOut": "2024-10-05"
        },
      // ...
    ]
    ```

### **2. POST /api/hospede**

- **Descrição:** Cria um novo hospede.
- **Corpo da Requisição:**
  ```json
  {
    "name": "Maria",
    "email": "maria@exemplo.com",
    "phone": "123456789",
    "address": "Rua exemplo, 123",
    "birthDate": "1982-01-01",
    "checkIn": "2024-10-01",
    "checkOut": "2024-10-05"
  }
  ```
- **Resposta:**
  - **201 Created**
    ```json
    {
      "id": 2,
      "name": "Maria",
      "email": "maria@exemplo.com",
      "phone": "123456789",
      "address": "Rua exemplo, 123",
      "birthDate": "1982-01-01",
      "checkIn": "2024-10-01",
      "checkOut": "2024-10-05"
    }
    ```

### **3. GET /api/hospede/{id}**

- **Descrição:** Retorna um hospede específico pelo ID.
- **Parâmetros de Caminho:**
  - `id`: ID do usuário.
- **Resposta:**
  - **200 OK**
    ```json
    {
      "id": 1,
      "name": "João",
      "email": "joao@exemplo.com",
      "phone": "123456789",
      "address": "Rua exemplo, 123",
      "birthDate": "1980-01-01",
      "checkIn": "2024-10-01",
      "checkOut": "2024-10-05"
    }
    ```
  - **404 Not Found** (se o usuário não for encontrado)

### **4. PUT /api/hospede/{id}**

- **Descrição:** Atualiza um hospede existente.
- **Corpo da Requisição:**
  ```json
    {
      "name": "João Atualizado",
      "email": "joaoatualizado@exemplo.com",
    }
  ```
- **Parâmetros de Caminho:**
  - `id`: ID do usuário.
- **Resposta:**
  - **200 OK**
    ```json
    {
      "id": 1,
      "name": "João Atualizado",
      "email": "joaoatualizado@exemplo.com"
    }
    ```
  - **404 Not Found** (se o usuário não for encontrado)

### **5. DELETE /api/hospede/{id}**

- **Descrição:** Remove um hospede pelo ID.
- **Parâmetros de Caminho:**
  - `id`: ID do usuário.
- **Resposta:**
  - **204 No Content**
  - **404 Not Found** (se o usuário não for encontrado)
