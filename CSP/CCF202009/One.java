package com.company.CSP.CCF202009;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        int num;
        int x, y;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        int[][] checkPoint = new int[num][2];
        int[][] temp = new int[num][2];
        for (int i = 0; i < num; i++) {
            checkPoint[i][0] = scanner.nextInt();
            checkPoint[i][1] = scanner.nextInt();
            temp[i][0] = i + 1;
            int result = (checkPoint[i][0] - x) * (checkPoint[i][0] - x) + (checkPoint[i][1] - y) * (checkPoint[i][1] - y);
            temp[i][1] = result;
        }
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < 3; i++) {
            System.out.println(temp[i][0]);
        }

    }
}
