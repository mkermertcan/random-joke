package com.kamil.randomjoke.joke;

import com.kamil.randomjoke.joke.model.JokeApiResponse;

public interface JokeClient {

    JokeApiResponse getJokes(String type, int amount);

}
