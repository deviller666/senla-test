package com.senla.test2;

import com.senla.utils.InputUtils;
import com.senla.utils.NumberUtils;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        int a,b;
        try {
            a = InputUtils.readNumberFromStdIn();
            b = InputUtils.readNumberFromStdIn();
        } catch (InputMismatchException e) {
            System.out.println("Your input is not a number");
            return;
        }

        System.out.printf("Your number LCM is %d & GCD is %d",
                NumberUtils.lcm(a, b),
                NumberUtils.gcd(a, b));
    }

}
