package com.senla.test3;

import com.senla.utils.InputUtils;
import com.senla.utils.StringUtils;

public class Main {

    public static void main(String[] args) {
        String sentence = InputUtils.readSentenceFromStdIn();

        String[] words = StringUtils.getWords(sentence);

        switch (words.length) {
            case 0:
                System.out.print("There are no words in your sentence\n");
                break;
            case 1:
                System.out.print("There is 1 word in your sentence\n");
                break;
            default:
                System.out.printf("There are %d words in your sentence\n", words.length);
                break;
        }

        System.out.printf("Sorted words: %s\n", String.join(" ", StringUtils.sortWords(words)));

        System.out.printf("Your sentence with capital letters: %s\n",
                String.join(" ", StringUtils.toUpperCaseFirstLetter(words)));
    }
}
