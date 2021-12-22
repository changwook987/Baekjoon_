package NONBAEKJOON.javaFile.problem1289;

//problem link
//https://url.kr/pu6dtx

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(r.readLine());

        for (int i = 0; i < n; i++) {
            String in = r.readLine();
            int cnt = 0;
            char pre = '0';
            for (char c : in.toCharArray()) {
                if (c != pre) {
                    pre = c;
                    cnt++;
                }
            }
            w.write("#" + (i + 1) + " " + cnt + "\n");
        }

        w.flush();
    }
}
