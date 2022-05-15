package com.kamil.randomjoke.joke.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Joke {

    private String category;
    private String type;
    private String joke;
    private Flags flags;
    private int id;
    private boolean safe;
    private String lang;
}
