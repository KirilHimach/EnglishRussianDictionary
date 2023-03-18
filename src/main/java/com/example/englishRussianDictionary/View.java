package com.example.englishRussianDictionary;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.Optional;

public class View {

    /*
    This method opens the Dialog when user tops to Open button.
    The method returns link to file or null.
     */
    public String showOpenDialog() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileFilter =
                new FileChooser.ExtensionFilter("*.txt", "*.txt");
        fileChooser.getExtensionFilters().add(fileFilter);
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /*
    This method opens the Dialog when user tops to Save us... button.
    The method returns link to file or null.
     */
    public String showSaveDialog() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileFilter =
                new FileChooser.ExtensionFilter("*.txt", "*.txt");
        fileChooser.getExtensionFilters().add(fileFilter);
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /*
    This method opens the alert CONFIRMATION when user taps to EXIT button
     */
    public void showAlertExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Attention!");
        alert.setContentText("Exit without saving?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                System.exit(0);
            }
        });
    }

    /*
    This method opens the alert CONFIRMATION when user taps to Delete button
     */
    public boolean showAlertDelete() {
        boolean result = false;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Attention!");
        alert.setContentText("Are you sure?");
        Optional<ButtonType> optional = alert.showAndWait();
        if (optional.get() == ButtonType.OK) {
            result = true;
        }
        return result;
    }

    /*
    This method opens the alert INFORMATION when user taps to About button
     */
    public void showAlertAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("English Russian dictionary");
        alert.setHeaderText("You are using \"English Russian dictionary\". \nVersion 1.0");
        alert.showAndWait();
    }

}
