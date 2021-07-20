package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20055_컨베이어벨트위의로봇 {
    static int n, k;
    static boolean[] visit;
    static int count = 0;
    static List<Integer> list = new LinkedList<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int visitSize = n * 2;
        visit = new boolean[visitSize];
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int ins = Integer.parseInt(st.nextToken());
            list.add(ins);
            if (ins == 0) {
                count++;
            }
        }
        int turn = 1;
        while (true) {
            visit = new boolean[n * 2];
            rotate();
            robotMove();
            robotLift();
            int tmp = check();
            if (tmp >= k) break;
            turn++;
        }
        System.out.println(turn);
    }

    private static int check() {
        int count = 0;
        for (Integer i : list) {
            if (i == 0) {
                count++;
            }
        }
        return count;
    }

    private static void robotLift() {
        int tmp = list.get(0);
        if (tmp == 0) return;
        q.add(0);
        tmp--;
        list.remove(0);
        list.add(0, tmp);
    }

    private static void robotMove() {
        int qSize = q.size();
        for (int i = 0; i < qSize; i++) {
            int tmp = q.poll();
            int tmpRobotLoc = tmp + 1;
            if (tmpRobotLoc == 2 * n) {
                tmpRobotLoc = 0;
            }
            if (tmpRobotLoc == n) {
                visit[tmp]=false;
                continue;
            }
            if (visit[tmpRobotLoc]) {
                q.add(tmp);
                visit[tmp] = true;
                continue;
            }
            int pivot = list.get(tmpRobotLoc);
            if (pivot > 0) {
                pivot--;
                list.remove(tmpRobotLoc);
                visit[tmp] = false;
                visit[tmpRobotLoc] = true;
                list.add(tmpRobotLoc, pivot);
                q.add(tmpRobotLoc);
            }else{
                q.add(tmp);
            }
        }
    }


    private static void rotate() {
        list.add(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        int qSize = q.size();
        for (int i = 0; i < qSize; i++) {
            int tmp = q.poll();
            tmp++;
            if (tmp == n * 2) {
                tmp = 0;
            }
            if (tmp == n) continue;
            q.add(tmp);
            visit[tmp] = true;
        }
    }


}