package dev.abarmin.aws.ecs.aggregator.config;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Aleksandr Barmin
 */
@Data
@ConfigurationProperties(prefix = "aggregator")
public class AggregatorConfig {
  @Valid
  @Size(min = 1)
  private Collection<ProviderConfig> providers = Lists.newArrayList();

  public boolean hasProvider(final String name) {
    return getProvider(name).isPresent();
  }

  public Optional<ProviderConfig> getProvider(final String name) {
    return providers.stream()
        .filter(provider -> StringUtils.equalsIgnoreCase(
            provider.getName(),
            name
        ))
        .findFirst();
  }

  @Data
  public static class ProviderConfig {
    @NotEmpty
    private String name;
    @NotEmpty
    private String endpoint;
  }
}
