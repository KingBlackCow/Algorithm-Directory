package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12101_123더하기2 {
    static int n, m;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String str = "";
        dfs(0, str);
        System.out.println(-1);
    }

    private static void dfs(int x, String cnt) {
        if (x >= n) {
            if (x == n) {
                count++;
                if (count == m) {
                    String res = "";
                    for (int i = 0; i < cnt.length(); i++) {
                        res += cnt.charAt(i);
                        res += "+";
                    }
                    res = res.substring(0, res.length() - 1);
                    System.out.println(res);
                    System.exit(0);
                }

            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            dfs(x + i, cnt + i);
        }

    }
}