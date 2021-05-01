package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12813_이진수연산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str = br.readLine();
        String str2 = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str2.charAt(i)) {
                if (str.charAt(i) == '1') {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            } else {
                sb.append(0);
            }
        }
        sb.append("\n");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1' || str2.charAt(i) == '1') {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        sb.append("\n");

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str2.charAt(i) ) {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        sb.append("\n");

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='1') {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        sb.append("\n");

        for (int i = 0; i < str.length(); i++) {
            if (str2.charAt(i)=='1') {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        System.out.println(sb.toString());
    }
}