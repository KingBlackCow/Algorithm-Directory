package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ13022_늑대와올바른언어 {
    static int n, m, k;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] str = br.readLine().toCharArray();
        int cnt = 0;
        boolean realFlag= true;
        while (cnt < str.length){
            int[] num = new int[4];
            while (cnt<str.length&&str[cnt]=='w'){
                num[0]++;
                cnt++;
            }
            while (cnt<str.length&&str[cnt]=='o'){
                num[1]++;
                cnt++;
            }
            while (cnt<str.length&&str[cnt]=='l'){
                num[2]++;
                cnt++;
            }
            while (cnt<str.length&&str[cnt]=='f'){
                num[3]++;
                cnt++;
            }
            int pivot =num[0];
            boolean flag =true;
            for (int i = 1; i <= 3; i++) {
                if(pivot!=num[i]){
                    flag=false;
                }
            }
            if(!flag){
                realFlag=false;
                break;
            }
        }

        max =realFlag? 1:0;
        System.out.println(max);
    }


}

