# 4. Configuração da Infraestrutura Docker

Esta seção contém os recursos necessários para configurar a infraestrutura Docker para todos os componentes do sistema de monitoramento.

## Estrutura

- **[4.1-aplicacao-java](./4.1-aplicacao-java)**: Configuração do container Docker para a aplicação Java
- **[4.2-banco-dados](./4.2-banco-dados)**: Configuração do container Docker para o banco de dados PostgreSQL
- **[4.3-elk-stack](./4.3-elk-stack)**: Configuração dos containers Docker para o ELK Stack
- **[4.4-prometheus-grafana](./4.4-prometheus-grafana)**: Configuração dos containers Docker para Prometheus e Grafana
- **[4.5-docker-compose](./4.5-docker-compose)**: Configuração do Docker Compose para orquestração de todos os serviços

## Tarefas

### 4.1. Aplicação Java
- Criar Dockerfile para aplicação Spring Boot
  - Configurar multi-stage build para otimização
  - Adicionar healthchecks
- Configurar variáveis de ambiente para diferentes perfis

### 4.2. Banco de Dados
- Configurar container PostgreSQL
  - Criar volume para persistência de dados
  - Configurar script de inicialização
- Configurar backup automatizado

### 4.3. ELK Stack
- Configurar container Elasticsearch
  - Ajustar configurações de memória e JVM
  - Configurar volume para dados
  - Configurar templates de índice
- Configurar container Logstash
  - Criar pipeline para ingestão de logs da aplicação
  - Configurar filtros para enriquecimento de dados
  - Configurar outputs para Elasticsearch
- Configurar container Kibana
  - Configurar conexão com Elasticsearch
  - Configurar autenticação básica

### 4.4. Prometheus e Grafana
- Configurar container Prometheus
  - Criar arquivo prometheus.yml para scraping de métricas
  - Configurar volume para persistência
- Configurar container Grafana
  - Configurar datasources via provisioning
  - Configurar volume para dashboards e configurações
  - Configurar autenticação

### 4.5. Docker Compose
- Criar arquivo docker-compose.yml com todos os serviços
  - Definir dependências entre serviços
  - Configurar redes internas
  - Configurar volumes persistentes
- Criar arquivo .env para variáveis de ambiente
- Criar scripts de inicialização e shutdown

## Tecnologias Utilizadas

- Docker
- Docker Compose
- PostgreSQL
- Elasticsearch
- Logstash
- Kibana
- Prometheus
- Grafana
