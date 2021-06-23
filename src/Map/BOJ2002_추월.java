package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class BOJ2002_추월 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            map.put(str, i);
        }
        int pivot = 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            int cnt = map.get(str);
            if (cnt == pivot) {
                pivot++;
                while (set.contains(pivot)) {
                    pivot++;
                }
            } else {
                res++;
                set.add(cnt);
            }
        }
        System.out.println(res);

    }


}