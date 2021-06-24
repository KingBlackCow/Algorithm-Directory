package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13417_카드문자열 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            Queue<String> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                q.add(st.nextToken());
            }
            Deque<String> dq = new ArrayDeque<>();
            dq.add(q.poll());
            while (!q.isEmpty()){
                String cnt = q.poll();
                int pivot = dq.peekFirst().compareTo(cnt);
                if(pivot>=0){
                    dq.addFirst(cnt);
                }else{
                    dq.addLast(cnt);
                }
            }
            String str="";
            while (!dq.isEmpty()){
                str+=dq.poll();
            }
            sb.append(str+"\n");
        }
        System.out.println(sb.toString());

    }


}

