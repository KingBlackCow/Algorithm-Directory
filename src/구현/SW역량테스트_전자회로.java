package 구현;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class SW역량테스트_전자회로 {
    static int n;
    static int[][] ary;
    static int maxCore;
    static int max;
    static int min;
    static boolean visit[][];
    static List<Node> list;
    static int listSize;
    static int res[];

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            ary = new int[n][n];
            visit = new boolean[n][n];
            maxCore = 0;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            list = new LinkedList<>();
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    ary[i][j] = sc.nextInt();
                    if (ary[i][j] == 1) {
                        if (i == 0 || j == 0)
                            continue;
                        list.add(new Node(i, j));

                    }
                }
            }

            listSize = list.size();
            res = new int[listSize];
            dfs(0, 0);
            System.out.println("#" + tc + " " + min);
        }
        System.exit(0);
    }

    private static void dfs(int x, int i) {
        if (x == listSize) {
            if (maxCore >= max) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (visit[j][k]) {
                            sum++;
                        }
                    }
                }
                if (maxCore > max) {
                    max = maxCore;
                    min = sum;
                } else if (maxCore == max) {
                    min = Math.min(min, sum);
                }
            }
            return;
        }

        Node tmp = list.get(i);
        for (int j = 0; j < 4; j++) {
            int r = tmp.x;
            int c = tmp.y;

            if (j == 0) {
                boolean able = true;
                while (r > 0) {
                    r--;
                    if (ary[r][c] == 1 || visit[r][c]) {
                        able = false;
                        break;
                    }
                }
                if (able) {
                    r = tmp.x;
                    while (r > 0) {
                        r--;
                        visit[r][c] = true;
                    }
                    maxCore++;
                }
                dfs(x + 1, i + 1);
                if (able) {
                    while (r < tmp.x) {
                        visit[r][c] = false;
                        r++;
                    }
                    maxCore--;
                }
            } else if (j == 1) {
                boolean able = true;
                while (c < n - 1) {
                    c++;
                    if (ary[r][c] == 1 || visit[r][c]) {
                        able = false;
                        break;
                    }
                }
                if (able) {
                    c = tmp.y;
                    while (c < n - 1) {
                        c++;
                        visit[r][c] = true;
                    }
                    maxCore++;
                }
                dfs(x + 1, i + 1);
                if (able) {
                    while (c > tmp.y) {
                        visit[r][c] = false;
                        c--;
                    }
                    maxCore--;
                }
            } else if (j == 2) {
                boolean able = true;
                while (r < n - 1) {
                    r++;
                    if (ary[r][c] == 1 || visit[r][c]) {
                        able = false;
                        break;
                    }
                }
                if (able) {
                    r = tmp.x;
                    while (r < n - 1) {
                        r++;
                        visit[r][c] = true;
                    }
                    maxCore++;

                }
                dfs(x + 1, i + 1);
                if (able) {
                    while (r > tmp.x) {
                        visit[r][c] = false;
                        r--;
                    }
                    maxCore--;
                }
            } else if (j == 3) {
                boolean able = true;
                while (c > 0) {
                    c--;
                    if (ary[r][c] == 1 || visit[r][c]) {
                        able = false;
                        break;
                    }
                }
                if (able) {
                    c = tmp.y;
                    while (c > 0) {
                        c--;
                        visit[r][c] = true;
                    }
                    maxCore++;

                }
                dfs(x + 1, i + 1);
                if (able) {
                    while (c < tmp.y) {
                        visit[r][c] = false;
                        c++;
                    }
                    maxCore--;
                }
            }
        }

    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
