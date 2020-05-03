package com.senla.utils;

import java.util.Arrays;

public class StringUtils {

    public static String[] getWords(String string) {
        if (string == null || string.isEmpty()) {
            return new String[0];
        }

        return string.split("\\s+");
    }

    public static String[] sortWords(String[] words) {
        String[] wordsCopy = new String[words.length];
        System.arraycopy(words, 0, wordsCopy, 0, words.length);

        Arrays.sort(wordsCopy, String::compareToIgnoreCase);

        return wordsCopy;
    }

    public static String[] toUpperCaseFirstLetter(String[] words) {
        return (String[]) Arrays
                .stream(words)
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .toArray();
    }

    public static int countWordOccurrences(String[] words, String word) {
        // Array size cannot be greater then int
        return (int) Arrays.stream(words).filter(s -> s.equals(word)).count();
    }

}
