package com.company.VernamCipher;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

/**
 * @author Meiram Sopy Temirzhanov
 */
public class Main {
    public static void main(String[] args) {
        System.out.print("Enter the message: ");
        Scanner scanner = new Scanner(System. in);
        String inputString = scanner.nextLine();
        System.out.print("Enter the key: ");
        String key = scanner.nextLine();
        byte[] messageBytes = inputString.getBytes(StandardCharsets.US_ASCII);

        byte[] keyBytes = key.getBytes(StandardCharsets.US_ASCII);

        byte[] encryptedBytes = new byte[messageBytes.length];
        byte[] decryptedBytes = new byte[messageBytes.length];


        vernamCipher(messageBytes, keyBytes, encryptedBytes);
        vernamCipher(encryptedBytes, keyBytes, decryptedBytes);

        String s = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.print('\n');
        System.out.println("**********************************************");
        System.out.print('\n');
        System.out.println("Binary representation: ");
        System.out.println(inputString + ": " + Arrays.toString(BytesAsBinaryString(messageBytes).split("(?<=\\G.{8})")));
        System.out.println(key + ": " + Arrays.toString(BytesAsBinaryString(keyBytes).split("(?<=\\G.{8})")));
        System.out.println(s + Arrays.toString(BytesAsBinaryString(encryptedBytes).split("(?<=\\G.{8})")));

        System.out.println("Bytes representation: " + Arrays.toString(encryptedBytes));
        System.out.print('\n');
        System.out.println("**********************************************");
        System.out.print('\n');

        System.out.println("Message original: " + inputString);
        System.out.println("Key original: " + key);
        System.out.println("Encrypted message in string: " + s);
        System.out.print('\n');


        System.out.print('\n');



    }

    private static void vernamCipher(byte[] M, byte[] K, byte[] C){
        for (int i = 0; i < M.length; i++){
            C[i] = (byte) (M[i] ^ K[i]);
        }
    }


    private static String BytesAsBinaryString(byte[] byteArray){
        StringBuilder result = new StringBuilder();
        for (byte b : byteArray) {
            result.append(Integer.toBinaryString(b & 255 | 256).substring(1));
        }
        return result.toString();
    }

    private static int[] byteArrayToIntArray(byte[] barray) {
        int[] iarray = new int[barray.length];
        int i = 0;
        for (byte b : barray)
            iarray[i++] = b & 0xff;
        return iarray;
    }

}
