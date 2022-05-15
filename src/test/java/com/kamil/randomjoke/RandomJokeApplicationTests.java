package com.kamil.randomjoke;

import com.kamil.randomjoke.joke.ConfigProperties;
import com.kamil.randomjoke.joke.JokeClient;
import com.kamil.randomjoke.joke.JokeService;
import com.kamil.randomjoke.joke.model.Flags;
import com.kamil.randomjoke.joke.model.Joke;
import com.kamil.randomjoke.joke.model.JokeApiResponse;
import com.kamil.randomjoke.joke.model.RandomJokeResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@EnableConfigurationProperties(ConfigProperties.class)
class RandomJokeApplicationTests {

    @InjectMocks
    private JokeService jokeService;

    @Mock
    private ConfigProperties configProperties;

    @Mock
    private JokeClient jokeClient;


    @Test
    void getRandomJoke_Method_Should_Return_Shortest_And_Safe_One_Random_Joke_With_Id() {

        Joke longestAndSafeJoke = new Joke("Programming", "single", "This text is 32 characters long.", new Flags(false, false, false, false, false, false), 259, true, "en");
        Joke middleLengthAndSafeJoke = new Joke("Programming", "single", "This text is 31 characters long", new Flags(false, false, false, false, false, false), 260, true, "en");
        Joke shortestAndNotSafeJoke = new Joke("Programming", "single", "This text is 30 character long", new Flags(false, false, false, false, true, true), 261, false, "en");
        JokeApiResponse response = new JokeApiResponse(false, 3, List.of(longestAndSafeJoke, middleLengthAndSafeJoke, shortestAndNotSafeJoke));

        when(configProperties.getType()).thenReturn("single");
        when(configProperties.getAmount()).thenReturn(16);
        when(jokeClient.getJokes("single", 16)).thenReturn(response);

        RandomJokeResponse randomJokeResponse = jokeService.getRandomJoke();
        assertEquals(randomJokeResponse.getId(), middleLengthAndSafeJoke.getId());
    }

}
