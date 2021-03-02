package 최소스패닝트리_크루스칼;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ1922_네트워크연결 {
    static int n,m;
    static int[] parent;
    static PriorityQueue<edge> pq = new PriorityQueue<edge>();
    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n+1];

        for(int i=0; i<n+1; i++) {
            parent[i] = i;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new edge(Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken())
                    ,Integer.parseInt(st.nextToken())));
        }

        for(int i=0; i<m; i++) {
            edge tmp = pq.poll();

            int a = find(tmp.start);
            int b = find(tmp.end);

            if(a==b) continue;
            union(a,b);
            result += tmp.weight;
        }

        System.out.println(result);
    }

    public static int find(int a) {
        if(a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static void union(int a,int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot) {
            parent[aRoot] = b;
        } else {
            return;
        }
    }
}

class edge2 implements Comparable<edge2> {
    int start;
    int end;
    int weight;

    public edge2(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(edge2 o) {
        return o.weight >= this.weight ? -1 : 1;
    }
}