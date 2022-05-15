package com.kamil.randomjoke;

import com.kamil.randomjoke.joke.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(ConfigProperties.class)
public class RandomJokeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomJokeApplication.class, args);
    }

}
