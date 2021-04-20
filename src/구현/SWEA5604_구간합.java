package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA5604_구간합 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;
    static long first, second;
    static HashMap<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            first = Long.parseLong(st.nextToken());
            second = Long.parseLong(st.nextToken());

            long resFirst = function(first - 1);
            long resSecond = function(second);

            sb.append("#" + tc + " " + (resSecond - resFirst) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static long function(long x) {
        if (map.containsKey(x)) return map.get(x);
        if (x <= 9) return (x * (x + 1)) / 2;
        long v = 1;
        while (true) {
            if (v * 10 > x) break;
            v *= 10;
        }
        long tmp = function(x - 1 - x % v) + gunction(x);

        map.put(x, tmp);
        return tmp;
    }

    public static long gunction(long x) {
        long v = 1;
        while (true) {
            if (v * 10 > x) break;
            v *= 10;
        }
        long tmp = x / v * (x % v + 1) + function(x % v);

        return tmp;
    }
}