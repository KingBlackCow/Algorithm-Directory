package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ181111_마인크래프트 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int answerTime = 2147000000;
        int answerheight = -1;
        int map[][] = new int[n][m];
        int max=-1, min=answerTime ;
        for(int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++) {
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                if(now > max) max = now;
                if(now < min) min = now;
            }
        }

        for(int i = max ; i >= min ; i--) {
            int time = 0;
            int bag = b;
            int target = i;
            boolean isCompute = true;

            for(int y = 0 ; y < n ; y ++) {
                for(int  x= 0 ; x < m ; x++) {
                    if(map[y][x] == target) continue;
                    else {
                        int diff = Math.abs(target - map[y][x]);
                        if(target > map[y][x]) {
                            bag -= diff;
                            time +=diff;
                        } else {
                            bag += diff;
                            time += (2*diff);
                        }

                    }
                }
            }
            if(bag< 0) {
                continue;
            }
            if(isCompute &&time < answerTime) {
                answerTime = time;
                answerheight = target;
            }
        }
        System.out.println(answerTime + " " + answerheight );
    }
}