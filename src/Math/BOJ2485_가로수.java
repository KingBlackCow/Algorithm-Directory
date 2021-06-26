package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BOJ2485_가로수 {
    static int n;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < n; i++) {
            set.add(ary[i] - ary[i - 1]);
        }
        list = new ArrayList<>(set);
        min=list.get(0);
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, GCD(min, list.get(i)));
        }
        int cnt = ary[n-1]-ary[0];
        int count = cnt/min-n+1;

        System.out.println(count);

    }

    static int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }
}

