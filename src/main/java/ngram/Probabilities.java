package ngram;

import tokenizer.ArabicTokenizer;

import java.util.ArrayList;

public class Probabilities {

    public static ArrayList<Float> SCORES_ARRAY_LIST = new ArrayList<>();

    public float calculatePlagiarismScore(float[] probabilities , int numberOfGram){

        float sumProbability = 0 ;
        for (float probability : probabilities)
            sumProbability+=probability;

        return sumProbability/numberOfGram ;

    }

}
