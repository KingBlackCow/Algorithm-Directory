package 구현;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ17822_원판돌리기 {
    static int n, m, turn;
    static List<Integer> list[];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        n = sc.nextInt();
        m = sc.nextInt();
        turn = sc.nextInt();
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                list[i].add(sc.nextInt());
            }
        }

        for (int i = 0; i < turn; i++) {
            int x = sc.nextInt();
            int dir = sc.nextInt();
            int move = sc.nextInt();
            for (int j = 1; x * j <= n; j++) {
                rotate(x * j, dir, move);
            }
            remove();

        }
        int res =check();
        System.out.println(res);

    }

    private static int check() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (list[i].get(j) != -1) {
                    sum += list[i].get(j);
                }
            }
        }
        return sum;
    }

    private static void remove() {
        int[][] ary = new int[n + 1][m];
        boolean wholeFlag = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                boolean flag = true;
                if(j==0 &&list[i].get(j).equals(list[i].get(m-1))){
                    if (list[i].get(j) != -1) {
                        wholeFlag = false;
                    }
                    flag=false;
                }

                if (j < m-1 && (list[i].get(j).equals(list[i].get(j + 1)))) {
                    if (list[i].get(j) != -1) {
                        wholeFlag = false;
                    }
                    flag = false;
                }

                if (j > 0 && (list[i].get(j).equals(list[i].get(j - 1)))) {
                    if (list[i].get(j) != -1) {
                        wholeFlag = false;
                    }
                    flag = false;
                }
                if(j ==m-1&&list[i].get(j).equals(list[i].get(0))){
                    if (list[i].get(j) != -1) {
                        wholeFlag = false;
                    }
                    flag=false;

                }

                if (i < n && list[i].get(j).equals(list[i + 1].get(j))) {
                    if (list[i].get(j).equals(-1)) {
                        wholeFlag = false;
                    }
                    flag = false;
                }
                if (i > 1 && list[i].get(j).equals(list[i - 1].get(j))) {
                    if (list[i].get(j) != -1) {
                        wholeFlag = false;
                    }
                    flag = false;
                }


                if (flag) {
                    ary[i][j] = list[i].get(j);
                } else {
                    ary[i][j] = -1;
                }

            }
        }
        if (wholeFlag) {
            ary = change(ary);
        }
        for (int i = 1; i <= n; i++) {
            list[i].clear();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                list[i].add(ary[i][j]);
            }
        }

    }

    private static int[][] change(int[][] ary) {
        int cnt = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (ary[i][j] != -1) {
                    sum += ary[i][j];
                    cnt++;
                }
            }
        }
        double avg = 0;
        if (cnt > 0) {
            avg = sum /(double) cnt;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if ((double)ary[i][j] > avg) {
                    if (ary[i][j] != -1) {
                        ary[i][j]--;
                    }
                } else if ((double)ary[i][j] < avg) {
                    if (ary[i][j] != -1) {
                        ary[i][j]++;
                    }

                }
            }
        }
        return ary;
    }

    private static void rotate(int x, int dir, int move) {
        while (move-- > 0) {
            if (dir == 0) {
                if (list[x].size() > 0) {
                    list[x].add(0, list[x].remove(list[x].size() - 1));
                }
            } else {
                if (list[x].size() > 0) {
                    list[x].add(list[x].remove(0));
                }
            }
        }
    }
}