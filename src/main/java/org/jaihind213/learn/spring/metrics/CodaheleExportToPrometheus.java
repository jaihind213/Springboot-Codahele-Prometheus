package org.jaihind213.learn.spring.metrics;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.dropwizard.DropwizardExports;
import io.prometheus.client.exporter.MetricsServlet;

import com.codahale.metrics.MetricRegistry;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * Created by vishnuhr on 19/7/17.
 * expose codahele metrics registry as a servlet on http://<host>:<port>/prometheusMetrics
 * then prometheus would pull the metrics from this url.
 * configure prometheus.yml with the host/port and uri = /prometheusMetrics
 */
@Configuration
@ConditionalOnClass(CollectorRegistry.class)
public class CodaheleExportToPrometheus {

  private String metricsUrl = "prometheusMetrics";
  @Bean
  @Qualifier("collectorRegistry")
  public CollectorRegistry collectorRegistry(@Qualifier("metricsRegistry") MetricRegistry mr) {
    CollectorRegistry cr =  new CollectorRegistry();
    cr.register(new DropwizardExports(mr));
    return cr;
  }


  @Bean
  @DependsOn("collectorRegistry")
  public ServletRegistrationBean metricsServletRegistrationBean(@Qualifier("collectorRegistry") CollectorRegistry cr) {
    return new ServletRegistrationBean(new MetricsServlet(cr),
        "/"+metricsUrl);
  }

}
