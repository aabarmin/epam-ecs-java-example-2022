package dev.abarmin.aws.ecs.aggregator;

import dev.abarmin.aws.ecs.aggregator.provider.ExamProvider;
import dev.abarmin.aws.ecs.common.Question;
import java.util.Collection;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aleksandr Barmin
 */
@RestController
@AllArgsConstructor
public class AggregatorController {
  private final ExamProvider examProvider;

  @PostMapping("/")
  public Collection<Question> generate(final @RequestBody Map<String, Integer> request) {
    return examProvider.provide(request);
  }
}
