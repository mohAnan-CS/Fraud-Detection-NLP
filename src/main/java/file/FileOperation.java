package file;

import ngram.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileOperation {

    public static Map<String, Model> languageModelHashMap = new HashMap<>();

    public static void readLanguageModelFile(String path){

        try {

            File file = new File(path);
            Scanner scanner = new Scanner(file);

            scanner.nextLine();

            while (scanner.hasNextLine()){

                String data = scanner.nextLine();
                String[] splitLine = data.split(",");
                String word = splitLine[0].trim();
                int gram = Integer.parseInt(splitLine[1]);
                int count = Integer.parseInt(splitLine[2]);
                float probability = Float.parseFloat(splitLine[3]);
                Model model = new Model(word, gram, count,probability);
                languageModelHashMap.put(word, model);

            }

            scanner.close();
            printHashTable(languageModelHashMap);

        }catch (FileNotFoundException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }

    private static void printHashTable(Map<String , Model> hashMap){

        for (String model : hashMap.keySet()) {
            System.out.println(hashMap.get(model));
        }

    }

}
