package Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ12757_전설의JBNU {
    static int n, m, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> map = new TreeMap();
        map.put(-2000000000, -2000000000);
        map.put(2000000000, 2000000000);
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.put(key, value);
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int key = Integer.parseInt(st.nextToken());
            int value = 0;
            if (order < 3) {
                value = Integer.parseInt(st.nextToken());
            }
            if (order == 1) {
                map.put(key, value);
            } else if (order == 2) {
                int left = map.floorKey(key);
                int right = map.ceilingKey(key);
                if (left == right) {
                    map.put(left, value);
                } else if (key - left < right - key && k >= Math.abs(key - left)) {
                    map.put(left, value);
                } else if (key - left > right - key && k >= Math.abs(key - right)) {
                    map.put(right, value);
                }
            } else if (order == 3) {
                int left = map.floorKey(key);
                int right = map.ceilingKey(key);
                if (left == right) {
                    sb.append(map.get(left) + "\n");
                } else if (key - left < right - key && k >= Math.abs(left - key)) {
                    sb.append(map.get(left) + "\n");
                } else if (key - left > right - key && k >= Math.abs(key - right)) {
                    sb.append(map.get(right) + "\n");
                } else if (key - left == right - key && k >= right - key) {
                    sb.append("?\n");
                } else {
                    sb.append(-1 + "\n");
                }
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}