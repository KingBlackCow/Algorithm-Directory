package Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ20551_Sort마스터배지훈의후계자 {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < n; i++) {
            int tmp = pq.poll();
            if (map.get(tmp) == null) {
                map.put(tmp, i);
            }
        }
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(br.readLine());
            if (map.get(key) != null) {
                sb.append(map.get(key) + "\n");
            } else {
                sb.append(-1 + "\n");
            }

        }
        System.out.println(sb.toString());
    }
}
