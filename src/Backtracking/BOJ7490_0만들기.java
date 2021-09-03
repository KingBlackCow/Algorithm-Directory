package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7490_0만들기 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            dfs("1", 1);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    private static void dfs(String x, int turn) {
        if (turn == n) {
            String x2 = x.replaceAll(" ", "");
            String num = "";
            int res = 0;
            Queue<Integer> numQ = new LinkedList<>();
            Queue<Character> operatorQ = new LinkedList<>();
            for (int i = 0; i < x2.length(); i++) {
                if (x2.charAt(i) == '+') {
                    numQ.add(Integer.parseInt(num));
                    num = "";
                    operatorQ.add('+');
                } else if (x2.charAt(i) == '-') {
                    numQ.add(Integer.parseInt(num));
                    num = "";
                    operatorQ.add('-');
                } else if (x2.charAt(i) != ' ') {
                    num += x2.charAt(i);
                }
            }
            numQ.add(Integer.parseInt(num));
            res += numQ.poll();
            while (!numQ.isEmpty()) {
                char op = operatorQ.poll();
                int cnt = numQ.poll();
                if (op == '+') {
                    res += cnt;
                } else {
                    res -= cnt;
                }
            }
            if (res == 0) {
                sb.append(x + "\n");
            }
            return;
        }
        dfs(x + " " + (turn + 1), turn + 1);
        dfs(x + "+" + (turn + 1), turn + 1);
        dfs(x + "-" + (turn + 1), turn + 1);
    }
}