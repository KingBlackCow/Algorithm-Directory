package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ9536_여우는어떻게울지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        while (T-- > 0){
            HashSet<String> set= new HashSet<>();

            String[] str=br.readLine().split(" ");
            while (true){
                String[] tmp=br.readLine().split(" ");
                if(tmp[0].equals("what")){
                    break;
                }
                set.add(tmp[2]);
            }
            for (int i = 0; i < str.length; i++) {
                if(!set.contains(str[i])){
                    sb.append(str[i]+" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
