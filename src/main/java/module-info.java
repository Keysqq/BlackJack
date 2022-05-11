module com.example.blackjack {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.blackjack to javafx.fxml;
    exports com.example.blackjack;
}