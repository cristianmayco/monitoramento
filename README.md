# Sistema de Monitoramento de Aplicação Web Java

Este projeto implementa um sistema de monitoramento completo para uma aplicação web Java utilizando Growroot, ELK Stack e Grafana. O objetivo é monitorar o uso do sistema, usuários logados, relatórios gerados, módulos mais utilizados, identificar componentes de maior carga computacional e detectar erros.

## Estrutura do Projeto

O projeto está organizado nas seguintes pastas principais:

1. **[1-preparacao-ambiente](./1-preparacao-ambiente)**: Configuração do ambiente de desenvolvimento e estrutura do projeto
2. **[2-desenvolvimento-aplicacao](./2-desenvolvimento-aplicacao)**: Implementação da aplicação web Java de exemplo
3. **[3-instrumentacao-aplicacao](./3-instrumentacao-aplicacao)**: Instrumentação da aplicação para coleta de métricas e logs
4. **[4-configuracao-infraestrutura-docker](./4-configuracao-infraestrutura-docker)**: Configuração da infraestrutura Docker para todos os componentes
5. **[5-configuracao-monitoramento](./5-configuracao-monitoramento)**: Configuração das ferramentas de monitoramento (ELK Stack, Grafana)
6. **[6-testes-validacao](./6-testes-validacao)**: Testes da aplicação e do sistema de monitoramento
7. **[7-documentacao](./7-documentacao)**: Documentação técnica, de monitoramento e para usuários
8. **[8-implantacao-entrega](./8-implantacao-entrega)**: Preparação para produção e implantação
9. **[9-manutencao-continua](./9-manutencao-continua)**: Monitoramento contínuo e melhorias

## Documentação de Planejamento

A documentação de planejamento do projeto está disponível na pasta [planejamento](./planejamento):

- **[alto-nivel.md](./planejamento/alto-nivel.md)**: Visão geral do projeto
- **[medio-nivel.md](./planejamento/medio-nivel.md)**: Requisitos e arquitetura detalhados
- **[nivel-baixo.md](./planejamento/nivel-baixo.md)**: Lista detalhada de tarefas para implementação

## Tecnologias Utilizadas

- **Aplicação**: Spring Boot, PostgreSQL, Spring Security
- **Instrumentação**: Micrometer, Prometheus, Logback
- **Monitoramento**: Elasticsearch, Logstash, Kibana, Grafana
- **Infraestrutura**: Docker, Docker Compose

## Como Iniciar

Para iniciar o desenvolvimento do projeto, siga as instruções na pasta [1-preparacao-ambiente](./1-preparacao-ambiente).

## Licença

Este projeto está licenciado sob a licença MIT.
