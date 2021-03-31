package 구현;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14718_용감한용산진수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;

    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(x, y, z);
        }
        Arrays.sort(nodes);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (nodes[k].x <= nodes[i].x && nodes[k].y <= nodes[j].y) {
                        cnt++;
                    }
                    if (cnt == m) {
                        ans = Math.min(ans, nodes[i].x + nodes[j].y + nodes[k].z);
                        break;
                    }
                }
            }
        }

        bw.write(ans + "");
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int z;

        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.z, o.z);
        }
    }
}