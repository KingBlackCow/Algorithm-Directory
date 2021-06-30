package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10991_별찍기16 {
    static int n, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int empty = n - 1;
        for (int turn = 1; turn <= n; turn++) {

            for (int i = 0; i < empty; i++) {
                System.out.print(" ");
            }
            empty--;
            boolean press = true;
            int cnt = 0;
            while (cnt<turn) {
                if (press) {
                    System.out.print("*");
                    cnt++;
                } else {
                    System.out.print(" ");
                }
                press = !press;
            }
            System.out.println();
        }
    }
}