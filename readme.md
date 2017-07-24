### Exposing Codahele metrics to Prometheus.io from SpringBoot:

The sample code here helps you expose your codahele metrics in your springboot app to  Prometheus.io.

This piece of code does not depend on springboot actuator which exposes its own set of metrics.

## How to run:
```
mvn clean compile package;
cd target
java -jar spring-codahele-prometheus-1.0-SNAPSHOT.jar

Now access prometheus metrics @ http://localhost:8080/prometheusMetrics

Prometheus.io should be configured in its prometheus.yml for this host 
see  sample_prometheus_conf.yml

```

## How to run Prometheus.io:

```
docker run -p 9090:9090 -v sample_prometheus_conf.yml:/etc/prometheus/prometheus.yml prom/prometheus:v1.7.1

you can access now spring boot metrics in Prometheus @   http://localhost:9090
```