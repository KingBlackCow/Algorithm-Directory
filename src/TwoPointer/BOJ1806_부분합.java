package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806_부분합 {
    static int n, s;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        int[] ary = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        int one = 0;
        int two = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (true) {
            if (two < ary.length) {
                if (sum < s) {
                    sum += ary[two];
                    two++;
                } else {
                    len = Math.min(len, two - one);
                    sum -= ary[one];
                    one++;
                }
            } else {
                if (sum >= s) {
                    len = Math.min(len, two - one);
                }
                sum -= ary[one];
                one++;
                if(one>=ary.length)break;
            }
        }
        if(len==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(len);

    }
}
