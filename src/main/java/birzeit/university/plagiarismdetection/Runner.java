package birzeit.university.plagiarismdetection;

import tokenizer.ArabicTokenizer;
import validating.Normalization;
import validating.StopWordRemover;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        StopWordRemover.readStopWordsFromCSV("stopwords");
        String sentence = "محمد عنان أبو جزر . في جامعة بير زيت";
        String[] split = splitSentences(sentence);
        validateCorpus(split);

    }

    public static String[] splitSentences(String text){

        return text.split("\\.");

    }

    public static ArrayList<String> validateCorpus(String[] arrayCorpus){

        ArrayList<String> arrayListValidateCorpus = new ArrayList<>();

        for (String string : arrayCorpus) {

            List<String> stringList = ArabicTokenizer.tokenize(string);
            String sentence = convertList(stringList);
            if (!sentence.trim().equalsIgnoreCase("")){

                sentence = StopWordRemover.removeStopWords(sentence);
                sentence = Normalization.normalize(sentence);
                System.out.println(sentence);
                arrayListValidateCorpus.add(sentence);

            }

        }

        return arrayListValidateCorpus ;

    }

    private static String convertList(List<String> stringList){

        String sentence = "" ;
        for (String s : stringList) {
            sentence += s.trim() + " ";
        }
        return sentence.trim();

    }

}
