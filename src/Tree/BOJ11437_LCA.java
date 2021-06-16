package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ11437_LCA {
    public static LinkedList<Integer>[] list;
    public static int[] parents;
    public static int[] depths;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        list = new LinkedList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new LinkedList<Integer>();
        }
        StringTokenizer st;
        for(int i = 0; i < N-1; i++) {
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        parents = new int[N+1];
        depths = new int[N+1];

        dfs(1, 0, -1);

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int depthA = depths[a];
            int depthB = depths[b];

            while(depthA > depthB) {
                a = parents[a];
                depthA--;
            }

            while(depthB > depthA) {
                b = parents[b];
                depthB--;
            }

            while(a != b) {
                a = parents[a];
                b = parents[b];
            }

            sb.append(a+"\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int cnt, int depth, int parent) {
        depths[cnt] = depth;
        parents[cnt] = parent;

        for(int next : list[cnt]) {
            if(next != parent) {
                dfs(next, depth+1, cnt);
            }
        }
    }

}