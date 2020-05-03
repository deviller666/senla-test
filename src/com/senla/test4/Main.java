package com.senla.test4;

import com.senla.utils.InputUtils;
import com.senla.utils.StringUtils;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        String sentence = InputUtils.readSentenceFromStdIn();
        String wordToCount;
        try {
            wordToCount = InputUtils.readWordFromStdIn();
        } catch (InputMismatchException e) {
            System.out.println("Your input is not a single word");
            return;
        }

        String[] words = StringUtils.getWords(sentence);

        int wordsCount = StringUtils.countWordOccurrences(words, wordToCount);
        switch (wordsCount) {
            case 0:
                System.out.print("There is no such word in your sentence");
                break;
            case 1:
                System.out.print("There is 1 word in your sentence");
                break;
            default:
                System.out.printf("There are %d such words in your sentence", wordsCount);
                break;
        }
    }

}
