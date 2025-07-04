# Guia de Uso da API

Este documento descreve como usar a API do Sistema de Gerenciamento de Tarefas.

A URL base da API é `http://localhost:8081`.

## 1. Gerenciamento de Tarefas (`/api/tasks`)

Endpoints para criar, listar, visualizar, atualizar e remover tarefas.

### 1.1. Criar uma nova tarefa

*   **Método:** `POST`
*   **Endpoint:** `/api/tasks`
*   **Corpo da Requisição (JSON):**
    ```json
    {
      "title": "Título da Tarefa",
      "description": "Descrição detalhada da tarefa.",
      "dueDate": "YYYY-MM-DD",
      "completed": false
    }
    ```
*   **Exemplo com `curl`:**
    ```bash
    curl -X POST http://localhost:8081/api/tasks \
    -H "Content-Type: application/json" \
    -d '{"title":"Documentar a API","description":"Criar o arquivo USAGE.md","dueDate":"2025-07-05","completed":false}'
    ```

### 1.2. Listar todas as tarefas

*   **Método:** `GET`
*   **Endpoint:** `/api/tasks`
*   **Exemplo com `curl`:**
    ```bash
    curl http://localhost:8081/api/tasks
    ```

### 1.3. Obter uma tarefa por ID

*   **Método:** `GET`
*   **Endpoint:** `/api/tasks/{id}`
*   **Exemplo com `curl` (para ID 1):**
    ```bash
    curl http://localhost:8081/api/tasks/1
    ```

### 1.4. Atualizar uma tarefa

*   **Método:** `PUT`
*   **Endpoint:** `/api/tasks/{id}`
*   **Corpo da Requisição (JSON):**
    ```json
    {
      "title": "Novo Título",
      "description": "Nova descrição",
      "dueDate": "YYYY-MM-DD",
      "completed": true
    }
    ```
*   **Exemplo com `curl` (para ID 1):**
    ```bash
    curl -X PUT http://localhost:8081/api/tasks/1 \
    -H "Content-Type: application/json" \
    -d '{"title":"Documentar a API (Concluído)","description":"Criar o arquivo USAGE.md e validar endpoints.","dueDate":"2025-07-05","completed":true}'
    ```

### 1.5. Deletar uma tarefa

*   **Método:** `DELETE`
*   **Endpoint:** `/api/tasks/{id}`
*   **Exemplo com `curl` (para ID 1):**
    ```bash
    curl -X DELETE http://localhost:8081/api/tasks/1
    ```


## 2. Gerenciamento de Usuários (`/api/users`)

Endpoints para criar, listar, visualizar, atualizar e remover usuários.

### 2.1. Criar um novo usuário

*   **Método:** `POST`
*   **Endpoint:** `/api/users`
*   **Corpo da Requisição (JSON):**
    ```json
    {
      "username": "nome_de_usuario",
      "password": "uma_senha_forte",
      "role": "USER"
    }
    ```
*   **Exemplo com `curl`:**
    ```bash
    curl -X POST http://localhost:8081/api/users \
    -H "Content-Type: application/json" \
    -d '{"username":"cristian","password":"password123","role":"ADMIN"}'
    ```

### 2.2. Listar todos os usuários

*   **Método:** `GET`
*   **Endpoint:** `/api/users`
*   **Exemplo com `curl`:**
    ```bash
    curl http://localhost:8081/api/users
    ```

### 2.3. Obter um usuário por ID

*   **Método:** `GET`
*   **Endpoint:** `/api/users/{id}`
*   **Exemplo com `curl` (para ID 1):**
    ```bash
    curl http://localhost:8081/api/users/1
    ```

### 2.4. Atualizar um usuário

*   **Método:** `PUT`
*   **Endpoint:** `/api/users/{id}`
*   **Corpo da Requisição (JSON):**
    ```json
    {
      "username": "novo_usuario",
      "password": "nova_senha",
      "role": "USER"
    }
    ```
*   **Exemplo com `curl` (para ID 1):**
    ```bash
    curl -X PUT http://localhost:8081/api/users/1 \
    -H "Content-Type: application/json" \
    -d '{"username":"cristian_m","password":"new_password","role":"USER"}'
    ```

### 2.5. Deletar um usuário

*   **Método:** `DELETE`
*   **Endpoint:** `/api/users/{id}`
*   **Exemplo com `curl` (para ID 1):**
    ```bash
    curl -X DELETE http://localhost:8081/api/users/1
    ```


## 3. Gerenciamento de Projetos (`/api/projects`)

Endpoints para criar, listar, visualizar, atualizar e remover projetos.

### 3.1. Criar um novo projeto

*   **Método:** `POST`
*   **Endpoint:** `/api/projects`
*   **Corpo da Requisição (JSON):**
    ```json
    {
      "name": "Nome do Projeto",
      "description": "Descrição detalhada do projeto."
    }
    ```
*   **Exemplo com `curl`:**
    ```bash
    curl -X POST http://localhost:8081/api/projects \
    -H "Content-Type: application/json" \
    -d '{"name":"Projeto de Monitoramento","description":"Implementar um sistema de monitoramento."}'
    ```

### 3.2. Listar todos os projetos

*   **Método:** `GET`
*   **Endpoint:** `/api/projects`
*   **Exemplo com `curl`:**
    ```bash
    curl http://localhost:8081/api/projects
    ```

### 3.3. Obter um projeto por ID

*   **Método:** `GET`
*   **Endpoint:** `/api/projects/{id}`
*   **Exemplo com `curl` (para ID 1):**
    ```bash
    curl http://localhost:8081/api/projects/1
    ```

### 3.4. Atualizar um projeto

*   **Método:** `PUT`
*   **Endpoint:** `/api/projects/{id}`
*   **Corpo da Requisição (JSON):**
    ```json
    {
      "name": "Novo Nome do Projeto",
      "description": "Nova descrição do projeto."
    }
    ```
*   **Exemplo com `curl` (para ID 1):**
    ```bash
    curl -X PUT http://localhost:8081/api/projects/1 \
    -H "Content-Type: application/json" \
    -d '{"name":"Projeto de Monitoramento (Atualizado)","description":"Atualizar o sistema de monitoramento."}'
    ```

### 3.5. Deletar um projeto

*   **Método:** `DELETE`
*   **Endpoint:** `/api/projects/{id}`
*   **Exemplo com `curl` (para ID 1):**
    ```bash
    curl -X DELETE http://localhost:8081/api/projects/1
    ```
