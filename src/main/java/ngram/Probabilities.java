package ngram;

import birzeit.university.plagiarismdetection.Runner;
import java.util.ArrayList;

public class Probabilities {

    public static ArrayList<Model> PROBABILITIES_ARRAY_LIST = new ArrayList<>();

    public static String calculatePlagiarismScore(){

        float sumProbability = 1 ;
        int numberOfGram = PROBABILITIES_ARRAY_LIST.size();

        for (Model model : PROBABILITIES_ARRAY_LIST) {
            System.out.println(model);
            sumProbability += model.getProbabilities();
        }

        float result = ( ( sumProbability/numberOfGram ) * 100 ) * 2 ;

        if (result < 100) {
            return String.format("%.2f", result);
        }
        else {
            return "100";
        }

    }

    private static void getProbabilityOneGram(String[] wordArray){

        for (String word : wordArray) {

            if (!word.trim().equalsIgnoreCase("")) {

                setProbability(word.trim());

            }

        }

    }

    private static void getProbabilityTwoGram(String[] wordArray){

        int firstIndex = 0 , secondIndex = 1 ;

        if (wordArray.length > 1 ) {

            for (int i = 0; i < wordArray.length - 1 ; i++) {

                if (!wordArray[i].trim().equalsIgnoreCase("")) {

                    String firstWord = wordArray[firstIndex];
                    String secondWord = wordArray[secondIndex];
                    String sentence = firstWord.trim() + " " + secondWord.trim();

                    setProbability(sentence.trim());

                    firstIndex += 1;
                    secondIndex += 1;

                }

            }

        }

    }

    private static void getProbabilityThreeGram(String[] wordArray){

        int firstIndex = 0 , secondIndex = 1 , thirdIndex = 2 ;

        if (wordArray.length > 2 ) {

            for (int i = 0; i < wordArray.length - 2 ; i++) {

                if (!wordArray[i].trim().equalsIgnoreCase("")) {

                    String firstWord = wordArray[firstIndex];
                    String secondWord = wordArray[secondIndex];
                    String thirdWord = wordArray[thirdIndex];
                    String sentence = firstWord.trim() + " " + secondWord.trim() + " " + thirdWord.trim();

                    setProbability(sentence.trim());

                    firstIndex += 1;
                    secondIndex += 1;
                    thirdIndex += 1;

                }

            }

        }

    }

    private static void getProbabilityFourGram(String[] wordArray){

        int firstIndex = 0 , secondIndex = 1 , thirdIndex = 2 , fourIndex = 3;

        if (wordArray.length > 3 ) {

            for (int j = 0; j < wordArray.length - 3 ; j++) {

                if (!wordArray[j].trim().equalsIgnoreCase("")) {

                    String firstWord = wordArray[firstIndex].trim();
                    String secondWord = wordArray[secondIndex].trim();
                    String thirdWord = wordArray[thirdIndex].trim();
                    String fourthWord = wordArray[fourIndex].trim();
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

    private static void setProbability(String sentence){

        if (isFound(sentence.trim())) {

            Model model = Runner.LANGUAGE_MODEL_HASH_MAP.get(sentence.trim());
            PROBABILITIES_ARRAY_LIST.add(model);

        }else {

            Model model = new Model("" , 0, 0, 0);
            PROBABILITIES_ARRAY_LIST.add(model);

        }

    }

    private static boolean isFound(String word) {

        return Runner.LANGUAGE_MODEL_HASH_MAP.get(word.trim()) != null;

    }

    public static void getAllProbabilities(String[] wordArray){

        getProbabilityOneGram(wordArray);
        getProbabilityTwoGram(wordArray);
        getProbabilityThreeGram(wordArray);
        getProbabilityFourGram(wordArray);

    }

}
