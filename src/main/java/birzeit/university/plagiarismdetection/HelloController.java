package birzeit.university.plagiarismdetection;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public  ArrayList<String> tokenizeWord(String sentence){

        String[] split = sentence.split(" ");
        return convertArrayToArrayList(split);

    }

    public static ArrayList<String> convertArrayToArrayList(String[] array){

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(array));
        return arrayList;

    }

}