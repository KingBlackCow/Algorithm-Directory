package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2660_회장뽑기 {
    static int n;
    static List<Integer> maxNumList = new ArrayList<>();
    static List<Integer> list[];
    static boolean[] visit;
    static int maxTmp = 0;
    static int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (f == -1 && s == -1) break;
            list[f].add(s);
            list[s].add(f);
        }
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            maxTmp = bfs(i);
            if(max>maxTmp){
                max= maxTmp;
                maxNumList.clear();
                maxNumList.add(i);
            }else if(max==maxTmp){
                maxNumList.add(i);
            }
        }
        System.out.println(max+" "+maxNumList.size());
        for (Integer i : maxNumList) {
            System.out.print(i+" ");
        }

    }

    static int bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        boolean[] visit = new boolean[n+1];
        int turn = 0;
        visit[x] =true;
        while (!q.isEmpty()){
            int qSize = q.size();
            for (int qlen = 0; qlen < qSize; qlen++) {
                Integer cnt = q.poll();
                for (Integer i : list[cnt]) {
                    if (visit[i]) continue;
                    visit[i] = true;
                    q.add(i);
                }
            }
            turn++;
        }
        return turn-1;
    }
}

