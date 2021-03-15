package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA1952_수영장 {
    static int[] ary;
    static int sum;

    static int day, month, threeMonth, year;
    static int min;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            threeMonth = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
            ary = new int[13];
            min = Integer.MAX_VALUE;

            sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                ary[i] = Integer.parseInt(st.nextToken());
            }
            dfs(1);
            min = Math.min(year, min);
            sb.append("#" + tc + " " + min + "\n");
        }
        System.out.println(sb.toString());
        br.close();
        System.exit(0);
    }

    private static void dfs(int x) {
        if (x > 12) {
            min = Math.min(min, sum);
            return;
        }

        if (ary[x] != 0) {
            int tmp = Math.min(day * ary[x], month);
            sum += tmp;
            dfs(x + 1);
            sum -= tmp;

            sum += threeMonth;
            dfs(x + 3);
            sum -= threeMonth;

        } else {
            dfs(x + 1);
        }

    }


}
