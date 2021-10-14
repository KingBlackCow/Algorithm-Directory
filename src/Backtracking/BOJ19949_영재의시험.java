package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19949_영재의시험 {
    static int[] ary;
    static int[] map;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[10];
        for (int i = 0; i < 10; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        ary = new int[10];

        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int x, int turn) {
        if (x == 10) {
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                if(ary[i]==map[i]){
                    cnt++;
                }
            }
            if(cnt>=5){
                ans++;
            }

            return;
        }
        for (int i = 1; i <= 5; i++) {
            if (turn >= 2) {
                if (ary[turn - 1] == ary[turn - 2] && ary[turn - 1] == i) {
                    continue;
                }
            }
            ary[turn] = i;
            dfs(x + 1, turn + 1);
        }
    }


}


