package ro.fasttrackit.curs5.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Configuration
@ConfigurationProperties(prefix = "app")
@Validated
public class RecommendedConfig {
    @NotBlank
    private String name;
    @Min(1)
    @Max(100)
    private int timeout;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}


