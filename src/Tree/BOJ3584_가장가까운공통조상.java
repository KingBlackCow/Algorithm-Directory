package Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ3584_가장가까운공통조상 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> list[];
    static int n;
    static List<Integer> aList;
    static List<Integer> bList;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int f = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                list[s].add(f);
            }
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            aList = new ArrayList<>();
            bList = new ArrayList<>();
            dfs(first);
            dfs2(second);
            Collections.reverse(aList);
            Collections.reverse(bList);
            int min = Math.min(aList.size(), bList.size());
            int comm = aList.get(0);
            for (int i = 0; i < min; i++) {
                if (!aList.get(i).equals(bList.get(i))) {
                    break;
                }
                comm = bList.get(i);
            }
            sb.append(comm + "\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dfs(int x) {
        aList.add(x);
        for (Integer i : list[x]) {
            dfs(i);
        }
    }

    private static void dfs2(int x) {
        bList.add(x);
        for (Integer i : list[x]) {
            dfs2(i);
        }
    }
}