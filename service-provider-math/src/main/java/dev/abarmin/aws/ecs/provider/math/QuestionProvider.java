package dev.abarmin.aws.ecs.provider.math;

import dev.abarmin.aws.ecs.common.Answer;
import dev.abarmin.aws.ecs.common.Question;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Barmin
 */
@Component
public class QuestionProvider {
  private static final Random RANDOM = new Random();

  public Collection<Question> provide(final int number) {
    return IntStream.range(0, number)
        .mapToObj(index -> provide())
        .collect(Collectors.toList());
  }

  private Question provide() {
    final int first = RANDOM.nextInt(100);
    final int second = RANDOM.nextInt(100);

    return Question.builder()
        .question(String.format(
            "%s + %s = ?",
            first,
            second
        ))
        .answers(List.of(
            Answer.builder()
                .isCorrect(true)
                .answer(String.valueOf(first + second))
                .build(),
            Answer.builder()
                .isCorrect(false)
                .answer(String.valueOf(first - second))
                .build()
        ))
        .build();
  }
}
