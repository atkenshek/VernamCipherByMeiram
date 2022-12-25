package com.company;

/**
 * @author Meiram Sopy Temirzhanov
 */
public class CaesarCipher {
    public static String encrypt(String string, int key) {
        String coded = "";
        for (int i = 0; i < string.length(); i++) {
            char sm = (char) (string.codePointAt(i) + key);
            coded += sm;
        }
        return coded;
    }

    public static String decrypt(String coded, int key) {
        String decoded = "";
        for (int i = 0; i < coded.length(); i++) {
            char sm = (char) (coded.codePointAt(i) - key);
            decoded += sm;
        }
        return decoded;
    }
}
