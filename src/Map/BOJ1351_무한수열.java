package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ1351_무한수열 {
    static long n, p, q;
    static Map<Long, Long> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        map.put(0L, 1L);
        System.out.println(find(n));
    }
    static long find(long cnt){
        if(cnt==0L)return 1L;
        if(map.containsKey(cnt)){
            return map.get(cnt);
        }
        map.put(cnt,find(cnt/p)+find(cnt/q));
        return map.get(cnt);
    }
}