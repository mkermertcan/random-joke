package com.kamil.randomjoke.joke;


import com.kamil.randomjoke.joke.model.RandomJokeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/random-joke")
@Slf4j
@RequiredArgsConstructor
public class JokeController {

    private final JokeService jokeService;

    @GetMapping
    public RandomJokeResponse getRandomJoke(){
        return jokeService.getRandomJoke();
    }
}
