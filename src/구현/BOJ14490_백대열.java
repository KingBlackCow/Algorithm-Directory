package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14490_백대열 {
    static int n, m;
    static List<Integer> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int limit = n > m ? m : n;
        for (; ; ) {
            if (n % limit == 0 && m % limit == 0) {
                n /= limit;
                m /= limit;
            } else {
                limit--;
            }

            if (limit == 1) {
                System.out.println(n + ":" + m);
                break;
            }
        }
    }
}
