package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16946_벽부수고이동하기4 {
    static int n, m;
    static int[][] ary;
    static int[][] wall;
    static boolean[][] visit;
    static int[][] visited;
    static int visitedNum;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(str[j]);
            }
        }
        wall = new int[n][m];

        visit = new boolean[n][m];
        visitedNum = 1;
        Map<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ary[i][j] == 0 && wall[i][j] == 0) {
                    map.put(visitedNum,bfs(i, j));
                    visitedNum++;
                }

            }
        }

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ary[i][j] == 1) {
                    Set<Integer> set = new HashSet<>();
                    int sum = 1;

                    for (int k = 0; k < 4; k++) {
                        int r = i + dr[k];
                        int c = j + dc[k];
                        if (r < 0 || c < 0 || r >= n || c >= m) continue;
                        if(wall[r][c]==0)continue;
                        set.add(wall[r][c]);
                    }
                    for (Integer item:set) {
                        sum+=map.get(item);
                    }
                    sb.append(sum%10);
                }else{
                    sb.append("0");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;
        wall[x][y] = visitedNum;
        int count = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int t = 0; t < qSize; t++) {
                Node tmp = q.poll();
                count++;
                for (int i = 0; i < 4; i++) {
                    int r = tmp.x + dr[i];
                    int c = tmp.y + dc[i];
                    if (r < 0 || c < 0 || r >= n || c >= m) continue;
                    if (!visit[r][c] && ary[r][c] == 0) {
                        q.add(new Node(r, c));
                        visit[r][c] = true;
                        wall[r][c] = visitedNum;

                    }
                }
            }

        }
        return count;
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