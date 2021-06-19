package Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class BOJ21967_세워라반석위에 {
    static int n;
    static int[] num;
    static Deque<Integer> dq = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        num = new int[11];
        StringTokenizer st= new StringTokenizer(br.readLine());
        int ans= 0;
        for (int i = 0; i < n; i++) {
            int a= Integer.parseInt(st.nextToken());
            num[a]++;
            dq.add(a);
            while (check()>2&&!dq.isEmpty()){
                int b=dq.pollFirst();
                num[b]--;
            }
            ans =Math.max(ans,dq.size());

        }
        System.out.println(ans);

        bw.flush();
        bw.close();
        br.close();
    }

    static int check()
    {
        int a = 0;
        for (int i = 1; i <= 10; i++)
            if (num[i] > 0)
            {
                a = i;
                break;
            }
        int b = 0;
        for (int i = 10; i >= 1; i--)
            if (num[i] > 0)
            {
                b = i;
                break;
            }
        return b - a;
    }
}
