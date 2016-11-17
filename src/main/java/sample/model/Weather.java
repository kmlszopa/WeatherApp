package sample.model;



import java.time.LocalDateTime;

/**
 * Created by kmlsz on 17.11.2016.
 */
public class Weather {

    private double temperature;
    private LocalDateTime lastUpdated;
    private double feelsLike;
    private String iconURL;
    private boolean isDay;
    private double preasure;
    private String location;
    private Condition condition;

    public Weather(double temperature, LocalDateTime lastUpdated, double feelsLike, String iconURL, boolean isDay, double preasure, String location) {
        this.temperature = temperature;
        this.lastUpdated = lastUpdated;
        this.feelsLike = feelsLike;
        this.iconURL = iconURL;
        this.isDay = isDay;
        this.preasure = preasure;
        this.location = location;
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public double getTemperature() {

        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public boolean isDay() {
        return isDay;
    }

    public void setDay(boolean day) {
        isDay = day;
    }

    public double getPreasure() {
        return preasure;
    }

    public void setPreasure(double preasure) {
        this.preasure = preasure;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}