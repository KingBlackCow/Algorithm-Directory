package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1614_영식이의손가락 {
    static long n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(br.readLine());
        int pivot = 2;
        if (n == 1 || n == 5) {
            pivot = 1;
        }
        long mok = m / pivot;
        long namuge = m % pivot;
        long res = mok * 8;

        boolean flag = namuge == 1 ? true : false;
        int cnt = 0;
        int[] ary = {1, 2, 3, 4, 5, 4, 3, 2};
        for (int i = 0; i < ary.length; i++) {
            if (Long.compare(ary[i], n) == 0) {
                if (flag) {
                    flag = false;
                } else {
                    break;
                }
            }
            cnt++;
        }
        res += cnt;
        System.out.println(res);

    }
}


