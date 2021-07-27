package Set;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BOJ16499_동일한단어그룹화하기 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        Set<Map<Character,Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String str=br.readLine();
            Map<Character,Integer> map =new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                map.put(str.charAt(j),map.getOrDefault(str.charAt(j),0)+1);
            }
            set.add(map);
        }
        System.out.println(set.size());
    }
}