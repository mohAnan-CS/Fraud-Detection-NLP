module com.example.plagiarismdetection {
    requires javafx.controls;
    requires javafx.fxml;


    opens birzeit.university.plagiarismdetection to javafx.fxml;
    exports birzeit.university.plagiarismdetection;
}