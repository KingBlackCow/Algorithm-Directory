package PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13975_파일합치기3 {
    static int T,n;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        T= Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0){
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            pq.clear();
            for (int i = 0; i < n; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            while (pq.size()>1){
                long a = pq.poll();
                long b = pq.poll();
                sum+=a+b;
                if(pq.isEmpty())break;
                pq.add(a+b);
            }
            if(!pq.isEmpty()){
                sum+=pq.poll();
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb.toString());
    }
}