package com.example.englishRussianDictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import java.util.Map;

public class Controller {
    Model model = new Model();
    View view = new View();
    private MultipleSelectionModel<String> englishListView;
    @FXML
    private ListView outputEnglishText;
    @FXML
    private ListView outputRussianText;
    @FXML
    private Text showResultText;
    @FXML
    private TextField inputText;


    @FXML
    private void btnAdd(ActionEvent actionEvent) {
        showResultText.setText("");
        if (!inputText.getText().trim().isEmpty()) {
                if (model.putWords(inputText.getText())) {
                    clearView();
                    showAllWords();
                } else showResultText.setText("Incorrect value!");
        }
        inputText.clear();
    }

    @FXML
    private void btnEdite(ActionEvent actionEvent) {
        englishListView = outputEnglishText.getSelectionModel();
        if (englishListView.getSelectedItem() != null) {
            inputText.setText(model.editeWordsByKey(englishListView.getSelectedItem()));
            clearView();
            showAllWords();
        }
    }

    @FXML
    private void btnDelete(ActionEvent actionEvent) {
        englishListView = outputEnglishText.getSelectionModel();
        if (englishListView.getSelectedItem() != null && view.showAlertDelete()) {
            model.removeWordsByKey(englishListView.getSelectedItem());
            clearView();
            showAllWords();
        }
    }

    @FXML
    private void btnClose(ActionEvent actionEvent) {
        view.showAlertExit();
    }

    @FXML
    private void btnOpen(ActionEvent actionEvent) {
        String openDialogResult = view.showOpenDialog();
        if (openDialogResult != null) {
            model.openAndReadFile(openDialogResult);
            clearView();
            showAllWords();
        }
    }

    @FXML
    private void btnSaveUs(ActionEvent actionEvent) {
        String showSaveDialogResult = view.showSaveDialog();
        if (showSaveDialogResult != null) {
            model.createAndWriteFile(showSaveDialogResult);
            clearView();
            showAllWords();
        }
    }

    @FXML
    private void btnAbout(ActionEvent actionEvent) {
        view.showAlertAbout();
    }

    private void showAllWords() {
        for (Map.Entry<String, String> value : model.words.entrySet()) {
            outputEnglishText.getItems().add(value.getKey());
            outputRussianText.getItems().add(value.getValue());
        }
    }

    private void clearView() {
        outputRussianText.getItems().clear();
        outputEnglishText.getItems().clear();
    }

}