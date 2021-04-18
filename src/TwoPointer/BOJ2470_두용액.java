package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ2470_두용액 {

    static int n;
    static int[] ary;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ary = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);
        int left = 0;
        int right = ary.length - 1;
        int leftMax = 0;
        int rightMax = ary.length - 1;
        int min = Integer.MAX_VALUE;
        int past = -1;
        while (left < right) {
            if (ary[left] * ary[right] != 0) {
                int tmp = ary[right] + ary[left];
                if (min > Math.abs(tmp)) {
                    min = Math.abs(tmp);
                    leftMax = left;
                    rightMax = right;
                }
                if (tmp > 0) {
                    right--;
                    past = 0;
                } else if (tmp < 0) {
                    left++;
                    past = 1;
                } else {
                    past = -1;
                    break;
                }

            } else {
                past = -1;
                break;
            }
        }
        if (past == 1) {
            left--;
        } else if (past == 0) {
            right++;
        }
        System.out.println(ary[leftMax] + " " + ary[rightMax]);
    }

}