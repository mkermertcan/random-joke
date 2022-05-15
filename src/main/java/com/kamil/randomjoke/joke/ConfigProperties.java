package com.kamil.randomjoke.joke;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value = "joke")
@Data
public class ConfigProperties {

    private String type;
    private int amount;
}
