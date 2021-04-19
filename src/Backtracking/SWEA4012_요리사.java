package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class SWEA4012_요리사 {
    static int n;
    static int[][] ary;
    static boolean[] visit;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static List<Integer> listVisit;
    static List<Integer> listNotVisit;
    static Queue<Node> q;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            ary = new int[n][n];
            visit = new boolean[n];
            min=Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                String str[] = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    ary[i][j] = Integer.parseInt(str[j]);
                }
            }
            dfs(0,0);


            sb.append("#" + tc + " " + min + "\n\n");
        }
        System.out.println(sb.toString());
        br.close();
        System.exit(0);
    }

    private static void dfs(int x,int cnt) {
        if(x==n/2){
            listVisit=new ArrayList<>();
            listNotVisit=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(visit[i]){
                    listVisit.add(i);
                }else{
                    listNotVisit.add(i);
                }
            }
            int sum1=0;
            int sum2=0;

            for (Integer i:listVisit) {
                for (Integer j:listVisit) {
                    if(i==j)continue;
                    sum1+=ary[i][j];
                }
            }
            for (Integer i:listNotVisit) {
                for (Integer j:listNotVisit) {
                    if(i==j)continue;
                    sum2+=ary[i][j];
                }
            }
            min=Math.min(min,Math.abs(sum1-sum2));
        }
        for (int i = cnt; i < n; i++) {
            if(!visit[i]){
                visit[i]=true;
                dfs(x+1,i+1);
                visit[i]=false;
            }
        }
    }

    static class Node {
        int x;
        int y;


        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
