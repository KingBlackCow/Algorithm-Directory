package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ19237_어른상어 {

    static int[][] ary;
    static int n, m, k;
    static SharkVisit[][] visit;
    static int dr[] = {0, -1, 1, 0, 0};
    static int dc[] = {0, 0, 0, -1, 1};
    static Queue<Shark> sharkQueue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ary = new int[n][n];
        visit = new SharkVisit[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j]=new SharkVisit(0,0);
            }
        }
        List<Shark> sharkList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if (ary[i][j] != 0) {
                    sharkList.add(new Shark(ary[i][j], i, j));
                    visit[i][j] = new SharkVisit(ary[i][j], k);
                }
            }
        }
        Collections.sort(sharkList);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            Shark tmp = sharkList.get(0);
            sharkList.add(new Shark(tmp.sharkNum, tmp.x, tmp.y, Integer.parseInt(st.nextToken())));
            sharkList.remove(0);
        }
        sharkQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int[][] arr = new int[5][5];
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= 4; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            Shark tmp = sharkList.get(0);
            sharkQueue.add(new Shark(tmp.sharkNum, tmp.x, tmp.y, tmp.dir, arr));
            sharkList.remove(0);
        }
        int turn = 1;
        while (turn <= 1000) {
            int sharkQueueSize = sharkQueue.size();
            int sharkMoveDir[]=new int [sharkQueueSize];
            for (int i = 0; i < sharkQueueSize; i++) {
                Shark tmp = sharkQueue.poll();
                sharkMoveDir[i] = sharkAbleMove(tmp);
                sharkQueue.add(tmp);
            }
            for (int i = 0; i < sharkQueueSize; i++) {
                Shark tmp = sharkQueue.poll();
                if (sharkMoveDir[i] == -1) {
                    sharkRetrieve(tmp);
                } else {
                    sharkMove(tmp, sharkMoveDir[i]);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visit[i][j].smellTurn>0){
                        visit[i][j].smellTurn--;
                        if(visit[i][j].smellTurn==0){
                            visit[i][j].sharkNum=0;
                        }
                    }
                }
            }
            if (sharkQueue.size() == 1) break;
            turn++;
        }

        if (turn > 1000) {
            bw.write(-1 + "\n");
        } else {
            bw.write(turn + "\n");
        }
        bw.close();
        br.close();
    }

    private static void sharkRetrieve(Shark tmp) {
        ary[tmp.x][tmp.y]=0;

        for (int j = 1; j <= 4; j++) {
            int dir = tmp.sharkPriorDir[tmp.dir][j];
            int r = tmp.x + dr[dir];
            int c = tmp.y + dc[dir];
            if (r < 0 || r >= n || c < 0 || c >= n) continue;
            if (visit[r][c].sharkNum == tmp.sharkNum) {
                ary[r][c] = tmp.sharkNum;
                visit[r][c] = new SharkVisit(tmp.sharkNum, k + 1);
                sharkQueue.add(new Shark(tmp.sharkNum, r, c, dir, tmp.sharkPriorDir));
                break;
            }
        }
    }

    static int sharkAbleMove(Shark tmp) {

        for (int j = 1; j <= 4; j++) {
            int dir = tmp.sharkPriorDir[tmp.dir][j];
            if (dir == 1) {
                if (tmp.x - 1 < 0 || visit[tmp.x - 1][tmp.y].smellTurn != 0) continue;
                    return dir;

            } else if (dir == 2) {
                if (tmp.x + 1 >= n || visit[tmp.x + 1][tmp.y].smellTurn != 0) continue;
                    return dir;

            } else if (dir == 3) {
                if (tmp.y - 1 < 0 || visit[tmp.x][tmp.y - 1].smellTurn != 0) continue;
                    return dir;

            } else if (dir == 4) {
                if (tmp.y + 1 >= n || visit[tmp.x][tmp.y + 1].smellTurn != 0) continue;
                return dir;
            }
        }
        return -1;
    }

    static void sharkMove(Shark tmp, int sharkMoveDir) {
        int r = tmp.x + dr[sharkMoveDir];
        int c = tmp.y + dc[sharkMoveDir];
        ary[tmp.x][tmp.y] = 0;
        if (ary[r][c] == 0) {
            visit[r][c] = new SharkVisit(tmp.sharkNum, k + 1);
            ary[r][c] = tmp.sharkNum;
            tmp.x = r;
            tmp.y = c;
            tmp.dir=sharkMoveDir;
            sharkQueue.add(tmp);
        }
    }


    static class Shark implements Comparable<Shark> {
        int sharkNum;
        int x;
        int y;
        int dir;
        int[][] sharkPriorDir = new int[5][5];

        Shark(int sharkNum, int x, int y) {
            this.sharkNum = sharkNum;
            this.x = x;
            this.y = y;
        }

        Shark(int sharkNum, int x, int y, int dir) {
            this.sharkNum = sharkNum;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        Shark(int sharkNum, int x, int y, int dir, int[][] sharkPriorDir) {
            this.sharkNum = sharkNum;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.sharkPriorDir = sharkPriorDir;
        }

        @Override
        public int compareTo(Shark o) {
            return Integer.compare(this.sharkNum, o.sharkNum);
        }
    }

    static class SharkVisit {
        int sharkNum;
        int smellTurn;

        SharkVisit(int sharkNum, int smellTurn) {
            this.sharkNum = sharkNum;
            this.smellTurn = smellTurn;
        }
    }
}
