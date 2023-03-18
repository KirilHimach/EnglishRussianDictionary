package com.example.englishRussianDictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Dictionary extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(Dictionary.class.getResource("dictionary.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 422);
        stage.setTitle("English-Russian dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}