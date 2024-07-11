package org.example.calcuator;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        UtilMethods utilMethods = new UtilMethodsImpl();
        System.out.println("Input the expression (+, -, *, /): ");

        try (Scanner scanner = new Scanner(System.in)) {
            String[] strings = scanner.nextLine().trim().split(" +");
            try {
                System.out.println(utilMethods.getResult(strings));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Uncorrected expression");
            }
        }
    }
}
