package pl.piwowarski.api.chucknorrisjokes.service;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.piwowarski.api.chucknorrisjokes.dto.ChuckNorrisJokesApiResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChuckNorrisJokesService {
    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisJokesService.class.getName());
    private static final String API_URL = "https://api.chucknorris.io/jokes/random";

    private OkHttpClient client = new OkHttpClient();

    public ChuckNorrisJokesApiResponse randomJoke() throws IOException {
        LOGGER.info("randomJoke()");
        try {
            String responseBody = getResponse(API_URL);
            ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = convert(responseBody);
            LOGGER.info("randomJoke(....)" + chuckNorrisJokesApiResponse);
            return chuckNorrisJokesApiResponse;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Unable to connect with external API", e);
        }

        LOGGER.info("randomJoke(...) = " + null);
        return null;
    }

    public String getResponse(String url) throws IOException {
        LOGGER.info("getResponse(" + url + ")");
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String body = response.body().string();
            LOGGER.info("getResponse(...) = " + body);
            return body;
        }
    }

    public ChuckNorrisJokesApiResponse convert(String body) {
        LOGGER.info("convert(" + body + ")");
        Gson gson = new Gson();
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = gson.fromJson(body, ChuckNorrisJokesApiResponse.class);
        LOGGER.info("convert(........) = " + chuckNorrisJokesApiResponse);
        return chuckNorrisJokesApiResponse;
    }

}
