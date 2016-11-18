package sample.service;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import sample.model.Condition;
import sample.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;


import static javax.swing.UIManager.getInt;

/**
 * Created by kmlsz on 17.11.2016.
 */
public class WeatherServiceJsonOrg implements WeatherService {
    private String privateKey;

    public WeatherServiceJsonOrg(String privateKey) {
        this.privateKey = privateKey;
    }

    public Weather getWeatherFromUrl(String url, String city) {
        String finalUrl = url + "?key=" + privateKey + "&q=" + city;
        Weather weather = new Weather();
        try {
            JSONObject json = new JSONObject(IOUtils.toString(new URL(finalUrl), Charset.forName("UTF-8")));
            JSONObject locationJson = json.getJSONObject("location");
            JSONObject currentJson = json.getJSONObject("current");
            String location = city;
            double temperature = currentJson.getDouble("temp_c");
            String lastUpdated = currentJson.getString("last_updated");
            boolean isDay = currentJson.getInt("is_day") == 1 ? true : false;
            double feelsLike = currentJson.getDouble("feelslike_c");
            double preasure = currentJson.getDouble("pressure_mb");
            JSONObject currentConditionJson = currentJson.getJSONObject("condition");
            String conditionText = currentConditionJson.getString("text");
            String conditionIconUrl = currentConditionJson.getString("icon");
            int conditionCode = currentConditionJson.getInt("code");

            Condition condition = new Condition(conditionText, conditionIconUrl, conditionCode);
            weather.setDay(isDay);
            weather.setCondition(condition);
            weather.setLastUpdated(lastUpdated);
            weather.setTemperature(temperature);
            weather.setLocation(location);
            weather.setPreasure(preasure);
            weather.setFeelsLike(feelsLike);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }


}
