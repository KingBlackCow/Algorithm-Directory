package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2812_크게만들기 {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int cnt=k;
        char[] str = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (k != 0 && !stack.isEmpty() && stack.peek() < str[i]) {
                stack.pop();
                k--;
            }
            stack.push(str[i]);
        }
        StringBuilder sb=new StringBuilder();
        List<Character> list=new ArrayList<>(stack);

        for (int i = 0; i < n-cnt; i++) {
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
    }
}
