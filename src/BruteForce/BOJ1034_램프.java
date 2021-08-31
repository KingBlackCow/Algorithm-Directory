package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1034_램프 {
    static int n, m, k;
    static int[][] ary;
    static boolean[] visit;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                ary[i][j] = str[j] - '0';
            }
        }
        visit = new boolean[m];
        k = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < m; j++) {
                str+= ary[i][j];
            }
            map.put(str, map.getOrDefault(str,0)+1);
        }
        int oddEven = k%2;
        if(k>50){
            k=50;
        }
        int idx =-1;

        int cnt = 0;
        for (String str: map.keySet()) {
            int tmp = map.get(str);
            int zeroNum =  0;
            for (int i = 0; i < m; i++) {
                if(str.charAt(i)=='0'){
                    zeroNum++;
                }
            }
            if(zeroNum%2 != oddEven){
                continue;
            }
            if(zeroNum<=k && tmp>max){
                max =tmp;
                idx = cnt;
            }
            cnt++;
        }
        if(idx!=-1){
            System.out.println(max);
        }else{
            System.out.println(0);
        }
    }
}