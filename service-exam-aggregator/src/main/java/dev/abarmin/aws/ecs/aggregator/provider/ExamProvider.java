package dev.abarmin.aws.ecs.aggregator.provider;

import com.google.common.collect.Sets;
import dev.abarmin.aws.ecs.common.Question;
import java.util.Collection;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Barmin
 */
@Component
@RequiredArgsConstructor
public class ExamProvider {
  private final QuestionProvider questionProvider;

  public Collection<Question> provide(final Map<String, Integer> request) {
    final Collection<Question> questioner = Sets.newHashSet();
    for (Map.Entry<String, Integer> entry : request.entrySet()) {
      questioner.addAll(questionProvider.provide(
          entry.getKey(),
          entry.getValue()
      ));
    }
    return questioner;
  }
}
