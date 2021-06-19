package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559_수열 {

    public static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] ary = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += ary[i];
        }
        int max = sum;
        for (int i = k; i < n; i++) {
            sum -= ary[i - k];
            sum += ary[i];
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}