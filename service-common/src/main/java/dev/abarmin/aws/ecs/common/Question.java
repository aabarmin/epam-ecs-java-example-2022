package dev.abarmin.aws.ecs.common;

import com.google.common.collect.Lists;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aleksandr Barmin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
  private String question;
  @Builder.Default
  private Collection<Answer> answers = Lists.newArrayList();
}
