package ngram;

import birzeit.university.plagiarismdetection.Runner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Gram {

    public static ArrayList<Model> arrayListModels = new ArrayList<>();

    public static void buildFourGram(ArrayList<List<String>> tokenizeArrayList){

        for (List<String> strings : tokenizeArrayList) {

            makeOneGram(strings);
            makeTwoGram(strings);
            makeThreeGram(strings);
            makeFourGram(strings);

        }

        //Probabilities.setAllProbabilities();

    }

    public static void makeOneGram(List<String> array){

        for (String word : array) {

            if (!word.trim().equalsIgnoreCase("")) {

                setProbability(word.trim());

            }

        }

    }

    public static void makeTwoGram(List<String> array){

        int firstIndex = 0 , secondIndex = 1 ;

        if (array.size() > 1 ) {

            for (int i = 0; i < array.size() - 1 ; i++) {

                if (!array.get(i).trim().equalsIgnoreCase("")) {

                    String firstWord = array.get(firstIndex);
                    String secondWord = array.get(secondIndex);
                    String sentence = firstWord.trim() + " " + secondWord.trim();

                    setProbability(sentence.trim());

                    firstIndex += 1;
                    secondIndex += 1;

                }

            }

        }

    }

    public static void makeThreeGram(List<String> array){

        int firstIndex = 0 , secondIndex = 1 , thirdIndex = 2 ;

        if (array.size() > 2 ) {

            for (int i = 0; i < array.size() - 2 ; i++) {

                if (!array.get(i).trim().equalsIgnoreCase("")) {

                    String firstWord = array.get(firstIndex);
                    String secondWord = array.get(secondIndex);
                    String thirdWord = array.get(thirdIndex);
                    String sentence = firstWord.trim() + " " + secondWord.trim() + " " + thirdWord.trim();

                    setProbability(sentence.trim());

                    firstIndex += 1;
                    secondIndex += 1;
                    thirdIndex += 1;

                }

            }

        }

    }

    public static void makeFourGram(List<String> array){

        int firstIndex = 0 , secondIndex = 1 , thirdIndex = 2 , fourIndex = 3;

        if (array.size() > 3 ) {

            for (int j = 0; j < array.size() - 3 ; j++) {

                if (!array.get(j).trim().equalsIgnoreCase("")) {

                    String firstWord = array.get(firstIndex).trim();
                    String secondWord = array.get(secondIndex).trim();
                    String thirdWord = array.get(thirdIndex).trim();
                    String fourthWord = array.get(fourIndex).trim();
                    String sentence = firstWord.trim() + " " + secondWord.trim() + " "
                            + thirdWord.trim() + " " + fourthWord.trim();

                    setProbability(sentence);

                    firstIndex += 1;
                    secondIndex += 1;
                    thirdIndex += 1;
                    fourIndex += 1;

                }

            }

        }

    }

    public static void setProbability(String sentence){

        if (isFound(sentence.trim())) {

            Model model = Runner.LANGUAGE_MODEL_HASH_MAP.get(sentence.trim());
            Probabilities.SCORES_ARRAY_LIST.add(model.getProbabilities());

        } else {

            Probabilities.SCORES_ARRAY_LIST.add(Float.parseFloat("0"));

        }

    }

    private static boolean isFound(String word) {

        return Runner.LANGUAGE_MODEL_HASH_MAP.get(word.trim()) != null;

    }


}
