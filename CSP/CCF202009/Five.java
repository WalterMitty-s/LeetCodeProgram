package com.company.CSP.CCF202009;

import java.util.Scanner;

public class Five {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        decodeBook[][] book = new decodeBook[26][n];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < n; j++) {
                String temp = scanner.next();
                book[i][j]=new decodeBook();
                book[i][j].decodeBookValue(temp);
                System.out.println(book[i][j].out+"  "+book[i][j].page);
            }
        }
        String[] strings = new String[m];
        for(int i=0;i<m;i++){
            strings[i]=scanner.next();
            System.out.println(strings[i]);
        }


    }
}

class decodeBook {
    char out;
    int page;
    decodeBook(){

    }
    public void decodeBookValue(String in) {
        this.out = in.charAt(0);
        this.page = Integer.parseInt(in.substring(1));
    }
}
