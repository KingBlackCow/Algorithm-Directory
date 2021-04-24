package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1120_문자열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String a;
    static String b;
    static int min =Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = st.nextToken();
        b = st.nextToken();
        for (int j = 0; j <= b.length()-a.length(); j++) {
            int cnt= 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i+j)) {
                    cnt++;
                }
            }
            min=Math.min(cnt,min);
        }

        System.out.println(min);
    }


}
