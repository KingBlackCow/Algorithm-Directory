package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14226_이모티콘 {
    static boolean[][] visit;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        res = Integer.parseInt(st.nextToken());
        visit = new boolean[1001][1001];
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0, 0));
        visit[1][0]=true;
        while (!q.isEmpty()) {
            Node tmp = q.poll();


            if (tmp.x == res) {
                return tmp.time;
            }
            int x = tmp.x;
            int clip = tmp.clip;
            int time = tmp.time;


            q.add(new Node(x, x, time + 1));
            //visit[x][x] = true;
            if (clip > 0 && x + clip <= 1000 && !visit[x + clip][clip]) {
                q.add(new Node(x + clip, clip, time + 1));
                visit[x+clip][clip] = true;
            }
            if (x - 1 >= 1 && !visit[x - 1][clip]) {
                q.add(new Node(x - 1, clip, time + 1));
                visit[x-1][clip] = true;
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int clip;
        int time;

        Node(int x, int clip, int time) {
            this.x = x;
            this.clip = clip;
            this.time = time;
        }
    }
}