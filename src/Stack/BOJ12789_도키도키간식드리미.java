package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ12789_도키도키간식드리미 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> list = new ArrayList<>();
        int turn = 1;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (turn == tmp) {
                list.add(tmp);
                turn++;
            } else if (!stack.isEmpty() && stack.peek() == turn) {
                list.add(stack.pop());
                turn++;
                while (!stack.isEmpty() && stack.peek() == turn) {
                    list.add(stack.pop());
                    turn++;
                }
                stack.add(tmp);
            } else {
                stack.add(tmp);
            }
        }
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            if (tmp == turn) {
                list.add(tmp);
                turn++;
            } else {
                break;
            }
        }

        if (list.size() == n) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}

