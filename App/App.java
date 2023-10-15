package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * The main application class for the Hangman game.
 */
public class App extends Application {

    private String css = this.getClass().getResource("../resources/css/main.css").toExternalForm();

    /**
     * The main method for starting the Hangman game.
     *
     * @param args Command-line arguments.
     * @throws Exception if an error occurs during application initialization.
     */
    public static void main(String[] args) throws Exception {
        // Start the audio player with background music
        AudioPlayer.audioPlayer("src\\resources\\Assets\\Audio\\MenuMusic.wav");
        launch(args);
    }

    /**
     * Initializes and starts the Hangman game application.
     *
     * @param primaryStage The primary stage for the application.
     * @throws Exception if an error occurs during application startup.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the main user interface from an FXML file
        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/main.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(css);

        // Configure the primary stage
        primaryStage.setTitle("Hangman");
        primaryStage.getIcons().add(new Image(getClass().getResource("../resources/Assets/Image/app_icon.png").toExternalForm()));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
