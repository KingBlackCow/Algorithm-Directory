package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1205_등수구하기 {
    static int n;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int score = sc.nextInt();
        int p =sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        list.add(score);
        Collections.sort(list, Collections.reverseOrder());

        int pivot = list.lastIndexOf(score) + 1;
        if (pivot > p) {
            System.out.println(-1);
            System.exit(0);
        }
        if (list.indexOf(score) == list.lastIndexOf(score)) {
            System.out.println(pivot);
        } else {
            System.out.println(list.indexOf(score)+1);
        }
    }
}