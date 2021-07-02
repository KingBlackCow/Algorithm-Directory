package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1969_DNA {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        Map<Character, Integer> map = new HashMap<>();

        String res = "";
        int sum = 0;
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                char tmp=str[j].charAt(i);
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
            List<Character> keySetList = new ArrayList<>(map.keySet());
            Collections.sort(keySetList, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    if (map.get(o2).equals(map.get(o1))) {
                        return o1.compareTo(o2);
                    }
                    return map.get(o2).compareTo(map.get(o1));
                }
            });
            res += keySetList.get(0);
            for (int t = 1; t<keySetList.size();t++) {
                sum+=map.get(keySetList.get(t));
            }
            map.clear();
        }
        System.out.println(res);
        System.out.println(sum);


    }
}


