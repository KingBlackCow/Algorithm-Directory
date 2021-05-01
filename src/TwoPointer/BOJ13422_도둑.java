package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13422_도둑 {
    static int T;
    static int n, m, k;
    static List<Integer> res = new ArrayList<>();
    static int[] ary;
    static int[] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            ary = new int[n];
            sum = new int[n];
            int start = 0;
            int end = start + m - 1;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                ary[i] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += ary[i];
            }

            if (sum < k) res.add(sum);
            if (n != m) {
                for (int pivot = 1; pivot < n; pivot++) {
                    sum -= ary[start];
                    start++;
                    end++;
                    if (end >= n) end = 0;
                    sum += ary[end];
                    if (sum < k) res.add(sum);
                }
            }
            sb.append(res.size() + "\n");
            res.clear();
        }
        System.out.println(sb.toString());
    }
}