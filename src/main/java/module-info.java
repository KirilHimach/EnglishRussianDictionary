module com.example.englishrussiandictionary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.englishRussianDictionary to javafx.fxml;
    exports com.example.englishRussianDictionary;
}