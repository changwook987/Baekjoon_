package javaFile.problem15688;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(r.readLine());
        int[] arr = new int[2_000_001];

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(r.readLine());
            arr[n + 1_000_000]++;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                w.append(String.valueOf(i - 1_000_000)).append("\n");
            }
        }

        w.flush();
    }
}
