package Set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ10546_배부른마라토너 {

    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        HashSet<String> set=new HashSet<>();
        for (int i = 0; i < n*2-1; i++) {
            String tmp =br.readLine();
            if(set.contains(tmp)){
                set.remove(tmp);
            }else{
                set.add(tmp);
            }
        }

        List<String> list =new LinkedList<>(set);
        System.out.println(list.get(0));
    }
}