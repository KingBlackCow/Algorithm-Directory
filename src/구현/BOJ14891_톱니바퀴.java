package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ14891_톱니바퀴 {
    //N= 0 S=1 1은 시계  -1은 반시계
    //2번 6번
    static String[] str = new String[5];
    static boolean[] dirCheck = new boolean[5];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 1; i <= 4; i++) {
            str[i] = br.readLine();
        }
        int orderNum = Integer.parseInt(br.readLine());
        int[][] dirs = {
                {0, -1, 1, -1, 1},
                {0, 1, -1, 1, -1},
        };

        for (int i = 0; i < orderNum; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            check(num);
            boolean select= true;
            if(num%2==0){
                if(dir==1){
                    select=true;
                }else{
                    select=false;
                }
            }else{
                if(dir==1){
                    select=false;
                }else{
                    select=true;
                }
            }
            for (int j = 1; j <= 4; j++) {
                if (dirCheck[j]) {
                    if(select){
                        rotate(j, dirs[0][j]);
                    }else{
                        rotate(j, dirs[1][j]);
                    }
                }
            }
        }
        System.out.println(calc());

        bw.flush();
        bw.close();
        br.close();
    }

    private static int calc() {
        int sum = 0;
        int bae = 1;
        for (int i = 1; i <= 4; i++) {
            if(str[i].charAt(0)=='1'){
                sum+= bae;
            }
            bae*=2;
        }
        return sum;
    }

    private static void rotate(int num, int dir) {
        if (dir == 1) {
            char tmp = str[num].charAt(str[num].length() - 1);
            str[num] = str[num].substring(0, str[num].length() - 1);
            str[num] = tmp + str[num];
        } else {
            char tmp = str[num].charAt(0);
            str[num] = str[num].substring(1);
            str[num] = str[num] + tmp;
        }
    }


    private static void check(int num) {
        Arrays.fill(dirCheck, false);
        int turn = 1;
        dirCheck[num] = true;
        int past = num;
        while (num - turn >= 1) {
            if (str[num - turn].charAt(2) != str[past].charAt(6)) {
                dirCheck[num - turn] = true;
            } else {
                break;
            }
            past = num - turn;
            turn++;
        }
        turn = 1;
        past=num;
        while (num + turn <= 4) {
            if (str[num + turn].charAt(6) != str[past].charAt(2)) {
                dirCheck[num + turn] = true;
            } else {
                break;
            }
            past = num + turn;
            turn++;
        }
    }


}
