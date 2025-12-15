Configure
1. create a docker network: docker network create elk
2. Run elastic search
   docker run -d --name elasticsearch --network elk -p 9200:9200 -e "discovery.type=single-node" -e "xpack.security.enabled=false" docker.elastic.co/elasticsearch/elasticsearch:8.12.2
3. Run Kibana: docker run -d --name kibana --network elk -p 5601:5601 -e "ELASTICSEARCH_HOSTS=http://elasticsearch:9200" docker.elastic.co/kibana/kibana:8.12.2
4. Verify everything is running: docker ps
5. Test elastic search: curl http://localhost:9200
6. Verify if kibana is running by going to http://localhost:5601
7. To configure filebeat : cd C:\Users\Gayathri\filebeat -> open filebeat.yaml and add configurations
8. execute .\filebeat.exe -e from filebeat folder
9. To verify index exists check: curl http://localhost:9200/_cat/indices?v
10. To sop file beat press Ctrl+C


Notes:

Filebeat → Elasticsearch → Kibana is a common observability pipeline: 
Filebeat collects and ships logs, Elasticsearch stores and indexes them, 
and Kibana visualizes and analyzes them

1. Filebeat is a Lightweight log shipper. It reads logs from server containers, or applications and forwards them to Elasticsearch (or Kafka/Logstash).
2. Elastic search Stores logs as structured documents, indexes them for fast search, and enables queries across massive datasets.
3. Kibana Provides a UI to explore Elasticsearch data, build dashboards, and monitor system health.
4. Filebeat → Elasticsearch: Filebeat ships logs directly into Elasticsearch indices.
5. Elasticsearch → Kibana: Kibana queries Elasticsearch to display logs and metrics.
6. Application Logs → Filebeat → Elasticsearch → Kibana (Dashboards & Alerts)









