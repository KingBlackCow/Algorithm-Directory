package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BOJ1339_단어수학 {
    static int n;
    static  List<Character> list;
    static Map<Character,Integer> map;
    static boolean[] visit;
    static String[] str;
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        str=new String[n];
        for (int i = 0; i < n; i++) {
            str[i]=br.readLine();
        }
        list=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                if(!list.contains(str[i].charAt(j)))
                    list.add(str[i].charAt(j));
            }
        }
        map=new HashMap<>();
        visit=new boolean[list.size()];
        max=Integer.MIN_VALUE;
        dfs(0,9);
        System.out.println(max);
    }

    private static void dfs(int x, int cnt) {
        if(x==list.size()){
            int[] strRes=new int[n];
            for (int i = 0; i < n; i++) {
                int strTmp=0;
                for (int j = 0; j < str[i].length(); j++) {
                    strTmp*=10;
                    strTmp+=map.get(str[i].charAt(j));
                }
                strRes[i]=strTmp;
            }
            int sum=0;
            for (int i = 0; i < n; i++) {
                sum+=strRes[i];
            }
            max=Math.max(sum,max);

            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(!visit[i]) {
                map.put(list.get(i), cnt);
                visit[i]=true;
                dfs(x + 1, cnt - 1);
                visit[i]=false;
            }
        }
    }
}