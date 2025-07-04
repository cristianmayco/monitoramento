FROM logstash:8.9.2

USER root
RUN apt-get update && apt-get install -y net-tools && rm -rf /var/lib/apt/lists/*
USER logstash
