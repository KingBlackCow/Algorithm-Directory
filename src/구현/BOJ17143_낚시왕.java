package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17143_낚시왕 {
    static int[][] map;
    static int n, m, sharkNum;
    static Queue<Shark> sharks;
    static PriorityQueue<Shark> sharksPrior;
    static int man = 0;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sharkNum = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        sharks= new LinkedList<>();
        sharksPrior = new PriorityQueue<>();

        for (int i = 0; i < sharkNum; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int km = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int mass = Integer.parseInt(st.nextToken());
            sharks.add(new Shark(x, y, km, dir, mass));
            map[x][y] = mass;
        }
        for (int i = 1; i <= m; i++) {
            hunting(i);
            map = new int[n + 1][m + 1];
            move();
            relocate();

        }
        sb.append(sum+"\n");
        System.out.print(sb.toString());
    }

    private static void relocate() {
        while (!sharksPrior.isEmpty()){
            Shark shark= sharksPrior.poll();
            if(map[shark.x][shark.y]!=0){
                continue;
            }
            map[shark.x][shark.y]=shark.mass;
            sharks.add(shark);
        }
    }

    private static void move() {
        while (!sharks.isEmpty()){
            Shark shark = sharks.poll();
            int km = shark.km;
            int x = shark.x;
            int y = shark.y;
            int dir = shark.dir;
            while (km > 0) {
                if (dir == 1) {
                    if(x==1){
                        dir=2;
                        x++;
                        km--;
                        continue;
                    }
                    while (x > 1) {
                        x--;
                        km--;
                        if (km == 0) break;
                        if (x == 1) {
                            dir = 2;
                        }
                    }

                } else if (dir == 2) {
                    if(x==n){
                        dir=1;
                        x--;
                        km--;
                        continue;
                    }
                    while (x < n) {
                        x++;
                        km--;
                        if (km == 0) break;
                        if (x == n) {
                            dir = 1;
                        }
                    }

                } else if (dir == 3) {
                    if(y==m){
                        dir=4;
                        y--;
                        km--;
                        continue;
                    }
                    while (y < m) {
                        y++;
                        km--;
                        if (km == 0) break;
                        if (y == m) {
                            dir = 4;
                        }
                    }

                } else if (dir == 4) {
                    if(y==1){
                        dir=3;
                        y++;
                        km--;
                        continue;
                    }
                    while (y > 1) {
                        y--;
                        km--;
                        if (km == 0) break;
                        if (y == 1) {
                            dir = 3;
                        }
                    }
                }
            }
            sharksPrior.add(new Shark(x,y,shark.km,dir,shark.mass));
        }
    }

    private static void hunting(int man) {
        for (int i = 1; i <= n; i++) {
            if (map[i][man] != 0) {
                sum += map[i][man];
                while (!sharks.isEmpty()) {
                    Shark shark = sharks.poll();
                    if (shark.x == i && shark.y == man) {
                        break;
                    }
                    sharks.add(shark);
                }
                break;
            }
        }
    }

    static class Shark implements Comparable<Shark>{
        int x;
        int y;
        int km;
        int dir;
        int mass;

        public Shark(int x, int y, int km, int dir, int mass) {
            this.x = x;
            this.y = y;
            this.km = km;
            this.dir = dir;
            this.mass = mass;
        }

        @Override
        public int compareTo(Shark o) {
            return Integer.compare(o.mass,this.mass);
        }
    }
}