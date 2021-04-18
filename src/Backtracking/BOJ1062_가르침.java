package Backtracking;

import java.io.*;
import java.util.*;

public class BOJ1062_가르침 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static Set<Character> set = new HashSet<>();
    static List<Character> list;
    static Stack<Character> stack;
    static List<String> sentence;
    static int res = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sentence = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            sentence.add(str);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'a' || str.charAt(j) == 'n' || str.charAt(j) == 't'
                        || str.charAt(j) == 'i' || str.charAt(j) == 'c') {
                    continue;
                }
                set.add(str.charAt(j));
            }
        }
        list = new ArrayList<>(set);
        stack = new Stack<>();

        dfs(0, 0);
        if(m<5) System.out.println(0);
        else System.out.println(max);
        bw.close();
        br.close();
    }

    private static void dfs(int x, int cnt) {
        if (x == m-5 || x == list.size()) {
            res = 0;
            Set<Character> set2 = new HashSet<>(stack);
            for (int i = 0; i < sentence.size(); i++) {
                String str = sentence.get(i);
                boolean flag = true;
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == 'a' || str.charAt(j) == 'n' || str.charAt(j) == 't'
                            || str.charAt(j) == 'i' || str.charAt(j) == 'c') {
                        continue;
                    }
                    if (!set2.contains(str.charAt(j))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res++;
                }
            }
            max = Math.max(max, res);
            return;
        }
        for (int i = cnt; i < list.size(); i++) {
            stack.add(list.get(i));
            dfs(x + 1, i + 1);
            stack.pop();
        }
    }
}