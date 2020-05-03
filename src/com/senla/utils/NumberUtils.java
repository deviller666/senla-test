package com.senla.utils;

public class NumberUtils {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i += 1) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        } else {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            int max = Math.max(absA, absB);
            int min = Math.min(absA, absB);
            return gcd(max % min, min);
        }
    }

    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else {
            return Math.abs(a * b) / gcd(a, b);
        }
    }

    public static int countPalindromesFrom0ToN(int n) {
        if (n < 10) {
            return n + 1;
        } else if (n < 100) {
            return n / 11 + 10;
        } else {
            int count = 0;
            for (int i = 100; i <= n; i += 1) {
                String iString = Integer.toString(i);
                if (iString.equals(new StringBuilder(iString).reverse().toString())) {
                    count += 1;
                }
            }

            return count + 100 / 11 + 10;
        }
    }

}
