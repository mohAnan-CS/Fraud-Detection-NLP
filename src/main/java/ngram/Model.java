package ngram;

public class Model {

    private String word;
    private int gram;
    private int count;
    private float probabilities;

    public Model(String word, int gram, int count, float probabilities) {
        this.word = word;
        this.gram = gram;
        this.count = count;
        this.probabilities = probabilities;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getGram() {
        return gram;
    }

    public void setGram(int gram) {
        this.gram = gram;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(float probabilities) {
        this.probabilities = probabilities;
    }

    @Override
    public String toString() {
        return "Model{" +
                "word='" + word + '\'' +
                ", gram=" + gram +
                ", count=" + count +
                ", probabilities=" + probabilities +
                '}';
    }

}