package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.model.Weather;
import sample.service.WeatherServiceJsonOrg;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label locationLabel;
    @FXML
    private Label temperatureLabel;
    @FXML
    private Label feelsLikeLabel;
    @FXML
    private Label preasureLabel;
    @FXML
    private Label conditionLabel;
    @FXML
    private Label lastUpdateLabel;
    @FXML
    private ImageView conditionImage;
    @FXML
    private Button locationAcceptButton;
    @FXML
    private TextField locationTextField;
    @FXML
    public void onEnter(ActionEvent actionEvent){
        setValuesComponentsFromServer(locationTextField.getText());
    }


    public void initialize(final URL location, ResourceBundle resources) {
        setValuesComponentsFromServer("Warsaw");
        locationAcceptButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                setValuesComponentsFromServer(locationTextField.getText());
            }
        });


    }
    private void setValuesComponentsFromServer(String myCity){
        WeatherServiceJsonOrg weatherServiceJsonOrg = new WeatherServiceJsonOrg("1b6096b375b64c4786e150301161711");
        Weather weather = weatherServiceJsonOrg.getWeatherFromUrl("http://api.apixu.com/v1/current.json", myCity);
        lastUpdateLabel.setText(weather.getLastUpdated());
        locationLabel.setText(weather.getLocation());
        temperatureLabel.setText(String.valueOf(weather.getTemperature()));
        preasureLabel.setText(String.valueOf(weather.getPreasure()));
        feelsLikeLabel.setText(String.valueOf(weather.getFeelsLike()));
        conditionLabel.setText(weather.getCondition().getText());
        Image image = new Image("http:" + weather.getCondition().getIconUrl(), true);
        conditionImage.setImage(image);
    }
}