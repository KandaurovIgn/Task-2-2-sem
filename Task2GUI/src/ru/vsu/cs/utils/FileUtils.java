package ru.vsu.cs.utils;

import ru.vsu.cs.common.LinkList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static LinkList readFromFile(String fileName) {
        try {
            String[] lines = readLinesFromFile("src/ru/vsu/cs/files/" + fileName);//"src\\ru\\vsu\\cs\\files\\"
            LinkList wordsList = new LinkList();
            for (int k = lines.length - 1; k >= 0; k--) {
                String[] wordsArray = stringLineToWords(lines[k]);
                for (int j = wordsArray.length - 1; j >= 0; j--)
                    wordsList.insertFirst(wordsArray[j]);
            }

            return wordsList;
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
            System.exit(1);
        }
        return null;
    }

    private static String[] readLinesFromFile(String fileName) throws FileNotFoundException {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        }
        return lines.toArray(new String[0]);
    }

    private static String[] stringLineToWords(String line) {
        String[] wordsArray = line.split(" ");

        return wordsArray;
    }

    public static void writeToFile(LinkList linkList, String fileName) throws IOException {
        FileWriter outputFile = new FileWriter("src/ru/vsu/cs/files/" + fileName);
        String word = linkList.getWord();
        while (word != null) {
            outputFile.write(word + " ");
            word = linkList.getWord();
        }
        outputFile.close();
    }
}
