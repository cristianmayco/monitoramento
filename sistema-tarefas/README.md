# Sistema de Gerenciamento de Tarefas

Este diretório contém o projeto Spring Boot utilizado como exemplo para o sistema de monitoramento.

Para construir e executar, utilize o Maven:

```bash
mvn spring-boot:run
```

A aplicação possui endpoints REST para gerenciamento de usuários, tarefas e projetos.
As dependências estão definidas no `pom.xml` fornecido na documentação.

Para mais detalhes sobre como usar a API, consulte o arquivo [USAGE.md](./USAGE.md).

Para um guia completo sobre como utilizar o sistema de monitoramento (ELK e Grafana), consulte o [Guia de Monitoramento](./MONITORING_GUIDE.md).

Para executar os testes automatizados:

```bash
mvn test
```
