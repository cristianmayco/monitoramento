# Guia de Monitoramento da Aplicação com ELK Stack e Grafana

Este guia explica como utilizar o sistema de monitoramento configurado para esta aplicação, cobrindo a visualização de logs com o ELK Stack (Elasticsearch, Logstash, Kibana) e a análise de métricas com Prometheus e Grafana.

## 1. Visão Geral da Arquitetura de Monitoramento

A nossa arquitetura de monitoramento é composta por dois sistemas principais que rodam em contêineres Docker:

1.  **ELK Stack (para Logs):**
    *   **Logstash**: Coleta os logs gerados pela `sistema-tarefas`, os processa (adicionando metadados, se necessário) e os envia para o Elasticsearch.
    *   **Elasticsearch**: Armazena e indexa os logs de forma eficiente, permitindo buscas rápidas.
    *   **Kibana**: Uma interface web para pesquisar, visualizar e criar dashboards a partir dos logs armazenados no Elasticsearch.

2.  **Prometheus e Grafana (para Métricas):**
    *   **Prometheus**: Coleta métricas de performance da aplicação (ex: uso de CPU, memória, latência de requisições HTTP) em intervalos regulares. A nossa aplicação expõe essas métricas através do Spring Boot Actuator no endpoint `/actuator/prometheus`.
    *   **Grafana**: Uma interface web para criar dashboards e visualizar as métricas armazenadas no Prometheus de forma gráfica e interativa.

## 2. Acessando as Ferramentas

Para começar, certifique-se de que todo o ambiente foi iniciado com o comando `./start.sh`.

