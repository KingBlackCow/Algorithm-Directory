package Set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class BOJ11478_서로다른문자열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str=st.nextToken();
        Set<String> set=new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length()-i; j++) {
                String subStr=str.substring(j,j+1+i);
                if(!set.contains(subStr)){
                    set.add(subStr);
                }
            }
        }
        System.out.println(set.size());
    }
}

