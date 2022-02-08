package dev.abarmin.aws.ecs.aggregator.provider;

import dev.abarmin.aws.ecs.aggregator.config.AggregatorConfig;
import dev.abarmin.aws.ecs.common.Question;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Aleksandr Barmin
 */
@Component
@RequiredArgsConstructor
public class QuestionProvider {
  private final AggregatorConfig config;
  private final RestTemplate restTemplate;

  public Collection<Question> provide(final String discipline, final int number) {
    if (!config.hasProvider(discipline)) {
      throw new IllegalArgumentException(String.format(
          "No provider configured for discipline %s",
          discipline
      ));
    }

    final String endpoint = config.getProvider(discipline)
        .get()
        .getEndpoint();

    final String targetUrl = endpoint + number;

    final HttpHeaders headers = new HttpHeaders();
    headers.setAccept(List.of(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);

    final RequestEntity<?> requestEntity = new RequestEntity<>(
        headers,
        HttpMethod.GET,
        URI.create(targetUrl)
    );
    final ParameterizedTypeReference<List<Question>> responseType = new ParameterizedTypeReference<>() {
    };
    final ResponseEntity<List<Question>> responseEntity = restTemplate.exchange(requestEntity, responseType);
    return responseEntity.getBody();
  }
}
