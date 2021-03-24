package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ8972_미친아두이노 {
    static int n, m;
    static int[] dr = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static String[][] ary;

    static Queue<Node> arduinoQ;
    static Node me;
    static int visit[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new String[n][m];
        arduinoQ = new LinkedList<>();
        me = new Node(0, 0, 0);
        int num = 1;
        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                ary[i][j] = str[j];
                if (ary[i][j].equals("R")) {
                    arduinoQ.add(new Node(i, j, num++));
                } else if (ary[i][j].equals("I")) {
                    me.x = i;
                    me.y = j;
                }
            }
        }
        String order = br.readLine();

        for (int i = 0; i < order.length(); i++) {
            int cntOrder = order.charAt(i) - '0';
            for (int j = 1; j <= 9; j++) {
                if (cntOrder == j) {
                    me.x += dr[j - 1];
                    me.y += dc[j - 1];
                    visit = new int[n][m];
                    bfs();
                    if (me.num != visit[me.x][me.y]) {
                        int turn = i + 1;
                        System.out.println("kraj " + turn);
                        System.exit(0);
                    }
                    break;
                }
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ary[i][j] = ".";
            }
        }
        while (!arduinoQ.isEmpty()) {
            Node arduino = arduinoQ.poll();
            ary[arduino.x][arduino.y] = "R";
        }
        ary[me.x][me.y] = "I";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ary[i][j]);
            }
            System.out.println();
        }
    }

    private static void bfs() {
        int qSize = arduinoQ.size();
        for (int i = 0; i < qSize; i++) {
            Node arduino = arduinoQ.poll();
            int r = arduino.x;
            int c = arduino.y;
            if (arduino.x > me.x) {
                r--;
            } else if (arduino.x < me.x) {
                r++;
            }
            if (arduino.y > me.y) {
                c--;
            } else if (arduino.y < me.y) {
                c++;
            }
            if (r < 0 || c < 0 || r >= n || c >= m) continue;
            visit[r][c] += arduino.num;
            arduinoQ.add(new Node(r, c, arduino.num));
        }


        qSize = arduinoQ.size();
        for (int i = 0; i < qSize; i++) {
            Node arduino = arduinoQ.poll();
            if (arduino.num == visit[arduino.x][arduino.y]) {
                arduinoQ.add(arduino);
            }
        }

    }

    static class Node {
        int x;
        int y;
        int num;

        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}