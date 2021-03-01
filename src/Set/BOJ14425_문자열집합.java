package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ14425_문자열집합 {

    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<String> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        int res=0;
        for (int i = 0; i < m; i++) {
            if(set.contains(br.readLine())){
                res++;
            }
        }
        System.out.println(res);
    }
}


