package com.kamil.randomjoke.joke;

import com.kamil.randomjoke.joke.model.JokeApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Slf4j
@RequiredArgsConstructor
public class JokeClientImplementation implements JokeClient {

    private final JokeApi jokeApi;

    @Override
    public JokeApiResponse getJokes(String type, int amount) {

        log.info("external joke api will be called with type: {} and amount: {}", type, amount);

        JokeApiResponse jokeApiResponse = jokeApi.getJokes(type, amount);

        log.info("Response of the external joke api: {}", jokeApiResponse);

        return jokeApiResponse;
    }

    @FeignClient(name = "${feign.joke-service.name}", url = "${feign.joke-service.url}")
    public interface JokeApi {

        @RequestMapping(method = RequestMethod.GET, value = "/joke/Any")
        JokeApiResponse getJokes(@RequestParam String type,
                                 @RequestParam int amount);
    }

}


