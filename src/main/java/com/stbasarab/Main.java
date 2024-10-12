package com.stbasarab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws RuntimeException {
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(Paths.get("text.txt"));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + e.getMessage());
        }

        StringBuffer text = new StringBuffer(new String(bytes));

        try {
            TextProcessor textProcessor = new TextProcessor(text);
            StringBuffer uniqueWord = textProcessor.findUniqueWord();
            System.out.println("The first unique word in the text is: " + uniqueWord);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error finding unique word: " + e.getMessage());
        }
    }
}