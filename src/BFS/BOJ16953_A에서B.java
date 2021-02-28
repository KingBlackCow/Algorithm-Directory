package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16953_A에서B {
    static boolean[] visit;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        res = Integer.parseInt(st.nextToken());
        visit = new boolean[1000000001];
        System.out.println(bfs());


    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0,0));
        visit[1] = true;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.x == res) {
                return tmp.time;
            }
            int x=tmp.x;
            int clip=tmp.clip;
            int time=tmp.time;
            q.add(new Node(x, x,time+1));

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