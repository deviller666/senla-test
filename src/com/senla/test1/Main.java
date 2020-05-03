package com.senla.test1;

import com.senla.utils.InputUtils;
import com.senla.utils.NumberUtils;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
    	int number;
    	try {
			number = InputUtils.readNumberFromStdIn();
		} catch (InputMismatchException e) {
    		System.out.println("Your input is not a number");
    		return;
		}

    	System.out.printf("Your number is %s & %s\n",
				NumberUtils.isEven(number) ? "even" : "odd",
				NumberUtils.isPrime(number) ? "prime" : "not prime");
    }
}
