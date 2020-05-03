package com.senla.test5;

import com.senla.utils.InputUtils;
import com.senla.utils.NumberUtils;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        int sequenceLength;
        try {
            sequenceLength = InputUtils.readNumberFromStdIn("Enter any number between 0 and 100: ");
        } catch (InputMismatchException e) {
            System.out.println("Your input is not a number");
            return;
        }

        if (sequenceLength < 0) {
            System.out.println("Your input is less then 0");
            return;
        } else if (sequenceLength > 100) {
            System.out.println("Your input is greater then 100");
            return;
        }

        int palindromesCount = NumberUtils.countPalindromesFrom0ToN(sequenceLength);
        if (palindromesCount == 0) {
            System.out.print("There are no palindromes in your sequence");
        } else if (palindromesCount == 1) {
            System.out.print("There is 1 palindromes in your sequence");
        } else {
            System.out.printf("There are %d palindromes in your sequence", palindromesCount);
        }
    }

}
