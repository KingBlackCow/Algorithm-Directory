package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16235_나무재태크 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, k;
    private static int[][] ary;
    static int dr[] = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int dc[] = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ary = new int[n][n];
        int map[][] = new int[n][n];


        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            for (int l = 0; l < n; l++) {
                map[j][l] = Integer.parseInt(st.nextToken());
                ary[j][l] = 5;
            }
        }
        List<Node> list = new LinkedList<>();
        Queue<Node> deadQ = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y, age));
        }
        for (int i = 0; i < k; i++) {
            for (int l = 0; l < list.size(); l++) {
                Node tmp = list.get(l);
                if (tmp.age <= ary[tmp.x][tmp.y]) {
                    ary[tmp.x][tmp.y] -= tmp.age;
                    tmp.age++;
                } else {
                    deadQ.add(tmp);
                }
            }

            while (!deadQ.isEmpty()) {
                Node tmp = deadQ.poll();
                list.remove(tmp);
                ary[tmp.x][tmp.y] += tmp.age / 2;
            }

            List<Node> q = new LinkedList<>();
            for (int l = 0; l < list.size(); l++) {
                Node tmp = list.get(l);
                if (tmp.age % 5 == 0) {
                    for (int w = 0; w < 8; w++) {
                        int r = tmp.x + dr[w];
                        int c = tmp.y + dc[w];
                        if (r < 0 || r >= n || c < 0 || c >= n) continue;
                        q.add(new Node(r, c, 1));
                    }
                }
            }
            list.addAll(0, q);
            if(i==k-1){
                System.out.println(list.size());
                System.exit(0);
            }

            for (int l = 0; l < n; l++) {
                for (int o = 0; o < n; o++) {
                    ary[l][o] += map[l][o];
                }
            }

        }
    }


    static class Node {
        int x;
        int y;
        int age;

        Node(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

}

