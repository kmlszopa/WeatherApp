package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class Main extends Application {

    public Main() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("WeatherApp");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        try {
            JSONObject json = new JSONObject(IOUtils.toString(new URL("http://api.apixu.com/v1/current.json?key=1b6096b375b64c4786e150301161711&q=Warsaw"), Charset.forName("UTF-8")));
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}