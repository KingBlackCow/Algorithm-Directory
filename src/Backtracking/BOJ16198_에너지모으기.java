package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class BOJ16198_에너지모으기 {
    static int n;

    static int max=Integer.MIN_VALUE;
    static int[] ary;
    static List<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ary=new int[n];
        list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        dfs(n, 0);
        System.out.println(max);
    }

    private static void dfs(int x,int cnt) {
        if(list.size()==2){
            max=Math.max(cnt,max);
        }
        for (int i = 1; i <= list.size()-2; i++) {
            int tmp=list.remove(i);
            dfs(x+1,cnt+list.get(i-1)*list.get(i));
            list.add(i,tmp);
        }

    }
}

