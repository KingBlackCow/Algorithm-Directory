package 구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ17266_어두운굴다리 {
    static int T, N, M;
    static long ans;
    static int[] A, B;

    static List<Integer> a, b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        int max = 0;

        max = Math.max(max, list.get(0) - 0);
        max = Math.max(max, N - list.get(list.size() - 1));

        for (int i = 1; i < list.size(); i++) {
            int tmp= (int) ((list.get(i)+1 - list.get(i - 1)) / 2);
            max = (int) Math.max(max, tmp);
        }
        System.out.println(max);
    }
}