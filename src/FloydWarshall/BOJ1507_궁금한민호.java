package FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1507_궁금한민호 {
    static int n, m;
    static int[][] map;
    static int[][] arr;
    static int INF= 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        arr= new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j =1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j]=map[i][j];
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j || i == k || k == j) {
                        continue;
                    }

                    if(map[i][j]>arr[i][k]+arr[k][j]){
                        System.out.println(-1);
                        return;
                    }
                    if(map[i][j]==arr[i][k]+arr[k][j]){
                        arr[i][j]=INF;
                    }
                }
            }
        }
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (arr[i][j] != INF && i != j) {
                    ans += arr[i][j];
                }
            }
        }
        System.out.println(ans);
    }

}