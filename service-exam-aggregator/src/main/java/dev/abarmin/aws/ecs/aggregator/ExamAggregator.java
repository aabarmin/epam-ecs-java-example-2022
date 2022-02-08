package dev.abarmin.aws.ecs.aggregator;

import dev.abarmin.aws.ecs.aggregator.config.AggregatorConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Aleksandr Barmin
 */
@SpringBootApplication
@EnableConfigurationProperties(AggregatorConfig.class)
public class ExamAggregator {
  public static void main(String[] args) {
    SpringApplication.run(ExamAggregator.class, args);
  }
}
