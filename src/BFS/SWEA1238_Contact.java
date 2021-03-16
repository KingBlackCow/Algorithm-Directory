package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class SWEA1238_Contact {
    static int max;
    static int n;
    static int start;
    static boolean visit[];
    static List<Integer> list[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while (tc<=10) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            list = new ArrayList[n + 1];
            visit = new boolean[101];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n / 2; i++) {
                int f = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                list[f].add(s);
            }

            sb.append("#" + tc++ + " " +   bfs() + "\n");
        }
        System.out.println(sb.toString());
        br.close();
        System.exit(0);
    }

    private static int bfs() {
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visit[start]=true;
        int maxTmp=Integer.MIN_VALUE;
        boolean flag=false;
        while (!q.isEmpty()) {
            int qSize = q.size();
            flag=false;
            max=Integer.MIN_VALUE;
            for (int j = 0; j < qSize; j++) {
                int tmp = q.poll();
                for (Integer i:list[tmp]) {
                    if(!visit[i]){
                        visit[i]=true;
                        q.add(i);
                        max=Math.max(i,max);
                        flag=true;
                    }
                }
            }
            if(flag){
                maxTmp=max;
            }
        }
        return maxTmp;
    }
}
