package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21608_상어초등학교 {
    static int n;
    static List<Node> studentList = new LinkedList<>();
    static PriorityQueue<Empty> emptyQ = new PriorityQueue<>();
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            Set<Integer> tmpSet = new HashSet<>();
            while (st.hasMoreTokens()) {
                tmpSet.add(Integer.parseInt(st.nextToken()));
            }
            studentList.add(new Node(num, tmpSet));
        }
        emptyCheck();
        int sum = 0;
        for (int i = 0; i < studentList.size(); i++) {
            int cnt = 0;
            int a = 0;
            int b = 0;
            out:
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (map[j][k] == studentList.get(i).num) {
                        a = j;
                        b = k;
                        break out;
                    }
                }
            }
            for (int j = 0; j < 4; j++) {
                int r = a + dr[j];
                int c = b + dc[j];
                if (r < 1 || c < 1 || r > n || c > n) continue;
                if (studentList.get(i).set.contains(map[r][c])) {
                    cnt++;
                }
            }
            if (cnt == 0) continue;
            sum += Math.pow(10, cnt - 1);
        }
        System.out.println(sum);

    }

    private static void emptyCheck() {
        for (int q = 0; q < studentList.size(); q++) {
            Node student = studentList.get(q);
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] == 0) {
                        int adj = 0;
                        int emptyPlace = 0;
                        for (int k = 0; k < 4; k++) {
                            int r = i + dr[k];
                            int c = j + dc[k];
                            if (r < 1 || c < 1 || r > n || c > n) continue;
                            if (student.set.contains(map[r][c])) {
                                adj++;
                            }
                            if (map[r][c] == 0) {
                                emptyPlace++;
                            }
                        }
                        emptyQ.add(new Empty(i, j, adj, emptyPlace));
                    }
                }
            }
            Empty empty = emptyQ.poll();
            map[empty.x][empty.y] = student.num;
            emptyQ.clear();
        }
    }

    static class Node {
        int num;
        Set<Integer> set;

        public Node(int num, Set<Integer> set) {
            this.num = num;
            this.set = set;
        }
    }

    static class Empty implements Comparable<Empty> {
        int x;
        int y;
        int adj;
        int emptyPlace;

        public Empty(int x, int y, int adj, int emptyPlace) {
            this.x = x;
            this.y = y;
            this.adj = adj;
            this.emptyPlace = emptyPlace;
        }

        @Override
        public int compareTo(Empty o) {
            if (o.adj == this.adj) {
                if (o.emptyPlace == this.emptyPlace) {
                    if (this.x == o.x) {
                        return Integer.compare(this.y, o.y);
                    }
                    return Integer.compare(this.x, o.x);
                }
                return Integer.compare(o.emptyPlace, this.emptyPlace);
            }
            return Integer.compare(o.adj, this.adj);
        }
    }

}

