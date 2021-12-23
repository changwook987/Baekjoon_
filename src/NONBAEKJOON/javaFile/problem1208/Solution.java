package NONBAEKJOON.javaFile.problem1208;

//문제링크
//https://url.kr/3eg7d4

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int dump = sc.nextInt();

            int[] ints = new int[100];

            for (int j = 0; j < 100; j++) {
                ints[j] = sc.nextInt();
            }

            for (int j = 0; j < dump; j++) {
                Arrays.sort(ints);

                ints[0]++;
                ints[99]--;
            }

            Arrays.sort(ints);

            System.out.printf("#%d %d\n", i + 1, ints[99] - ints[0]);
        }
    }
}
