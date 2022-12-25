package com.company.Polibius;

import java.util.Scanner;

public class Main {
    public static void polybiusCipher(String s) {
        int row, col;

        for (int i = 0; i < s.length(); i++) {

            row = (int) Math.ceil((s.charAt(i) - 'a') / 5) + 1;
            col = ((s.charAt(i) - 'a') % 5) + 1;

            if (s.charAt(i) == 'k') {
                row = row - 1;
                col = 5 - col + 1;
            } else if (s.charAt(i) >= 'j') {
                if (col == 1) {
                    col = 6;
                    row = row - 1;
                }
                col = col - 1;
            }
            System.out.print(row + "" + col + " ");
        }
    }

    public static void invertPolybiusCipher(String s) {
        if (s.length() % 2 != 0) {
            System.out.println("Error - you have to put the even number of characters ");
            return;
        }

        int numberOfNumbers = s.length();
        int liczbaLiter = numberOfNumbers / 2;

        System.out.println("Liczba znakow po konwercji bedziee: " + liczbaLiter);

        int p = 1;
        int np = 1;

        for (int i = 0; i < numberOfNumbers; i++) {

            char ch = s.charAt(i);


            if (ch % 2 == 0) {

                System.out.println("p = " + p + "  Parzysta   |" + ch);
                p++;

            } else if (ch % 2 != 0) {

                System.out.println("np = " + np + "  Nie Parzysta   |" + ch);
                np++;
            }

            for (int j = 0; j < numberOfNumbers; j++) {
                if (j == ch) {
                    System.out.println("ch");
                }
            }
        }


    }

    // Driver code
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type Encrypt to encrypt into Polubius Square or type Decrypt to decrypt numbers into text by Polybius Square");
        String choice = scanner.nextLine();

        if (choice.equals("encrypt")) {

            System.out.println("Type the text to convert into Polybius Square: ");
            String text = scanner.nextLine();

            //  s = "bus";
            polybiusCipher(text);

        } else if (choice.equals("asd")) {

            System.out.println("Type the numbers to make a convert from Polybius Square: ");
            String text = scanner.nextLine();

            //  s = "bus";
            invertPolybiusCipher(text);

        } else {
            System.out.println("Error. Try to choose again.");
        }


    }
}