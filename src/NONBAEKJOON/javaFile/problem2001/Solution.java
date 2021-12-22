package NONBAEKJOON.javaFile.problem2001;

//문제 링크
//https://url.kr/n59khw

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int caseNum = sc.nextInt();
        for (int i = 0; i < caseNum; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            int max = Integer.MIN_VALUE;

            for (int j = 0; j <= n - m; j++) {
                for (int k = 0; k <= n - m; k++) {
                    int sum = 0;
                    for (int l = 0; l < m; l++) {
                        for (int o = 0; o < m; o++) {
                            sum += arr[j + l][k + o];
                        }
                    }
                    max = Math.max(sum, max);
                }
            }

            System.out.printf("#%d %d\n", i + 1, max);
        }
    }
}
