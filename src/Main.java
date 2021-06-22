import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {
    static int n;
    static int f;
    static double[] dist;
    static Edge[] nodes;
    static Set<Integer> set;
    static List<Edge> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        dist = new double[n + 1];
        Arrays.fill(dist, 987654321);
        nodes = new Edge[n + 1];
        set = new HashSet<>();
        list= new ArrayList[n+1];

        for (int i = 0; i <=n; i++) {
            list[i]= new ArrayList<>();
        }
        nodes[0]= new Edge(0,0,0,0);
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i] = new Edge(i, a, b,987654321);
            if (b == f) {
                set.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if ((Math.abs(nodes[j].x - nodes[i].x) > 2) || (Math.abs(nodes[j].y - nodes[i].y) > 2)) {
                    continue;
                }
                double distTmp = getDistance(nodes[j].x, nodes[j].y, nodes[i].x, nodes[i].y);
                list[i].add(new Edge(j,nodes[j].x, nodes[j].y,distTmp));
                list[j].add(new Edge(i,nodes[i].x, nodes[i].y,distTmp));
            }
        }
        dijkstra(0);
        double min = 987654321;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                min = Math.min(min, dist[i]);
            }
        }
        if (min == 987654321) System.out.println(-1);
        else System.out.println(Math.round(min));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        dist[start] = 0;
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(0, 0, 0, 0));
        boolean[] visit = new boolean[n+1];
        while (!q.isEmpty()) {
            Edge tmp = q.poll();
            if(visit[tmp.num])continue;
            visit[tmp.num]=true;

            for (Edge edge: list[tmp.num]) {

                if (dist[edge.num] > dist[tmp.num] + edge.weight) {
                    dist[edge.num] = dist[tmp.num] + edge.weight;
                    q.add(new Edge(edge.num, nodes[edge.num].x, nodes[edge.num].y, dist[edge.num]));
                }
            }
        }
    }

    static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    static class Edge implements Comparable<Edge>{
        int num;
        int x;
        int y;
        double weight;
        public Edge(int num, int x, int y, double weight) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight,o.weight);
        }
    }


}