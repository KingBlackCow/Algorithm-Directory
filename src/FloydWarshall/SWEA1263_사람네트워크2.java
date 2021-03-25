package FloydWarshall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA1263_사람네트워크2 {

    static final int INF = 99999;
    static int n, ary[][];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            ary = new int[n][n];
            for(int i = 0; i< n; ++i) {
                for(int j = 0; j< n; ++j) {
                    ary[i][j] = sc.nextInt();
                    if(i != j && ary[i][j]==0) {
                        ary[i][j]=INF;
                    }
                }
            }

            for(int k = 0; k< n; ++k) {
                for(int i = 0; i< n; ++i) {
                    if(i==k) continue;
                    for(int j = 0; j< n; ++j) {
                        if(i==j || k==j) continue;
                        if(ary[i][j] > ary[i][k]+ ary[k][j]) {
                            ary[i][j] = ary[i][k]+ ary[k][j];
                        }
                    }
                }

            }
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int sum=0;
                for (int j = 0; j < n; j++) {
                    if(i==j)continue;
                    sum+=ary[i][j];
                }
                list.add(sum);
            }
            Collections.sort(list);
            System.out.println("#"+tc+" "+list.get(0));
        }
    }

}
