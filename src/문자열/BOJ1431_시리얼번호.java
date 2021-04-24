package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1431_시리얼번호 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n =Integer.parseInt(br.readLine());
        List<Node> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(br.readLine()));
        }
        Collections.sort(list);
        for (Node node:list) {
            System.out.println(node.str);
        }
    }

    static class Node implements Comparable<Node>{
        String str;
        int len;
        public Node(String str) {
            this.str = str;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)>=48&&str.charAt(i)<=57){
                    this.len += Integer.parseInt(String.valueOf(str.charAt(i)));
                }
            }

        }

        @Override
        public int compareTo(Node o) {
            if(this.str.length()==o.str.length()){
                if(this.len == o.len){
                    return this.str.compareTo(o.str);
                }
                return this.len - o.len;
            }
            
            return this.str.length()-o.str.length();
        }
    }


}
