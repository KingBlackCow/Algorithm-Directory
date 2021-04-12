package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA4014_활주로건설 {

    static int[][] ary;
    static int n, x;
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            res = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            ary = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    ary[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[j] = ary[i][j];
                }
                calc(arr);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[j] = ary[j][i];
                }
                calc(arr);
            }
            System.out.println("#" + tc + " " + res);
        }
    }

    private static void calc(int[] arr) {
        boolean flag = true;
        Set<Integer> set=new HashSet<>();
        out:
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) > 1) {
                flag = false;
                break out;
            }
            if (arr[i] > arr[i + 1]) {
                int pivot = arr[i + 1];
                for (int j = 1; j <= x; j++) {
                    if (i + j >= n) {
                        flag = false;
                        break out;
                    }
                    if (pivot != arr[i + j]) {
                        flag = false;
                        break out;
                    }
                    if(set.contains(i+j)){
                        flag = false;
                        break out;
                    }
                    set.add(i+j);
                }

            } else if (arr[i] < arr[i + 1]) {
                int pivot = arr[i];
                for (int j = 0; j < x; j++) {
                    if (i - j < 0) {
                        flag = false;
                        break out;
                    }

                    if (pivot != arr[i - j]) {
                        flag = false;
                        break out;
                    }
                    if(set.contains(i-j)){
                        flag = false;
                        break out;
                    }
                    set.add(i-j);
                }
            }
        }
        if (flag) {
            res++;
        }
    }


}


