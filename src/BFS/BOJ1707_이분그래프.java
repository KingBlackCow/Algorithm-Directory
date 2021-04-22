package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1707_이분그래프 {
    static boolean res;
    static boolean[] visit;
    static List<Integer>[] list;
    static String[] color;
    static int v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            res = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            visit = new boolean[v + 1];
            list = new ArrayList[v + 1];
            color = new String[v + 1];
            for (int j = 1; j < v + 1; j++) {
                list[j] = new ArrayList<>();
            }
//            st = new StringTokenizer(br.readLine());
//            int first = Integer.parseInt(st.nextToken());
//            int second = Integer.parseInt(st.nextToken());
//            list[first].add(second);
//            list[second].add(first);
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int one = Integer.parseInt(st.nextToken());
                int two = Integer.parseInt(st.nextToken());
                list[one].add(two);
                list[two].add(one);
            }

            if (bfs())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    static boolean bfs(){
        boolean flag = true;
        int[] visit = new int[v + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < v + 1; i++) {
            if (visit[i] == 0) {
                q.offer(i);
                visit[i] = 1;
                while (!q.isEmpty() && flag) {
                    int cnt = q.poll();
                    for (Integer next : list[cnt]) {
                        if (visit[next] == 0) {
                            q.offer(next);
                            visit[next] = visit[cnt] * -1;
                        } else if (visit[next] == visit[cnt]) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
        }
        return flag;
    }
}