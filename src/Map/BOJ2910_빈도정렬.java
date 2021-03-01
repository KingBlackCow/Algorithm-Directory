package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2910_빈도정렬 {

    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashMap<Integer,Integer>map=new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int tmp=Integer.parseInt(st.nextToken());
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(map.get(o2),map.get(o1));
            }
        });

        for(Integer key : keySetList) {
            for (int i = 0; i < map.get(key); i++) {
                System.out.print(key+" ");
            }
        }

    }
}


