package 구현;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class BOJ17144_미세먼지안녕 {

    static int n, m, t;


    static int ary[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static List<Point> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        ary = new int[n][m];


        list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if (ary[i][j] == -1) {
                    list.add(new Point(i, j));
                    ary[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < t; j++) {
            spread();
            cleanerStart(new int[n][m]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += ary[i][j];
            }
        }
        System.out.println(sum);
        br.close();
        System.exit(0);
    }

    private static void spread() {
        int spreadMap[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ary[i][j] != 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int r = i + dr[k];
                        int c = j + dc[k];
                        if (r < 0 || r >= n || c < 0 || c >= m) continue;
                        if (list.get(0).x == r && list.get(0).y == c) continue;
                        if (list.get(1).x == r && list.get(1).y == c) continue;
                        spreadMap[r][c] += ary[i][j] / 5;
                        cnt++;
                    }
                    spreadMap[i][j] += (ary[i][j] - cnt * (ary[i][j] / 5));

                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ary[i][j] = spreadMap[i][j];
            }
        }

    }

    public static void cleanerStart(int[][] nmap) {
        for (int idx = 0; idx < 2; idx++) {
            Point point = list.get(idx);
            int ny = point.x;
            int nx = point.y + 1;
            while (nx < m - 1) {
                nmap[ny][nx + 1] = ary[ny][nx];
                nx++;
            }
            if (idx == 0) {
                while (ny > 0) {
                    nmap[ny - 1][nx] = ary[ny][nx];
                    ny--;
                }
            } else {
                while (ny < n - 1) {
                    nmap[ny + 1][nx] = ary[ny][nx];
                    ny++;
                }
            }
            while (nx > 0) {
                nmap[ny][nx - 1] = ary[ny][nx];
                nx--;
            }
            if (idx == 0) {
                while (ny < point.x - 1) {
                    nmap[ny + 1][nx] = ary[ny][nx];
                    ny++;
                }
            } else {
                while (ny > point.x + 1) {
                    nmap[ny - 1][nx] = ary[ny][nx];
                    ny--;
                }
            }
        }
        cleanerCopy(nmap);
    }

    public static void cleanerCopy(int[][] nmap) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1 || i == list.get(0).x || i == list.get(1).x) {
                    ary[i][j] = nmap[i][j];
                }
            }
        }
        ary[list.get(0).x][list.get(0).y] = 0;
        ary[list.get(1).x][list.get(1).y] = 0;
    }
}

