package dev.abarmin.aws.ecs.aggregator.health;

import dev.abarmin.aws.ecs.aggregator.config.AggregatorConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Barmin
 */
@Component
@RequiredArgsConstructor
public class CustomHealthIndicator implements HealthIndicator {
  private final AggregatorConfig config;

  @Override
  public Health health() {
    if (config.isCorrectMoonPhase()) {
      return Health.up().build();
    }
    return Health.down()
        .status(Status.DOWN)
        .withDetail("Reason", "Invalid phase of the Moon")
        .build();
  }
}
