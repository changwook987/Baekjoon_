package NONBAEKJOON.javaFile.problem2819;

import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    private static void solution(Set<String> set, StringBuilder sb, int n, int[][] map, int x, int y) {
        if (n == 7) {
            set.add(sb.toString());
        } else {
            sb.append(map[x][y]);

            solution(set, sb, n + 1, map, (x + 1) % 4, y);
            solution(set, sb, n + 1, map, (x + 3) % 4, y);
            solution(set, sb, n + 1, map, x, (y + 1) % 4);
            solution(set, sb, n + 1, map, x, (y + 3) % 4);

            sb.deleteCharAt(n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            SortedSet<String> set = new TreeSet<>();

            int[][] arr = new int[4][4];

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    solution(set, new StringBuilder(), 0, arr, j, k);
                }
            }

            for (String a : set) {
                System.out.println(a);
            }
            System.out.printf("#%d %d\n", i + 1, set.size());
        }
    }
}
