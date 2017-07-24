package org.jaihind213.learn.spring.metrics;

import lombok.extern.slf4j.Slf4j;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by vishnuhr on 24/7/17.
 */
@Configuration
@EnableAutoConfiguration
@Slf4j
public class CodaheleBeans {

  @Bean
  @Qualifier("metricsRegistry")
  public MetricRegistry createMetricRegistry() {
    MetricRegistry metricRegistry = new MetricRegistry();
    registerForJvmMetrics(metricRegistry);
    log.info("Metrics Registry created. object hashcode: " + metricRegistry.hashCode());
    return metricRegistry;
  }

  @Bean
  public ConsoleReporter createConsoleReporter(@Qualifier("metricsRegistry") MetricRegistry mr){
    final ConsoleReporter.Builder builder = ConsoleReporter.forRegistry(mr);
    ConsoleReporter reporter = builder.build();
    reporter.start(10, TimeUnit.SECONDS);
    log.info("Metrics Registry added a console reporter.");
    return reporter;
  }


  private void registerForJvmMetrics(MetricRegistry metricRegistry){
    metricRegistry.registerAll(new MemoryUsageGaugeSet());
    metricRegistry.registerAll(new GarbageCollectorMetricSet());
  }

}
