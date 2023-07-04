package pl.piwowarski.chucknorrisjokes.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.piwowarski.api.chucknorrisjokes.dto.ChuckNorrisJokesApiResponse;
import pl.piwowarski.api.chucknorrisjokes.service.ChuckNorrisJokesService;

import java.io.IOException;

class ChuckNorrisJokesServiceTest {

    @org.junit.jupiter.api.Test
    void run() throws IOException {
        // given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService();
        String url = "https://api.chucknorris.io/jokes/random";

        // when
        String response = chuckNorrisJokesService.getResponse(url);

        // then
        Assertions.assertNotNull(response, "response is null");
    }

    @Test
    void convert() {
        // given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService();

        // when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.convert("{\"categories\":[],\"created_at\":\"2020-01-05 13:42:30.177068\",\"icon_url\":\"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\"id\":\"Po3KcO2oSCSJ0K39MZrLXQ\",\"updated_at\":\"2020-01-05 13:42:30.177068\",\"url\":\"https://api.chucknorris.io/jokes/Po3KcO2oSCSJ0K39MZrLXQ\",\"value\":\"The high tide occurs when Chuck Norris flies over the beach. the rising water is where god pees his pants\"}");

        // then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse, "response is NULL");
    }

    @Test
    void randomJoke() throws IOException {
        // given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService();

        // when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();

        // then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse, "response is NULL");
    }
}