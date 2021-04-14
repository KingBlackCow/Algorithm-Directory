import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int m, a;
    private static int[] moveA, moveB;
    private static BC[] bcList;
    private static Node A, B;
    private static int[] dx = {0, -1, 0, 1, 0};
    private static int[] dy = {0, 0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            bcList = new BC[a];
            moveA = new int[m + 1];
            moveB = new int[m + 1];
            moveA[0] = 0;
            moveB[0] = 0;
            A = new Node(0, 0);
            B = new Node(9, 9);
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++){
                moveA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++){
                moveB[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int range = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                bcList[i] = new BC(y - 1, x - 1, range, power);
            }

            int answer = solution();
            System.out.println("#" + t + " " + answer);
        }
    }

    private static int solution() {
        int sum = 0;
        for (int t = 0; t <= m; t++) {
            A.setIndex(moveA[t]); // A, B 이동
            B.setIndex(moveB[t]);
            sum += getMax(getCheck(A, B));
        }
        return sum;
    }

    private static int getMax(boolean[][] check) {
        int max = 0, value;
        boolean checkA, checkB;
        for (int i = 0; i < a; i++) {
            checkA = check[0][i];
            for (int j = 0; j < a; j++) {
                checkB = check[1][j];
                value = 0;
                if (i == j && checkA && checkB)
                    value = bcList[i].power;
                else {
                    if (checkA) value += bcList[i].power;
                    if (checkB) value += bcList[j].power;
                }
                max = Math.max(max, value);
            }
        }
        return max;
    }

    private static boolean[][] getCheck(Node idxA, Node idxB) {
        boolean[][] result = new boolean[2][a];
        for (int i = 0; i < a; i++) {
            BC bc = bcList[i];
            if (getDistance(idxA, bc.node) <= bc.range)
                result[0][i] = true;
            if (getDistance(idxB, bc.node) <= bc.range)
                result[1][i] = true;
        }
        return result;
    }

    private static int getDistance(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setIndex(int dir) {
            this.x = x + dx[dir];
            this.y = y + dy[dir];
        }
    }

    static class BC {
        Node node;
        int range;
        int power;
        public BC(int x, int y, int range, int power) {
            this.node = new Node(x, y);
            this.range = range;
            this.power = power;
        }
    }
}


