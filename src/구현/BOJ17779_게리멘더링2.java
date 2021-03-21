package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ17779_게리멘더링2 {
    static int n;
    static int[][] ary;
    static int visit[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        ary = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                ary[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int res=Integer.MAX_VALUE;
        for (int d1 = 1; d1 <= n; d1++) {
            for (int d2 = 1; d2 <= n; d2++) {
                for (int x = 1; x <= n-d1-d2; x++) {
                    for (int y = d1+1; y <= n-d2 ; y++) {
                        int[] ary=calc(x,y,d1,d2);
                        if(ary[0]==0||ary[1]==0)continue;
                        res=Math.min(res,ary[0]-ary[1]);
                    }
                }
            }
        }
        System.out.println(res);
    }

    private static int[] calc(int x, int y, int d1, int d2) {
        visit=new int[n+1][n+1];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int sum=0;

        //1
        for (int i = 1; i < x+d1; i++) {
            for (int j = 1; j <= y; j++) {
                if(visit[i][j]==0)
                    visit[i][j]=1;

            }
        }

        //2
        for (int i = 1; i <= x+d2; i++) {
            for (int j = y+1; j<= n; j++) {
                if(visit[i][j]==0)
                    visit[i][j]=2;
            }
        }

        //3
        for (int i = x+d1; i <= n; i++) {
            for (int j = 1; j< y-d1+d2; j++) {
                if(visit[i][j]==0)
                    visit[i][j]=3;
            }
        }

        //4
        for (int i = x+d2+1; i <= n; i++) {
            for (int j = y-d1+d2; j<= n; j++) {
                if(visit[i][j]==0)
                    visit[i][j]=4;
            }
        }


        visit[x][y]=5;
        sum+=ary[x][y];
        int r=x;
        int c=y;
        int turn=0;
        while (turn++<=d1){
            if(visit[r][c]!=5) {
                visit[r][c] = 5;
                sum += ary[r][c];
            }
            r++;
            c--;
        }
        r=x;
        c=y;
        turn=0;
        while (turn++<=d2){
            if(visit[r][c]!=5) {
                visit[r][c] = 5;
                sum += ary[r][c];
            }
            r++;
            c++;
        }
        r=x+d1;
        c=y-d1;
        turn=0;
        while (turn++<=d2){
            if(visit[r][c]!=5) {
                visit[r][c] = 5;
                sum += ary[r][c];
            }
            r++;
            c++;
        }
        r=x+d2;
        c=y+d2;
        turn=0;
        while (turn++<=d1){
            if(visit[r][c]!=5) {
                visit[r][c] = 5;
                sum += ary[r][c];
            }
            r++;
            c--;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(visit[i][j]==5){
                    int k=i;
                    boolean tmp=false;
                    while (true){
                        k++;
                        if(k>n)break;
                        if(visit[k][j]==5){
                            tmp=true;
                            break;
                        }
                    }

                    if(tmp) {
                        k = i;
                        while (true) {
                            k++;
                            if (k > n) break;
                            if (visit[k][j] != 5) {
                                visit[k][j] = 5;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        int one=0,two=0,three=0,four=0,five=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(visit[i][j]==1){
                    one+=ary[i][j];
                }else if(visit[i][j]==2){
                    two+=ary[i][j];
                }else if(visit[i][j]==3){
                    three+=ary[i][j];
                }else if(visit[i][j]==4){
                    four+=ary[i][j];
                }else if(visit[i][j]==5){
                    five+=ary[i][j];
                }
            }
        }
        max=Math.max(one,max);
        min=Math.min(one,min);
        max=Math.max(two,max);
        min=Math.min(two,min);
        max=Math.max(three,max);
        min=Math.min(three,min);
        max=Math.max(four,max);
        min=Math.min(four,min);
        max=Math.max(five,max);
        min=Math.min(five,min);
        return new int[]{max,min};
    }
}


