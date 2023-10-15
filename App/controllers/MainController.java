package App.controllers;

import java.io.File;
import java.io.IOException;

import App.WordReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

/**
 * Controller
 */
public class MainController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String css = this.getClass().getResource("../../resources/css/main.css").toExternalForm();
    
    @FXML
    public void test(ActionEvent event) {
        System.out.println("It work!");
    }

    @FXML
    public void selectDifficulty(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../resources/fxml/selectDifficulty.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

        System.out.println(WordReader.retrieveWord(new File("Database\\easy.txt")));
    }

    @FXML
    public void goToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../resources/fxml/main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void exit() {
        System.exit(0);
    }
}