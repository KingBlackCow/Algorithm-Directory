package week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BOJ1946_신입사원 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(reader.readLine());

        while(tc-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int [] a= new int[n+1];

            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                a[x] = y;
            }

            int cnt = 1; //x가 1일때는 무조건 가능하므로 1로 시작
            int standard = a[1]; //기준 값, 처음에는 x가 1일 때의 y값
            for(int i=2; i<=n; i++) {
                if(standard > a[i]) { //기준 값보다 a[i]의 y값이 작다면
                    cnt++; //추가
                    standard = a[i]; //기준 값 a[i]의 y값으로 변경
                }
            }
            System.out.println(cnt);
        }
    }



    private static void solution(int n) throws Exception{
        int[] ary = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            ary[x] = y;
        }
        int cnt = 1;
        loop:
        for (int j = 2; j <= n; j++) {
            int score = ary[j];
            if (score == 1) {
                cnt++;
                continue;
            }
            for (int i = j - 1; i > 0; i--) {
                if (ary[i] < score) {
                    continue loop;
                }
            }
            cnt++;
        }
        System.out.println(cnt);

    }
}