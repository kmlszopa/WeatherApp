package sample.service;

import sample.model.Weather;

/**
 * Created by kmlsz on 17.11.2016.
 */
public interface WeatherService {
    Weather getWeatherFromUrl(String url);

}
