package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1063_킹 {
    static int n;
    static Map<String, Integer> map;
    static Map<Integer, String> map2;
    static Map<String, Integer> map3;
    static int[] dr = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] king = new int[2];
    static int[] stone = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        map = new HashMap<>();
        map2 = new HashMap<>();
        map3 = new HashMap<>();
        map.put("R", 0);
        map.put("L", 1);
        map.put("B", 2);
        map.put("T", 3);
        map.put("RT", 4);
        map.put("LT", 5);
        map.put("RB", 6);
        map.put("LB", 7);
        map2.put(1, "A");
        map2.put(2, "B");
        map2.put(3, "C");
        map2.put(4, "D");
        map2.put(5, "E");
        map2.put(6, "F");
        map2.put(7, "G");
        map2.put(8, "H");
        map3.put("A", 1);
        map3.put("B", 2);
        map3.put("C", 3);
        map3.put("D", 4);
        map3.put("E", 5);
        map3.put("F", 6);
        map3.put("G", 7);
        map3.put("H", 8);
        StringTokenizer st = new StringTokenizer(br.readLine());
        String kingLoc = st.nextToken();
        String stoneLoc = st.nextToken();
        int[][] ary = new int[9][9];
        king[0] = 9 - (kingLoc.charAt(1) - '0');
        king[1] = map3.get(kingLoc.substring(0, 1));
        stone[0] = 9 - (stoneLoc.charAt(1) - '0');
        stone[1] = map3.get(stoneLoc.substring(0, 1));
        int order = Integer.parseInt(st.nextToken());
        for (int i = 0; i < order; i++) {
            String pivot = br.readLine();
            int nk1 = king[0] + dr[map.get(pivot)];
            int nk2 = king[1] + dc[map.get(pivot)];
            int sk1 = stone[0] + dr[map.get(pivot)];
            int sk2 = stone[1] + dc[map.get(pivot)];
            if(nk1>=1&&nk2>=1&&nk1<=8&&nk2<=8){
                if(nk1==stone[0]&&nk2==stone[1]) {
                    if(sk1>=1&&sk2>=1&&sk1<=8&&sk2<=8){
                        stone[0]=sk1;
                        stone[1]=sk2;
                        king[0] = nk1;
                        king[1] =nk2;
                    }
                }else{
                    king[0] = nk1;
                    king[1] =nk2;
                }
            }

        }
        System.out.println(map2.get(king[1]) + "" + (9-king[0]));
        System.out.println(map2.get(stone[1]) + "" + (9-stone[0]));
    }

}

