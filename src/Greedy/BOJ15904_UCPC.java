package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ15904_UCPC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean one = true, two = false, thr = false, four = false;
        boolean res = false;
        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            for (int i = 0; i < tmp.length(); i++) {

                if (one && tmp.charAt(i) == 'U') {
                    one = false;
                    two = true;
                } else if (two && tmp.charAt(i) == 'C') {
                    two = false;
                    thr = true;
                } else if (thr && tmp.charAt(i) == 'P') {
                    thr = false;
                    four = true;
                } else if (four && tmp.charAt(i) == 'C') {
                    four = false;
                    res = true;
                }
            }
        }
        if (res) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }

    }
}

