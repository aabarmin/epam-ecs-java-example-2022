package dev.abarmin.aws.ecs.provider.history;

import dev.abarmin.aws.ecs.common.Question;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aleksandr Barmin
 */
@RestController
@RequiredArgsConstructor
public class QuestionController {
  private final QuestionProvider provider;

  @GetMapping("/{number}")
  public Collection<Question> generateQuestions(final @PathVariable("number") int number) {
    return provider.provide(number);
  }
}
