package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13413_오셀로재배치 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[] c1 = br.readLine().toCharArray();
            char[] c2 = br.readLine().toCharArray();

            int wbCnt=0, bwCnt = 0;
            for (int i = 0; i < n; ++i)
            {
                if (c1[i] == 'W' && c2[i] == 'B')
                    ++wbCnt;
                else if (c1[i] == 'B' && c2[i] == 'W')
                    ++bwCnt;
            }
            int res = wbCnt < bwCnt ? bwCnt : wbCnt;
            sb.append(res+"\n");
        }
        System.out.println(sb.toString());
    }
}

