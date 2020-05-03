package com.senla.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    public static int readNumberFromStdIn(String message) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);

        return scanner.nextInt();
    }

    public static int readNumberFromStdIn() throws InputMismatchException {
        return readNumberFromStdIn("Enter any number: ");
    }

    public static String readSentenceFromStdIn(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);

        return scanner.nextLine();
    }

    public static String readSentenceFromStdIn() {
        return readSentenceFromStdIn("Enter any sentence: ");
    }

    public static String readWordFromStdIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word to count: ");

        String word = scanner.nextLine();
        if (word.contains(" ")) {
            throw new InputMismatchException();
        } else {
            return word;
        }
    }

}
