package Math;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1059_좋은수열 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));

        int l = sc.nextInt();
        int breakPoint = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == l) {
                System.out.println(0);
                breakPoint = -1;
                break;
            }
        }

        if (breakPoint != -1) {
            breakPoint = 0;
            if (arr[0] >= l) {
                breakPoint = (l-0)*(arr[0] - l)-1;
            } else {

                for (int i = 1; i < n; i++) {
                    if (arr[i] >= l) {
                        breakPoint = (l - arr[i - 1]) * (arr[i] - l) - 1;
                        break;
                    }
                }
            }
            System.out.println(breakPoint);
        }

    }

    private static String src = "4\r\n" + "4 7 14 10\r\n" + "1";
}