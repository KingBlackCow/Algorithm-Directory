package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17140_이차원배열과연산 {
    static int ansX, ansY, ans;
    static int row = 4;
    static int col = 4;
    static int[][] ary;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ansX = Integer.parseInt(st.nextToken());
        ansY = Integer.parseInt(st.nextToken());
        ans = Integer.parseInt(st.nextToken());
        int turn = 0;
        ary = new int[4][4];
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (turn <= 100) {

            if (ansX<row&&ansY<col&&ary[ansX][ansY] == ans) {
                System.out.println(turn);
                System.exit(0);
            }
            if (row >= col) {
                ary = rowCheck();
            } else {
                ary = colCheck();
            }
            row = ary.length;
            col = ary[0].length;
            turn++;
        }
        System.out.println(-1);
    }

    private static int[][] rowCheck() {
        Map<Integer, Integer> map = new HashMap<>();
        List<Node>[] list = new ArrayList[row];
        for (int i = 1; i < row; i++) {
            list[i] = new ArrayList<>();
        }
        int max = 0;
        for (int i = 1; i < row; i++) {
            map.clear();
            for (int j = 1; j < ary[i].length; j++) {
                if (ary[i][j] == 0) continue;
                map.put(ary[i][j], map.getOrDefault(ary[i][j], 0) + 1);
            }
            for (Integer j : map.keySet()) {
                list[i].add(new Node(j, map.get(j)));
            }
            Collections.sort(list[i]);
            max = Math.max(max, list[i].size() * 2);
        }
        if (max > 100) max = 100;
        int[][] newMap = new int[row][max + 1];
        for (int i = 1; i < row; i++) {
            int cnt = 0;
            for (int j = 1; j <= max; j++) {
                if (cnt >= list[i].size()) break;
                if (j % 2 != 0) {
                    newMap[i][j] = list[i].get(cnt).num;
                } else {
                    newMap[i][j] = list[i].get(cnt).cnt;
                    cnt++;
                }

            }
        }
        return newMap;
    }

    private static int[][] colCheck() {
        Map<Integer, Integer> map = new HashMap<>();
        List<Node>[] list = new ArrayList[col + 1];
        for (int i = 1; i < col; i++) {
            list[i] = new ArrayList<>();
        }
        int max = 0;
        for (int i = 1; i < col; i++) {
            map.clear();
            for (int j = 1; j < ary.length; j++) {
                if (ary[j][i] == 0) continue;
                map.put(ary[j][i], map.getOrDefault(ary[j][i], 0) + 1);
            }
            for (Integer j : map.keySet()) {
                list[i].add(new Node(j, map.get(j)));
            }
            Collections.sort(list[i]);
            max = Math.max(max, list[i].size() * 2);
        }
        if (max > 100) max = 100;
        int[][] newMap = new int[max + 1][col];
        for (int i = 1; i < col; i++) {
            int cnt = 0;
            for (int j = 1; j <= max; j++) {
                if (cnt >= list[i].size()) break;
                if (j % 2 != 0) {
                    newMap[j][i] = list[i].get(cnt).num;
                } else {
                    newMap[j][i] = list[i].get(cnt).cnt;
                    cnt++;
                }

            }
        }
        return newMap;
    }

    static class Node implements Comparable<Node> {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (Integer.compare(this.cnt, o.cnt) == 0) {
                return Integer.compare(this.num, o.num);
            }
            return Integer.compare(this.cnt, o.cnt);
        }
    }

}