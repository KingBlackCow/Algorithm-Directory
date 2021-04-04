package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1967_트리의지름 {
    static int n;
    static boolean visit[];
    static int max=Integer.MIN_VALUE;
    static List<Node> list[];
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        list=new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i]=new ArrayList<>();
        }
        for (int i = 1; i <= n-1; i++) {
            st=new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());
            int second=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            list[first].add(new Node(second,weight));
            list[second].add(new Node(first,weight));
        }

        for (int i = 1; i <= n; i++) {
            visit=new boolean[n+1];
            sum=0;
            visit[i]=true;
            dfs(i ,0);
            max=Math.max(sum,max);
        }
        System.out.println(max);

    }

    private static void dfs(int x,int cnt) {

        sum=Math.max(cnt,sum);
        for (Node node:list[x]) {
            if(!visit[node.to]){
                visit[node.to]=true;
                dfs(node.to,cnt+node.weight);
                visit[node.to]=false;
            }
        }
    }

    static class Node{

        int to;
        int weight;

        public Node( int to, int weight) {

            this.to = to;
            this.weight = weight;
        }
    }
}

