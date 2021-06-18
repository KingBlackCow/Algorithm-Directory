package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ21964_선린인터넷고등학교교가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str=st.nextToken();
        Stack<Character> stack =new Stack<>();
        for (int i = str.length()-1; i > str.length()-6; i--) {
            stack.add(str.charAt(i));
        }
        String str2="";
        while (!stack.isEmpty()){
            str2+=stack.pop();
        }
        System.out.println(str2);
    }
}