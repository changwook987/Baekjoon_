package NONBAEKJOON.javaFile.problem1210;

//문제링크
//https://url.kr/8nd9x4

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int caseNum = sc.nextInt();

            int[][] map = new int[100][100];

            int first = 0;

            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    map[j][k] = sc.nextInt();
                    if (map[j][k] == 2) {
                        first = k;
                    }
                }
            }

            int cur = first;

            for (int j = 98; j >= 0; j--) {
                while (cur != 0 && map[j][cur - 1] == 1) {
                    cur--;
                    map[j][cur] = 0;
                }

                while (cur != 99 && map[j][cur + 1] == 1) {
                    cur++;
                    map[j][cur] = 0;
                }
            }

            System.out.printf("#%d %d\n", caseNum, cur);
        }
    }
}
