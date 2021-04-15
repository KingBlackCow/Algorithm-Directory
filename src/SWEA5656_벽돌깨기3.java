
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA5656_벽돌깨기3 {
    private static int N, W, H, min;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            go(0, map);
            System.out.println("#" + t + " " + min);
        }
    }

    // 중복순열로 구슬 떨어뜨리기
    //boolean :true- 모두 깨뜨린 상황

    private static boolean go(int cnt, int[][] map) {//cnt는 구슬을 떨어뜨린 횟수, map: cnt-1 구슬까지의 상태맵
        int result = getRemain(map);
        if (result == 0) { // 모두 빈 칸 (깨뜨릴 벽돌이 없을때
            min = 0;
            return true;

        }
        if (cnt == N) {
            min = Math.min(min, result);
            return false;
        }
        int[][] newMap = new int[H][W];
        //매열마다 구슬 떨어뜨리는 시도
        for (int c = 0; c < W; c++) {
            //해당열에 구슬을 떨어뜨려 맞는 벽돌 찾기
            int r = 0;
            while (r < H && map[r][c] == 0) {
                ++r;
            }
            if (r == H) { // 맞는 벽돌 없음 (모두 빈칸)
                continue; //다음열로 구슬 떨어뜨리기
            } else {
                //기존 cnt-1 구슬까지의 상태로 초기화
                copy(map, newMap);
                //벽돌 깨뜨리기
                boom(newMap, r, c);
                //벽돌 내리기(꺠지고 난 빈 공간 처리
                down(newMap);
                // 다음 구슬 던지기

                if (go(cnt + 1, newMap)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getRemain(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] > 0) ++cnt;
            }
        }
        return cnt;
    }

    private static ArrayList<Integer> list = new ArrayList<>();

    private static void down(int[][] map) {
        for (int c = 0; c < W; c++) {

            for (int r = H - 1; r >= 0; r--) {
                if (map[r][c] > 0) { // 벽돌이면
                    list.add(map[r][c]);
                    map[r][c] = 0;
                }
            }// 벽돌 리스트에 넣기
            int r = H;
            for (int b : list) { //리스트에 담긴 벽돌 차례대로 꺼내어 맨 아래행부터 채우기
                map[--r][c] = b;
            }
            list.clear();
        }
    }

    private static void boom(int[][] map, int r, int c) {
        Queue<Point> q = new LinkedList<>();
        if (map[r][c] > 1) {
            q.add(new Point(r, c, map[r][c]));
        }
        map[r][c] = 0; //제거처리

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = p.r;
                int nc = p.c;
                for (int k = 1; k < p.cnt; k++) {
                    nr += dr[d];
                    nc += dc[d];
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
                        if (map[nr][nc] > 1) {
                            q.add(new Point(nr, nc, map[nr][nc]));
                        }
                        map[nr][nc] = 0;
                    }
                }
            }
        }
    }

    private static void copy(int[][] map, int[][] newMap) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }

}
