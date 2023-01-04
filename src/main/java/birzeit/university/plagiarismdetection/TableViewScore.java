package birzeit.university.plagiarismdetection;

public class TableViewScore {

    private String number;
    private String score;
    private String plagiarism;

    public TableViewScore(String number, String score, String plagiarism) {
        this.number = number;
        this.score = score;
        this.plagiarism = plagiarism;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPlagiarism() {
        return plagiarism;
    }

    public void setPlagiarism(String plagiarism) {
        this.plagiarism = plagiarism;
    }

    @Override
    public String toString() {
        return "TableViewScore{" +
                "number='" + number + '\'' +
                ", score='" + score + '\'' +
                ", plagiarism='" + plagiarism + '\'' +
                '}';
    }
}
