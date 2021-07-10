package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19941_햄버거분배 {

    static int n, m;
    static int[] visit;
    static String str;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        str = br.readLine();
        visit = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'H') {
                visit[i] = 1;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'P') {
                int pivot = i - m;
                while (pivot <= i + m) {
                    if (pivot >= 0 && pivot < str.length()) {
                        if (visit[pivot] == 1) {
                            visit[pivot]++;
                            sum++;
                            break;
                        }
                    }
                    pivot++;
                }
            }
        }
        sb.append(sum + "\n");
        System.out.print(sb.toString());
    }
}