# 2. Desenvolvimento da Aplicação de Exemplo

Esta seção contém os recursos necessários para o desenvolvimento da aplicação web Java de exemplo que será monitorada.

Atualmente o projeto possui uma implementação básica de CRUD para tarefas e projetos, servindo como ponto de partida para as próximas etapas.

## Estrutura

- **[2.1-configuracao-spring-boot](./2.1-configuracao-spring-boot)**: Configuração inicial do projeto Spring Boot
- **[2.2-modelo-dados](./2.2-modelo-dados)**: Implementação do modelo de dados e repositórios
- **[2.3-camada-servico](./2.3-camada-servico)**: Implementação da camada de serviço
- **[2.4-api-rest](./2.4-api-rest)**: Implementação da API REST
- **[2.5-interface-web](./2.5-interface-web)**: Implementação da interface web

## Tarefas

### 2.1. Configuração do Projeto Spring Boot
- Criar projeto com Spring Initializr
  - Adicionar dependências: Web, JPA, Security, Actuator
  - Configurar arquivo pom.xml com versões adequadas
- Configurar banco de dados PostgreSQL
  - Criar script de inicialização do banco
  - Configurar datasource no application.properties

### 2.2. Implementação do Modelo de Dados
- Criar entidades básicas:
  - User (usuário do sistema)
  - Project (projeto)
  - Task (tarefa)
  - Report (relatório)
- Implementar repositórios JPA para cada entidade
- Configurar mapeamento objeto-relacional

### 2.3. Implementação da Camada de Serviço
- Criar serviços para operações CRUD
  - UserService
  - ProjectService
  - TaskService
  - ReportService
- Implementar regras de negócio básicas
- Adicionar validações de dados

### 2.4. Implementação da API REST
- Criar controllers REST para cada entidade
  - UserController
  - ProjectController
  - TaskController
  - ReportController
- Implementar endpoints para operações CRUD
- Configurar segurança e autenticação com Spring Security
- Documentar API com Swagger/OpenAPI

### 2.5. Interface Web Simples
- Criar templates Thymeleaf para páginas principais
- Implementar formulários para criação/edição de entidades
- Criar páginas de listagem e detalhes
- Implementar autenticação e autorização na UI

## Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Thymeleaf
- Swagger/OpenAPI
