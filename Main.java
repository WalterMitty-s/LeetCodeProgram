package com.company;

public class Main {

    public static void main(String[] args) {
        int x=2;
        int j=1;
        switch (x){
            case 1:j++;
            case 2:j++;
            case 3:j++;
            default:j++;
        }
        System.out.println(j+x);

    }
}

