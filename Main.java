package com.company;

import javafx.stage.Stage;

import java.util.Deque;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Solution349 solution349=new Solution349();
        int[] one={1,2,2,1};
        int[] two={2,2};
        for(int s:solution349.intersection(one,two)){
            System.out.println(s);
        }
    }
}

