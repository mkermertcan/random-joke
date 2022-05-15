package com.kamil.randomjoke.joke.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JokeApiResponse {

    private boolean error;
    private int amount;
    private List<Joke> jokes;
}
