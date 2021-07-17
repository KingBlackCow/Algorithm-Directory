package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ17837_새로운게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] ary = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            ary[i][0] = 2;
            ary[0][i] = 2;
            ary[n + 1][i] = 2;
            ary[i][n + 1] = 2;
        }
        Deque<Integer>[][] dq = new ArrayDeque[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
                dq[i][j] = new ArrayDeque<Integer>();
            }
        }
        int[][] map = new int[k][3];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[i][0] = x;
            map[i][1] = y;
            map[i][2] = Integer.parseInt(st.nextToken());//→, ←, ↑, ↓의
            dq[x][y].addLast(i);
        }
        int[] dx = new int[]{0, 0, 0, -1, 1};
        int[] dy = new int[]{0, 1, -1, 0, 0};
        int time = 1;
        out:
        while (time < 1001) {
            for (int i = 0; i < k; i++) {
                int x = map[i][0];
                int y = map[i][1];
                if (ary[x + dx[map[i][2]]][y + dy[map[i][2]]] == 2) {
                    if (map[i][2] == 1) {
                        map[i][2] = 2;
                    } else if (map[i][2] == 2) {
                        map[i][2] = 1;
                    } else if (map[i][2] == 3) {
                        map[i][2] = 4;
                    } else if (map[i][2] == 4) {
                        map[i][2] = 3;
                    }
                }
                int dir = map[i][2];
                int r = x + dx[dir];
                int c = y + dy[dir];
                if (ary[r][c] == 2) {
                    continue;
                }
                if (ary[r][c] == 0) {
                    int size = dq[x][y].size();
                    boolean flag = false;
                    for (int j = 0; j < size; j++) {
                        int tmp = dq[x][y].pollFirst();
                        if (tmp == i) {
                            flag = true;
                        }
                        if (flag) {
                            dq[r][c].add(tmp);
                            map[tmp][0] = r;
                            map[tmp][1] = c;
                        } else {
                            dq[x][y].add(tmp);
                        }
                    }
                } else if (ary[r][c] == 1) {
                    while (!dq[x][y].isEmpty()) {
                        int tmp = dq[x][y].pollLast();
                        dq[r][c].add(tmp);
                        map[tmp][0] = r;
                        map[tmp][1] = c;
                        if (tmp == i) {
                            break;
                        }
                    }
                }
                if(dq[r][c].size()>3)break out;
            }
            time++;
        }
        System.out.println(time == 1001 ? -1 : time);

    }

}