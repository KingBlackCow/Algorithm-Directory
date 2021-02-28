import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visit;
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        visit = new boolean[1000000001];
        System.out.println(bfs(a));


    }

    private static int bfs(int a) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a, 0));
        visit[a] = true;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.x == b) {
                return  tmp.y + 1;
            }
            if (tmp.x > b) return -1;
            if (tmp.x * 2 <= b && !visit[tmp.x * 2]) {
                q.add(new Node(tmp.x * 2, tmp.y + 1));
                visit[tmp.x * 2] = true;
            }
            if (tmp.x * 10 + 1 <= b) {
                if (!visit[tmp.x * 10 + 1]) {
                    q.add(new Node(tmp.x * 10 + 1, tmp.y + 1));
                    visit[tmp.x * 10 + 1] = true;
                }
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}