package pl.piwowarski.chucknorrisjokes.service;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;

class ChuckNorrisJokesServiceTest {

    @org.junit.jupiter.api.Test
    void run() throws IOException {
        // given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService();
        String url = "https://api.chucknorris.io/jokes/random";

        // when
        String response = chuckNorrisJokesService.run(url);

        // then
        Assertions.assertNotNull(response, "response is null");
    }
}