package birzeit.university.plagiarismdetection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import validating.ValidateCorpus;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        ValidateCorpus validateCorpus = new ValidateCorpus();
        String sentence = validateCorpus.validate("محمد عنان أبو . جزر");
        HelloController helloController = new HelloController();
        ArrayList<String> arrayList = helloController.tokenizeWord(sentence.trim());
        for (int i = 0; i < arrayList.size(); i++) {
            if (!arrayList.get(i).trim().equalsIgnoreCase(""))
                System.out.println(arrayList.get(i).trim());
        }
        launch();
    }
}