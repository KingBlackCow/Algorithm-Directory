package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719_빗물 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] ary = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 1; i < ary.length - 1; i++) {
            int cnt = i;
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = 0; j < cnt; j++) {
                maxLeft = Math.max(maxLeft, ary[j]);
            }
            for (int j = ary.length - 1; j > cnt; j--) {
                maxRight = Math.max(maxRight, ary[j]);
            }
            int tmp = Math.min(maxLeft, maxRight) - ary[i];
            if(tmp<0)continue;
            sum += tmp;

        }
        System.out.println(sum);
    }
}


