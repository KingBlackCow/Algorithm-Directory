package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19236_청소년상어 {
    public static int[][] map;
    public static Fish[] fish;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[4][4];
        fish = new Fish[17];
        for(int i = 0; i < 4; i++) {
            st  = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken())-1;
                fish[num] = new Fish(num, i, j, dir, 1);
                map[i][j] = num;
            }
        }

        int sharkX = 0, sharkY = 0;
        int sharkDir = fish[map[0][0]].dir;
        int sharkEat = map[0][0];
        fish[map[0][0]].alive = 0;
        map[0][0] = -1;

        dfs(sharkX, sharkY, sharkDir, sharkEat);

        System.out.println(ans);
    }

    public static void dfs(int sharkX, int sharkY, int sharkDir, int cnt) {
        ans = Math.max(ans, cnt);

        int[][] tmpMap = new int[map.length][map.length];
        for(int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, tmpMap[i], 0, map.length);
        }


        Fish[] tmp = new Fish[fish.length];
        for(int i = 1; i <= 16; i++) {
            tmp[i] = new Fish(fish[i].num, fish[i].x, fish[i].y, fish[i].dir, fish[i].alive);
        }

        moveFish();

        for(int i = 1; i < 4; i++) {
            int r = sharkX + dx[sharkDir] * i;
            int c = sharkY + dy[sharkDir] * i;

            if(r >= 0 && r < 4 && c >= 0 && c < 4 && map[r][c] != 0) {
                int eatFish = map[r][c];
                int nd = fish[eatFish].dir;
                map[sharkX][sharkY] = 0;
                map[r][c] = -1;
                fish[eatFish].alive = 0;

                dfs(r, c, nd, cnt+eatFish);

                fish[eatFish].alive = 1;
                map[sharkX][sharkY] = -1;
                map[r][c] = eatFish;
            }
        }


        for(int j = 0; j < map.length; j++)
            System.arraycopy(tmpMap[j], 0, map[j], 0, map.length);

        for(int i=1; i<=16; i++)
            fish[i] = new Fish(tmp[i].num, tmp[i].x, tmp[i].y, tmp[i].dir, tmp[i].alive);
    }

    public static void moveFish() {
        for(int i = 1; i < 17; i++) {
            if(fish[i].alive == 0) {
                continue;
            }

            int cnt = 0;
            int dir = fish[i].dir;
            int nx = 0;
            int ny = 0;

            while(cnt < 8) {
                dir %= 8;
                fish[i].dir = dir;

                nx = fish[i].x + dx[dir];
                ny = fish[i].y + dy[dir];

                if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != -1) {
                    if(map[nx][ny] == 0) {
                        map[fish[i].x][fish[i].y] = 0;
                        fish[i].x = nx;
                        fish[i].y = ny;
                        map[nx][ny] = i;
                    } else {
                        int changeFish = fish[map[nx][ny]].num;
                        fish[changeFish].x = fish[i].x;
                        fish[changeFish].y = fish[i].y;
                        map[fish[changeFish].x][fish[changeFish].y] = changeFish;

                        fish[i].x = nx;
                        fish[i].y = ny;
                        map[nx][ny] = i;
                    }
                    break;
                } else {
                    dir++;
                    cnt++;
                }
            }
        }
    }

}

class Fish {
    int num;
    int x;
    int y;
    int dir;
    int alive;

    Fish(int num, int x, int y, int dir, int alive) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.alive = alive;
    }
}