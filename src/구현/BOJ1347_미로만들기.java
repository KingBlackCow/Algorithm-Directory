package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1347_미로만들기 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        int minX, minY, maxX, maxY, cntX, cntY;
        cntX = cntY = minX = minY = maxX = maxY = 50;
        boolean[][] visit = new boolean[101][101];
        visit[50][50] = true;
        char[] order = br.readLine().toCharArray();
        int dir = 0;
        for (int i = 0; i < n; i++) {
            switch (order[i]) {
                case 'R':
                    if (++dir > 3) {
                        dir = 0;
                    }
                    break;
                case 'L':
                    if (--dir < 0) {
                        dir = 3;
                    }
                    break;
                case 'F':
                    if (dir == 0) {
                        cntX++;
                        maxX = Math.max(maxX, cntX);
                    } else if (dir == 1) {
                        cntY--;
                        minY = Math.min(minY, cntY);

                    } else if (dir == 2) {
                        cntX--;
                        minX = Math.min(minX, cntX);

                    } else {
                        cntY++;
                        maxY = Math.max(maxY, cntY);
                    }
                    visit[cntX][cntY] = true;
                    break;
            }
        }

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if(visit[i][j]){
                    sb.append(".");
                }else{
                    sb.append("#");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

