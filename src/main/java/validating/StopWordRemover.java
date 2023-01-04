package validating;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StopWordRemover {

    public static ArrayList<String> STOP_WORDS_ARRAY_LIST = new ArrayList<>();

    public static void readStopWordsFromCSV(String fileName){

        ArrayList<String> arrayListCorpus = new ArrayList<>();

        try {

            File file = new File(fileName.concat(".txt"));
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                STOP_WORDS_ARRAY_LIST.add(line.trim());

            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static String removeStopWords(String input) {

        String[] words = input.split("\\s+");
        StringBuilder output = new StringBuilder();

        for (String word : words)
            if (!STOP_WORDS_ARRAY_LIST.contains(word))
                output.append(word).append(" ");

        return output.toString().trim();

    }

}