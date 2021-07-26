package Backtracking;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class BOJ10597_순열장난 {
    static String n;
    static boolean[] visit;
    static List<Integer> ary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        visit = new boolean[51];
        ary = new LinkedList<>();
        n = br.readLine();
        dfs(0, 0);


    }

    private static void dfs(int x, int cnt) {
        if (x >= n.length()) {
            int max = 0;
            for (Integer i : ary) {
                max = Math.max(max, i);
            }
            boolean flag = true;
            for (int i = 1; i <= max; i++) {
                if (!ary.contains(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (Integer i : ary) {
                    System.out.print(i + " ");
                }
                System.exit(0);
            }
            System.out.println();
            return;
        }
        int tmp = n.charAt(x) - '0';
        if (!visit[tmp]) {
            ary.add(tmp);
            visit[tmp] = true;
            dfs(x + 1, cnt + 1);
            visit[tmp] = false;
            ary.remove(ary.size()-1);
        }
        if (x + 1 < n.length()) {
            int tmp2 = tmp * 10 + (n.charAt(x + 1) - '0');
            if (tmp2 <= 50 && !visit[tmp2]) {
                ary.add(tmp2);
                visit[tmp2] = true;
                dfs(x + 2, cnt + 1);
                visit[tmp2] = false;
                ary.remove(ary.size()-1);
            }
        }
    }


}