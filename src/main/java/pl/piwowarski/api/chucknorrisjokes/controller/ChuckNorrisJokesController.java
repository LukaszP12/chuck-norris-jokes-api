package pl.piwowarski.api.chucknorrisjokes.controller;

import pl.piwowarski.api.chucknorrisjokes.dto.ChuckNorrisJokesApiResponse;
import pl.piwowarski.api.chucknorrisjokes.service.ChuckNorrisJokesService;

import java.io.IOException;
import java.util.logging.Logger;


public class ChuckNorrisJokesController {
    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisJokesController.class.getName());

    private final ChuckNorrisJokesService chuckNorrisJokesService;

    public ChuckNorrisJokesController(ChuckNorrisJokesService chuckNorrisJokesService) {
        this.chuckNorrisJokesService = chuckNorrisJokesService;
    }

    public ChuckNorrisJokesApiResponse randomJoke() throws IOException {
        LOGGER.info("randomJoke()");
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();
        LOGGER.info("randomJoke(...) = " + chuckNorrisJokesApiResponse);
        return chuckNorrisJokesApiResponse;
    }

}
