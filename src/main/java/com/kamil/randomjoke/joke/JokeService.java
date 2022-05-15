package com.kamil.randomjoke.joke;

import com.kamil.randomjoke.joke.JokeClient;
import com.kamil.randomjoke.joke.ConfigProperties;
import com.kamil.randomjoke.joke.model.Joke;
import com.kamil.randomjoke.joke.model.JokeApiResponse;
import com.kamil.randomjoke.joke.model.RandomJokeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class JokeService {

    private final JokeClient jokeClient;
    private final ConfigProperties configProperties;


    public RandomJokeResponse getRandomJoke(){

        log.info("getRandomJoke method started");

        String type = configProperties.getType();
        int amount = configProperties.getAmount();


        JokeApiResponse jokeApiResponse = jokeClient.getJokes(type, amount);

        Joke shortestProperJoke = chooseShortestProperJoke(jokeApiResponse.getJokes());

        RandomJokeResponse randomJokeResponse = new RandomJokeResponse(shortestProperJoke.getId(), shortestProperJoke.getJoke());

        log.info("Response of the getRandomJoke method is: {}", randomJokeResponse);

        return randomJokeResponse;
    }

    private Joke chooseShortestProperJoke(List<Joke> jokeList){

        Joke shortestProperJoke = jokeList.stream()
                                           .filter(joke -> joke.isSafe())
                                           .filter(joke -> !joke.getFlags().isSexist())
                                           .filter(joke -> !joke.getFlags().isExplicit())
                                           .min(Comparator.comparing(joke -> joke.getJoke().length()))
                                           .get();

        log.info("Proper and the shortest joke is: {}", shortestProperJoke);

        return shortestProperJoke;
    }
}
