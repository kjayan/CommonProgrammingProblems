package com.learn.common.numeric;

public class DecimalToBinary {

    public static void main(String[] args) {
        printBinaryform(10);
    }

    private static void printBinaryform(int number) {
        int remainder;

        if (number <= 1) {
            System.out.print(number);
            return;
        }
        remainder = number %2;
        printBinaryform(number >> 1);
        System.out.print(remainder);
    }
}
