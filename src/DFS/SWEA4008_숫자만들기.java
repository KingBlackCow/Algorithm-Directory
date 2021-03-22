package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4008_숫자만들기 {

    static int n, m;
    static int op[];
    static int[] num;
    static int max,min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {

            n=Integer.parseInt(br.readLine());
            op=new int[4];
            st=new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                op[i]=Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(br.readLine());
            num=new int[n];
            for (int i = 0; i < n; i++) {
                num[i]=Integer.parseInt(st.nextToken());
            }
            max=Integer.MIN_VALUE;
            min=Integer.MAX_VALUE;
            dfs(num[0],1);
            sb.append("#"+tc+" "+(max-min)+"\n");
        }
        System.out.println(sb.toString());

    }

    private static void dfs(int x ,int i) {
        if(i==n){
            max=Math.max(max,x);
            min=Math.min(min,x);
            return;
        }

        if(op[0]>0){
            op[0]--;
            dfs(x+num[i], i+1);
            op[0]++;
        }
        if(op[1]>0){
            op[1]--;
            dfs(x-num[i], i+1);
            op[1]++;
        }
        if(op[2]>0){
            op[2]--;
            dfs(x*num[i], i+1);
            op[2]++;
        }
        if(op[3]>0){
            op[3]--;
            dfs(x/num[i], i+1);
            op[3]++;
        }
    }
}
