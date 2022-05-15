package com.kamil.randomjoke.joke.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RandomJokeResponse {

    private int id;
    private String randomJoke;
}
