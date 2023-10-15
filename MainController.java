package App.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import App.WordReader;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;

/**
 * Controller class for the main application window.
 */
public class MainController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> selDifficulty;

    @FXML
    private Label difficultyWarning;

    private String[] difficulties = { "Easy", "Normal", "Hard" };
    private String css = this.getClass().getResource("../../resources/css/main.css").toExternalForm();

    /**
     * Initializes the controller when the FXML is loaded.
     * 
     * @param location   The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resources  The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initChoiceBox();
        difficultyWarning.setVisible(false);
    }

    /**
     * Initializes the ChoiceBox with difficulty options.
     */
    private void initChoiceBox() {
        selDifficulty.getItems().addAll(difficulties);
    }

    /**
     * Handles the action when the "Start Game" button is clicked.
     * 
     * @param event An ActionEvent generated when the button is clicked.
     * @throws IOException If an error occurs when loading the game scene.
     */
    @FXML
    public void startGame(ActionEvent event) throws IOException {
        if (selDifficulty.getValue() == null || selDifficulty.getValue().isEmpty()) {
            difficultyWarning.setVisible(true);
            
            // Create a PauseTransition for the delay
            PauseTransition pause = new PauseTransition(Duration.millis(2500));
            pause.setOnFinished(e -> {
                difficultyWarning.setVisible(false);
            });
            // Start the delay
            pause.play();
            return;
        }
        root = FXMLLoader.load(getClass().getResource("../../resources/fxml/game.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

        System.out.println(WordReader.retrieveWord(selectFile()));
    }

    /**
     * Exits the application.
     */
    public void exit() {
        System.exit(0);
    }

    /**
     * Selects a file based on the difficulty chosen in the ChoiceBox.
     * 
     * @return A File object representing the selected word file.
     */
    private File selectFile() {
        // Handle the ChoiceBox selection here
        switch (selDifficulty.getValue().toLowerCase()) {
            case "easy" -> {
                return new File("Database\\easy.txt");
            }
            case "normal" -> {
                return new File("Database\\normal.txt");
            }
            case "hard" -> {
                return new File("Database\\hard.txt");
            }
            default -> throw new NullPointerException("String is null");
        }
    }
}
