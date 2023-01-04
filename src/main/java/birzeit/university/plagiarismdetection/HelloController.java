package birzeit.university.plagiarismdetection;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private TextArea textArea;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> number;

    @FXML
    private TableColumn<?, ?> score;

    @FXML
    private TableColumn<?, ?> plagiarism;

    @FXML
    void btnGoOnAction() {
        System.out.println("hello");
    }

}