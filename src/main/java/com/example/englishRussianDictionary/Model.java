package com.example.englishRussianDictionary;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class Model {
    TreeMap<String, String> words = new TreeMap<>();

    /*
    This method checks and adds dates to "words" collection,
     and it uses checkEnglish() and checkRussian()
     */
    public boolean putWords(String inputText) {
        boolean result = false;
        String[] box = inputText.split(" ");
        if (box.length == 2 && !words.containsKey(box[0])) {
            if (checkEnglish(box[0]) && checkRussian(box[1])) {
                words.put(box[0], box[1]);
                result = true;
            }
        }
        return result;
    }

    /*
    This method checks only english symbols
     */
    private boolean checkEnglish(String value) {
        return  value.matches("^[a-zA-Z]+$");
    }

    /*
    This method checks only russian symbols
     */
    private boolean checkRussian(String value) {
        return  value.matches("^[а-яА-Я]+$");
    }

    /*
    This method removes key and value fom "words" collection
     */
    public void removeWordsByKey(String key) {
        words.remove(key);
    }

    /*
    This method edits value fom "words" collection
     */
    public String editeWordsByKey(String key) {
        String result = key + " " + words.get(key);
        words.remove(key);
        return result;
    }

    /*
    This method opens and reads dats from the file
     */
    public void openAndReadFile(String link) {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(link, StandardCharsets.UTF_8))) {
            String readReader = reader.readLine();
                while (readReader != null) {
                    putWords(readReader);
                    readReader = reader.readLine();
                }
            } catch (Exception e) {
                System.out.println("File dose not exist.");
            }
    }

    /*
    This method creates and writs dats into the file
     */
    public void createAndWriteFile(String link) {
        File fileName = new File(link);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, StandardCharsets.UTF_8)))
        {
            for (Map.Entry<String, String> value : words.entrySet()) {
                writer.write(value.getKey() + " " + value.getValue() + "\n");
            }
        } catch (Exception e) {
            System.out.println("There was a problem with writing to the file");
        }
    }
}
