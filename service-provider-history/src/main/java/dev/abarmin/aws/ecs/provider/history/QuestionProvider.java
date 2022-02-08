package dev.abarmin.aws.ecs.provider.history;

import dev.abarmin.aws.ecs.common.Answer;
import dev.abarmin.aws.ecs.common.Question;
import java.util.Collection;
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
    return Question.builder()
        .question("What was the year of %event-name%?")
        .answers(generateAnswers(3))
        .build();
  }

  private Collection<Answer> generateAnswers(int number) {
    return IntStream.range(0, number)
        .mapToObj(index -> generateAnswer(index == 0))
        .collect(Collectors.toList());
  }

  private Answer generateAnswer(final boolean isCorrect) {
    return Answer.builder()
        .answer(String.format(
            "In %s",
            RANDOM.nextInt(2020)
        ))
        .isCorrect(isCorrect)
        .build();
  }
}
