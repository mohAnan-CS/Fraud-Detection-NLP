package birzeit.university.plagiarismdetection;

import file.FileOperation;
import ngram.Model;
import ngram.Probabilities;
import tokenizer.ArabicTokenizer;
import validating.Normalization;
import validating.StopWordRemover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Runner {

    public static HashMap<String , Model> LANGUAGE_MODEL_HASH_MAP = new HashMap<>();

    public static void main(String[] args) {

        StopWordRemover.readStopWordsFromCSV("stopwords");
        FileOperation.readLanguageModelFile("language_model.csv");
        String sentence = "محمد عنان ابو منها غاز جزر.وينتج  بركات عناني جرار الاوكسجين . وينتج منها غاز الايثيلين .دمه واللي حلو بتفانيه محمد عنان ابو جزر في جامعة بير زيت يدرس علم الحاسوب عبادة الجرس في كلية الاي تي وكان يمارس الرياضة وسط الكلية والجكيع مذهول منه. السعوديين حلوين اللي حلو وجهه وشكله واللي حلو اخلاقه واللي حلو خفه دمه واللي حلو بتفانيه وعمله وخدمه مجتمعه ووطنه . سكون شداد فتحخي كخيه حخحسبي . اعوام وكان بالنسبه نافذه مطله العالم اوصل الخبر مباشر بدون واسطه صحيفه او قناه واوصل صوتنا للناس اوصل اصوات الناس الينا تشرفت بمعرفه الكثير الاصدقاء مختلف بلاد العالم خلاله.محمد عنان ابو";
        String[] split = splitSentences(sentence);
        ArrayList<String> arrayListValidateCorpus = validateCorpus(split);
        prepareCorpusIntoGram(arrayListValidateCorpus);

    }

    public static ArrayList<String> prepareCorpusIntoGram(ArrayList<String> arrayListValidate){

        ArrayList<String> arrayList = new ArrayList<>();

        for (String s : arrayListValidate) {
            String[] wordSplit = s.split(" ");
            Probabilities.getAllProbabilities(wordSplit);
            String score = Probabilities.calculatePlagiarismScore();
            Probabilities.PROBABILITIES_ARRAY_LIST.clear();
            System.out.println("Score = " + score + "%");
            System.out.println("----------------");
            arrayList.add(score+"%");
        }

        return arrayList;
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
