package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ16922_로마숫자만들기 {

    static int n;
    static int[] ary = {1, 5, 10, 50};
    static int[] arr;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[21];
        perm(0,0);
        System.out.println(set.size());
    }

    private static void perm(int x,int cnt) {
        if (x == n) {
            int sum =0;
            for (int i = 0; i < n; i++) {
                sum+=arr[i];
            }
            set.add(sum);
            return;
        }
        for (int i = cnt; i < 4; i++) {
            arr[x] = ary[i];
            perm(x + 1,i);
        }

    }
}