*   **Kibana (Logs)**: [http://localhost:5601](http://localhost:5601)
*   **Grafana (Métricas)**: [http://localhost:3000](http://localhost:3000)
    *   **Login padrão**: `usuário: admin`, `senha: admin` (pode ser solicitado que você altere a senha no primeiro acesso).

---

## 3. Trabalhando com Logs no Kibana

O Kibana é a sua principal ferramenta para investigar o que está acontecendo na aplicação em tempo real.

### 3.1. Configuração Inicial do Kibana (Apenas na primeira vez)

Ao acessar o Kibana pela primeira vez, antes de poder visualizar os logs, você precisa criar uma "Data View". Isso diz ao Kibana quais dados do Elasticsearch ele deve exibir.

1.  Na tela de boas-vindas, clique em **Create data view**.
2.  **Name**: Dê um nome para a visão, como `Logstash Logs`.
3.  **Index pattern**: Digite `logstash-*`. O Kibana deve confirmar que encontrou os índices correspondentes.
4.  **Timestamp field**: Selecione `@timestamp` na lista suspensa.
5.  Clique em **Create data view** para finalizar.

Após criar a Data View, você será levado para a tela Discover.

### 3.2. Explorando os Logs (Discover)

1.  Acesse o **Kibana**: [http://localhost:5601](http://localhost:5601)
2.  Se você já configurou a Data View, vá para o menu lateral em **Analytics > Discover**.
3.  Você verá um fluxo de logs da aplicação. Cada linha representa um evento de log.
4.  **Filtre os logs**: Use a barra de busca no topo. Por exemplo:
    *   Para ver apenas erros: `log.level: "ERROR"`
    *   Para ver logs de um controller específico: `logger_name: "com.exemplo.sistema.controller.TaskController"`
    *   Para buscar uma mensagem específica: `"Task not found"`

### 3.2. Criando uma Visualização de Logs

Vamos criar um gráfico de pizza que mostra a distribuição dos níveis de log (INFO, ERROR, etc.).

1.  No menu lateral, vá para **Analytics > Visualize Library**.
2.  Clique em **Create visualization**.
3.  Selecione **Pie** (Pizza) como o tipo de gráfico.
4.  Selecione o data view (geralmente `logstash-*` ou similar).
5.  No painel de configuração à direita (**Buckets**), clique em **Add** e selecione **Terms**.
6.  No campo **Field**, escolha `log.level.keyword` (o `.keyword` é importante para agregação de texto).
7.  Clique no botão **Update** no canto inferior direito para ver o gráfico.
8.  Clique em **Save** no canto superior direito para salvar sua visualização (ex: "Distribuição de Níveis de Log").

### 3.3. Criando um Dashboard de Logs

Um dashboard permite combinar múltiplas visualizações em uma única tela.

1.  No menu lateral, vá para **Analytics > Dashboard**.
2.  Clique em **Create dashboard**.
3.  Clique em **Add from library** no canto superior esquerdo.
4.  Selecione a visualização que você acabou de criar ("Distribuição de Níveis de Log").
5.  Você também pode adicionar pesquisas salvas. Volte para a tela **Discover**, faça uma busca por erros (`log.level: "ERROR"`), salve-a e adicione-a ao seu dashboard.
6.  Organize os painéis como desejar e clique em **Save** para salvar o dashboard (ex: "Dashboard de Logs da Aplicação").

---

## 4. Trabalhando com Métricas no Grafana

O Grafana é ideal para monitorar a saúde e a performance da aplicação ao longo do tempo.

### 4.1. Explorando as Métricas (Explore)

1.  Acesse o **Grafana**: [http://localhost:3000](http://localhost:3000)
2.  No menu lateral (ícone de bússola), vá para **Explore**.
3.  No topo, certifique-se de que `prometheus` está selecionado como a fonte de dados (Data source).
4.  Use o campo **Metrics browser** para ver as métricas disponíveis. Algumas métricas úteis do Spring Boot:
    *   `jvm_memory_used_bytes`: Uso de memória da JVM.
    *   `system_cpu_usage`: Uso de CPU pelo sistema.
    *   `http_server_requests_seconds_count`: Número de requisições HTTP recebidas.
    *   `http_server_requests_seconds_sum`: Soma do tempo de duração de todas as requisições.

### 4.2. Criando um Painel de Métricas em um Dashboard

Vamos criar um gráfico que mostra o uso de CPU ao longo do tempo.

1.  No menu lateral (ícone de quatro quadrados), vá para **Dashboards**.
2.  Clique em **New > New Dashboard**.
3.  Clique em **Add visualization**.
4.  Selecione `prometheus` como a fonte de dados.
5.  No campo **Metrics browser**, selecione a métrica `system_cpu_usage`.
6.  O Grafana irá gerar um gráfico automaticamente. No painel à direita, você pode customizá-lo:
    *   **Panel title**: Dê um nome ao painel (ex: "Uso de CPU do Sistema").
    *   **Unit**: Em **Standard options > Unit**, selecione **Percent (0.0-1.0)** para formatar o eixo Y como porcentagem.
7.  Clique em **Apply** no canto superior direito para adicionar o painel ao dashboard.
8.  Clique no ícone de disquete (**Save dashboard**) no topo, dê um nome ao seu dashboard (ex: "Métricas da Aplicação") e salve.

### 4.3. Configuração Inicial do Grafana (Apenas na primeira vez)

Antes de importar um dashboard, você precisa dizer ao Grafana onde encontrar o Prometheus. 

1.  Acesse o Grafana e, no menu lateral, clique no ícone de engrenagem (**Configuration**).
2.  Clique em **Data Sources**.
3.  Clique em **Add data source** e selecione **Prometheus**.
4.  No campo **URL**, digite `http://prometheus:9090`.
5.  Clique em **Save & test**. Você deve ver uma mensagem de sucesso.

### 4.4. Importando um Dashboard Pré-configurado

Com a fonte de dados configurada, agora você pode importar um dashboard da comunidade.

1.  No menu lateral, vá para **Dashboards**.
2.  Na página de Dashboards, clique em **New > Import**.
3.  Você pode importar um dashboard pelo seu ID do site oficial do Grafana. Um dashboard muito popular para monitoramento de aplicações Spring Boot é o **`4701`**.
4.  Digite `4701` no campo **Import via grafana.com** e clique em **Load**.
5.  Na próxima tela, selecione a fonte de dados `prometheus` e clique em **Import**.
6.  Pronto! Você terá um dashboard completo com dezenas de métricas úteis sobre a sua aplicação.

Este guia cobre os passos iniciais para você começar a explorar e monitorar sua aplicação. Sinta-se à vontade para experimentar com diferentes métricas, logs e tipos de visualização para criar dashboards que atendam às suas necessidades.
