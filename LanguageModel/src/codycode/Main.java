package codycode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No files provided.");
            return;
       }

        MyHashTable hashTable = new MyHashTable();

        for (String filename : args) {
            try {
                processFile(filename, hashTable);
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filename);
            }
        }

        System.out.println(hashTable);
    }

    private static void processFile(String filename, MyHashTable hashTable) throws FileNotFoundException {
        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);

        String prevWord = null;
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", ""); // Remove punctuation
            if (!word.isEmpty()) { // Check if the word is not empty after removing punctuation
                if (prevWord != null) {
                    hashTable.add(prevWord, word);
                }
                prevWord = word;
            }
            prevWord = word;
        }
        
        

        scanner.close();
    }
    
}

