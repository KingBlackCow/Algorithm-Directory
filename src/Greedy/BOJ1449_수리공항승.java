package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1449_수리공항승 {
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] ary=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            ary[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);
        for (int i = 0; i < n; i++) {
            q.add(ary[i]);
        }
        int res=0;
        while (!q.isEmpty()){
            int tmp=q.poll();
            if(!q.isEmpty()) {
                while (tmp - 0.5 + k >= q.peek() + 0.5) {
                    q.poll();
                    if (q.isEmpty()) break;
                }
            }
            res++;
        }
        System.out.println(res);
    }
}