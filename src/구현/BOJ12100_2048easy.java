package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ12100_2048easy {

    public static int n;
    public static int[][] map;
    static int max = 0;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> list = new ArrayList<>();
        move(map, 0, list);

        System.out.println(max);
    }

    private static void move(int[][] map, int turn, List<Integer> list) {
        if (turn >= 5) {
            int tmp = calc(map);
            if (max < tmp) {
                max = tmp;
            }
            //max = Math.max(max, calc(map));
            return;
        }
        turn++;
        List<Integer> list1 = new ArrayList<>(list);
        Queue<Integer> q = new LinkedList<>();
        //0 북쪽
        int[][] map2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[j][i] != 0) {
                    q.add(map[j][i]);
                }
            }
            int cnt = 0;
            while (!q.isEmpty()) {
                map2[cnt++][i] = q.poll();
            }
        }
        list1.add(0);
        fusion(map2, 0, turn, list1);
        list1.remove(list1.size() - 1);
        /////////////////////////
        //1 동쪽
        map2 = new int[n][n];
        q.clear();
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] != 0) {
                    q.add(map[i][j]);
                }
            }
            int cnt = n - 1;
            while (!q.isEmpty()) {
                map2[i][cnt--] = q.poll();
            }
        }
        list1.add(1);
        fusion(map2, 1, turn, list1);
        list1.remove(list1.size() - 1);
        ///////////////////////////
        //2 남쪽
        map2 = new int[n][n];
        q.clear();
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    q.add(map[j][i]);
                }
            }
            int cnt = n - 1;
            while (!q.isEmpty()) {
                map2[cnt--][i] = q.poll();
            }
        }
        list1.add(2);
        fusion(map2, 2, turn, list1);
        list1.remove(list1.size() - 1);
        //3 서쪽
        map2 = new int[n][n];
        q.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    q.add(map[i][j]);
                }
            }
            int cnt = 0;
            while (!q.isEmpty()) {
                map2[i][cnt++] = q.poll();
            }
        }
        list1.add(3);
        fusion(map2, 3, turn, list1);
        list1.remove(list1.size() - 1);
    }

    private static int calc(int[][] map) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }

    private static void fusion(int[][] map2, int dir, int turn, List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Deque<Integer> q = new ArrayDeque<>();
        int[][] map3 = new int[n][n];
        if (dir == 0) {
            for (int i = 0; i < n; i++) {
                if (map2[0][i] == 0) continue;
                stack.clear();
                boolean lock = false;
                //stack.add(map2[0][i]);
                for (int j = 0; j < n; j++) {
                    if (map2[j][i] == 0) break;
                    if (!stack.isEmpty() && (stack.peek() == map2[j][i]) && !lock) {
                        stack.add(2 * stack.pop());
                        lock = true;
                    } else {
                        stack.add(map2[j][i]);
                        lock = false;
                    }
                }
                int cnt = 0;
                while (!stack.isEmpty()) {
                    stack2.add(stack.pop());
                }
                while (!stack2.isEmpty()) {
                    q.add(stack2.pop());
                }
                while (!q.isEmpty()) {
                    map3[cnt++][i] = q.poll();
                }
            }
            move(map3, turn, list);
        } else if (dir == 1) {
            for (int i = 0; i < n; i++) {
                if (map2[i][n - 1] == 0) continue;
                stack.clear();
                boolean lock = false;
                //stack.add(map2[i][n - 1]);
                for (int j = n - 1; j >= 0; j--) {
                    if (map2[i][j] == 0) break;
                    if (!stack.isEmpty() && (stack.peek() == map2[i][j]) && !lock) {
                        stack.add(2 * stack.pop());
                        lock = true;
                    } else {
                        stack.add(map2[i][j]);
                        lock = false;
                    }
                }
                int cnt = n - 1;
                while (!stack.isEmpty()) {
                    stack2.add(stack.pop());
                }
                while (!stack2.isEmpty()) {
                    q.add(stack2.pop());
                }
                while (!q.isEmpty()) {
                    map3[i][cnt--] = q.poll();
                }
            }
            move(map3, turn, list);
        } else if (dir == 2) {
            for (int i = 0; i < n; i++) {
                if (map2[n - 1][i] == 0) continue;
                boolean lock = false;
                stack.clear();
                //stack.add(map2[n - 1][i]);
                for (int j = n - 1; j >= 0; j--) {
                    if (map2[j][i] == 0) break;
                    if (!stack.isEmpty() && (stack.peek() == map2[j][i]) && !lock) {
                        stack.add(stack.pop() * 2);
                        lock = true;
                    } else {
                        stack.add(map2[j][i]);
                        lock = false;
                    }
                }
                int cnt = n - 1;
                while (!stack.isEmpty()) {
                    stack2.add(stack.pop());
                }
                while (!stack2.isEmpty()) {
                    q.add(stack2.pop());
                }
                while (!q.isEmpty()) {
                    map3[cnt--][i] = q.poll();
                }
            }
            move(map3, turn, list);
        } else if (dir == 3) {
            for (int i = 0; i < n; i++) {
                boolean lock = false;
                if (map2[i][0] == 0) continue;
                stack.clear();
                //stack.add(map2[i][0]);
                for (int j = 0; j < n; j++) {
                    if (map2[i][j] == 0) break;
                    if (!stack.isEmpty() && (stack.peek() == map2[i][j]) && !lock) {
                        stack.add(2 * stack.pop());
                        lock = true;
                    } else {
                        stack.add(map2[i][j]);
                        lock = false;
                    }
                }
                int cnt = 0;
                while (!stack.isEmpty()) {
                    stack2.add(stack.pop());
                }
                while (!stack2.isEmpty()) {
                    q.add(stack2.pop());
                }
                while (!q.isEmpty()) {
                    map3[i][cnt++] = q.poll();
                }
            }
            move(map3, turn, list);
        }
    }


}