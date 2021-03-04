import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq=new PriorityQueue<>();
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp=Integer.parseInt(st.nextToken());
            pq.add(new Node(tmp,tmp));
        }

        long turn=0;
        long res=0;
        while (!pq.isEmpty()){
            Node tmp=pq.poll();
            turn++;
            if(turn>=m) {
                res=tmp.x;
                break;
            }

            tmp.x+=tmp.y;
            pq.add(tmp);
        }
        System.out.println(res);
    }
    static class Node implements Comparable<Node>{
        long x;
        long y;
        Node(long x,long y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.x-o.x);
        }
    }
}

