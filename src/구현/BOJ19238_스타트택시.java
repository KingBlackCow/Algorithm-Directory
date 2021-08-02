package 구현;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ19238_스타트택시 {
    static int[][] map;
    static int n, m, remain;
    static int startX, startY, endX, endY;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visit;
    static Queue<Person> personQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        remain = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        personQ = new LinkedList<>();

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());
            int dX = Integer.parseInt(st.nextToken());
            int dY = Integer.parseInt(st.nextToken());
            personQ.add(new Person(i, sX, sY, dX, dY));
        }
        for (int i = 0; i < m; i++) {
            int dist = findPerson();
            if (dist == -1 || dist > remain) {
                System.out.println(-1);
                System.exit(0);
            }
            remain -= dist;
            int dist2 = bringPerson();
            if (dist2 == -1 || dist2 > remain) {
                System.out.println(-1);
                System.exit(0);
            }
            remain -= dist2;
            remain += dist2 * 2;
            if (remain <= 0) {
                System.out.println(-1);
                System.exit(0);
            }
        }
        System.out.println(remain);
    }

    private static int bringPerson() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));
        visit = new boolean[n + 1][n + 1];
        visit[startX][startY] = true;
        int turn = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Point point = q.poll();
                if (point.x == endX && point.y == endY) {
                    startX = point.x;
                    startY = point.y;
                    return turn;
                }
                for (int j = 0; j < 4; j++) {
                    int r = point.x + dr[j];
                    int c = point.y + dc[j];
                    if (r < 1 || c < 1 || r > n || c > n) continue;
                    if (!visit[r][c]) {
                        if (map[r][c] != 1) {
                            visit[r][c] = true;
                            q.add(new Point(r, c));
                        }
                    }
                }
            }
            turn++;
        }
        return -1;
    }

    private static int findPerson() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));
        visit = new boolean[n + 1][n + 1];
        visit[startX][startY] = true;
        int[][] newMap = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) {
                    newMap[i][j] = -1;
                    continue;
                } else if (map[i][j] == 0) {
                    newMap[i][j] = Integer.MAX_VALUE;
                }
                //newMap[i][j] = map[i][j];
            }
        }
        int turn = 1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Point point = q.poll();
                for (int j = 0; j < 4; j++) {
                    int r = point.x + dr[j];
                    int c = point.y + dc[j];
                    if ((r < 1 || c < 1 || r > n || c > n)) continue;
                    if (!visit[r][c]) {
                        if (newMap[r][c] != -1) {
                            visit[r][c] = true;
                            newMap[r][c] = turn;
                            q.add(new Point(r, c));
                        }
                    }
                }
            }
            turn++;
        }

        int personQSize = personQ.size();
        int min = 987654321;
        int minSx = 0;
        int minSy = 0;
        int minNum = 0;
        int minEx = 0;
        int minEy = 0;
        for (int i = 0; i < personQSize; i++) {
            Person person = personQ.poll();
            if (min > newMap[person.sX][person.sY]) {
                if (minNum != 0) {
                    personQ.add(new Person(minNum, minSx, minSy, minEx, minEy));
                }
                min = newMap[person.sX][person.sY];
                minNum = person.num;
                minSx = person.sX;
                minSy = person.sY;
                minEx = person.eX;
                minEy = person.eY;
                continue;
            } else if (min == newMap[person.sX][person.sY]) {
                if (minNum > person.num) {
                    personQ.add(new Person(minNum, minSx, minSy, minEx, minEy));
                    min = newMap[person.sX][person.sY];
                    minNum = person.num;
                    minSx = person.sX;
                    minSy = person.sY;
                    minEx = person.eX;
                    minEy = person.eY;
                    continue;
                }

            }
            personQ.add(person);
        }
        if (minSx == 0 || minSy == 0 || minEx == 0 || minEy == 0) return -1;
        startX = minSx;
        startY = minSy;
        endX = minEx;
        endY = minEy;
        return min;
    }

    static class Person implements Comparable<Person> {
        int num;
        int sX, sY, eX, eY;

        public Person(int num, int sX, int sY, int eX, int eY) {
            this.num = num;
            this.sX = sX;
            this.sY = sY;
            this.eX = eX;
            this.eY = eY;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.num, o.num);
        }
    }


}

