package Stack;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_탑 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Stack<Point> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            if(!stack.isEmpty()){
                while (!stack.isEmpty()){
                    if(stack.peek().y>cnt){
                        sb.append(stack.peek().x+" ");
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                sb.append(0 + " ");
            }
            stack.add(new Point(i,cnt));
        }

        System.out.println(sb.toString());

    }


}