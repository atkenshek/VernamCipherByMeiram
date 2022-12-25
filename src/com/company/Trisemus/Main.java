package com.company.Trisemus;

import java.util.Scanner;

public class Main {

    static String key="mouse";
    static String word="alpachino";
    static String todecode="hrwhenotv";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Write the word\n");
        key=in.nextLine();
        System.out.println("To encode\n");
        word=in.nextLine();
        
        TrisemusTable newtable = new TrisemusTable();
        EnCode incode=new EnCode();
        String incodeword=incode.getWord(key,word);

        DeCode decode=new DeCode();
        String decodeword=decode.getWord(key,todecode);

        System.out.println("\n\nYour word is "+word+"\nIncoding word: "+incodeword);
        System.out.println("\n\nYour word is "+word+"\nDecoding word: "+decodeword);

    }
}