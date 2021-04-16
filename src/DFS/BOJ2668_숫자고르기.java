package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2668_숫자고르기 {
    static int n;
    static int[] ary;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ary = new int[n+1];
        for(int i=1; i<=n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        for(int i=1; i<=n; i++) {
            visited = new boolean[n+1];
            dfs(i, i);
        }
        System.out.println(set.size());
        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        for(Integer i:list) {
            System.out.println(i);
        }
    }

    static void dfs( int start, int end) {
        if(visited[start])return;
        visited[start]=true;
        if(ary[start] == end) {
            set.add(end);
        }
        dfs(ary[start], end );
    }
}