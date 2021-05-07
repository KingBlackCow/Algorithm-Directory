package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6581_HTML {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = "";
        boolean flag = false;
        boolean second = true;
        boolean first = true;
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            flag = true;
            first = true;
            if (!second && !st.hasMoreTokens()) {
                break;
            }
            while (st.hasMoreTokens()) {
                flag = false;
                str = st.nextToken();
                if (str.equals("<br>")) {
                    sb.append("\n");
                    cnt = 1;
                } else if (str.equals("<hr>")) {
                    if (!first) {
                        sb.append("\n");
                        cnt = 1;
                    }
                    for (int i = 0; i < 80; i++) {
                        sb.append("-");
                        cnt++;
                    }
                    sb.append("\n");
                    cnt = 1;
                    first = true;
                } else {
                    if (cnt + str.length() >= 79) {
                        sb.append("\n");
                        cnt = 1;
                    }
                    for (int i = 0; i < str.length(); i++) {

                        if (cnt >= 79) {
                            cnt = 1;
                            sb.append("\n");
                        }
                        sb.append(str.charAt(i));
                        cnt++;

                    }
                    sb.append(" ");
                    cnt++;
                    first = false;
                }

            }
            if (str.charAt(str.length() - 1) == '.') {
                second = false;
            } else {
                second = true;
            }
            if (!flag) {
                cnt--;
            }

            if (cnt >= 79) {
                cnt = 1;
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}



