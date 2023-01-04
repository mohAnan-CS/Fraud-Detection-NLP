package birzeit.university.plagiarismdetection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Plagiarism Detection");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.getIcons().add(new Image("C:\\Users\\twitter\\IdeaProjects\\PlagiarismDetection\\plagiarism.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}