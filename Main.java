package com.company;

import com.company.Base.AboutString.Solution14;
import com.company.Base.StackAndDiGui.Solution682;

public class Main {
    public static void main(String[] args) {
        Solution682 solution=new Solution682();
        String[] ops = {"5","2","C","D","+"};

        String[] ops2 = {"5","-2","4","C","D","9","+","+"};
        int num = solution.calPoints(ops);
        System.out.println("result is : "+ num);
    }

}

