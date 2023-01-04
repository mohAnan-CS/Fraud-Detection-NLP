package birzeit.university.plagiarismdetection;

import file.FileOperation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import validating.StopWordRemover;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static birzeit.university.plagiarismdetection.Runner.*;

public class HelloController implements Initializable {
    @FXML
    private TextArea textArea;

    @FXML
    private TableView<TableViewScore> table;

    @FXML
    private TableColumn<TableViewScore, String> number;

    @FXML
    private TableColumn<TableViewScore, String> score;

    @FXML
    private TableColumn<TableViewScore, String> plagiarism;

    ObservableList<TableViewScore> scoreObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StopWordRemover.readStopWordsFromCSV("stopwords");
        FileOperation.readLanguageModelFile("language_model.csv");
    }

    @FXML
    void btnGoOnAction() {

        String sentence = textArea.getText();
        String[] split = splitSentences(sentence);
        ArrayList<String> arrayListValidateCorpus = validateCorpus(split);
        ArrayList<String> arrayList = prepareCorpusIntoGram(arrayListValidateCorpus);
        setAllCellValues();
        fillTableView(arrayList);


    }

    private void fillTableView(ArrayList<String> arrayListScore){

        for (int i=0 ; i < arrayListScore.size() ;i++)
            scoreObservableList.add(new TableViewScore(String.valueOf(i), arrayListScore.get(i), "Yes"));


        table.setItems(scoreObservableList);

    }

    private void setAllCellValues(){

        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        plagiarism.setCellValueFactory(new PropertyValueFactory<>("plagiarism"));
    }


}