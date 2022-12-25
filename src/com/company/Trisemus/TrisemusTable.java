package com.company.Trisemus;

public class TrisemusTable {

    private int line=5;
    private int column=5;
    private String alphabet="abcdefghijklmnoprstuvwxyz";
    private char[] allsymbol=new char[100];
    private char[] tr=new char[40];
    private char[][] table=new char[6][9];

    public TrisemusTable(){
    }

    public char[][] getTable(String key){
        allsymbol=(key+alphabet).toCharArray();
        tr=removeDuplicates(allsymbol);
        for (int n=0, i=0;i<line;i++) {
            for (int j = 0; j < column; j++) {
                if((i<tr.length)||(j<tr.length)) {
                    table[i][j] = tr[n];
                    n++;
                }
                else{
                    break;
                }
            }
        }
        return table;
    }

    public char[] removeDuplicates(char[] values) {
        boolean mask[] = new boolean[values.length];
        int removeCount = 0;

        for (int i = 0; i < values.length; i++) {
            if (!mask[i]) {
                char tmp = values[i];

                for (int j = i + 1; j < values.length; j++) {
                    if (tmp == values[j]) {
                        mask[j] = true;
                        removeCount++;
                    }
                }
            }
        }

        char[] result = new char[values.length - removeCount];

        for (int i = 0, j = 0; i < values.length; i++) {
            if (!mask[i]) {
                result[j++] = values[i];
            }
        }
        return result;

    }

}