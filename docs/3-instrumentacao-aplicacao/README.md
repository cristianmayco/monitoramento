# 3. Instrumentação da Aplicação

Esta seção contém os recursos necessários para instrumentar a aplicação Java com logs, métricas e aspectos para monitoramento.

## Estrutura

- **[3.1-configuracao-logs](./3.1-configuracao-logs)**: Configuração de logs estruturados
- **[3.2-metricas-micrometer](./3.2-metricas-micrometer)**: Implementação de métricas com Micrometer
- **[3.3-aspectos-monitoramento](./3.3-aspectos-monitoramento)**: Aspectos para monitoramento de métodos
- **[3.4-filtros-interceptores](./3.4-filtros-interceptores)**: Filtros e interceptores para monitoramento de requisições

## Tarefas

### 3.1. Configuração de Logs
- Configurar Logback com appenders apropriados
  - Configurar formato JSON para logs
  - Adicionar MDC para contexto de diagnóstico
- Implementar estratégia de logging consistente
  - Definir níveis de log apropriados
  - Adicionar logs em pontos estratégicos

### 3.2. Implementação de Métricas com Micrometer
- Adicionar dependência do Micrometer no pom.xml
- Configurar Prometheus como backend de métricas
- Criar métricas customizadas para:
  - Contagem de usuários ativos
  - Tempo de geração de relatórios
  - Uso de módulos do sistema
  - Erros e exceções

### 3.3. Implementação de Aspectos para Monitoramento
- Criar anotação @Monitored para métodos a serem monitorados
- Implementar aspecto para medir tempo de execução
- Implementar aspecto para contagem de chamadas de método
- Implementar aspecto para logging de exceções

### 3.4. Implementação de Filtros e Interceptores
- Criar filtro para métricas de requisições HTTP
- Implementar interceptor para monitoramento de sessões de usuário
- Configurar handler para exceções globais com métricas

## Tecnologias Utilizadas

- Logback
- SLF4J
- Micrometer
- Prometheus
- Spring AOP
- Spring Web (Filters/Interceptors)
