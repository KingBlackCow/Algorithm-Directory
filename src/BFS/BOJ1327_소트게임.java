package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1327_소트게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String permutation= "";
        for (int i = 0; i < n; i++) {
            permutation+=st.nextToken();
        }


        System.out.println(bfs(permutation, n, k));
    }

    private static int bfs(String sentence, int n, int k) {
        String result = sort(sentence);
        Set<String> set = new HashSet<>();

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sentence, 0));

        while (!q.isEmpty()) {
            Node data = q.poll();
            if (result.equals(data.sentence)) {
                return data.depth;
            }

            if (!set.contains(data.sentence)) {
                set.add(data.sentence);
                for (int i = 0; i <= n - k; i++) {
                    q.add(new Node(reverse(data.sentence, i, i + k), data.depth + 1));
                }
            }
        }

        return -1;
    }

    private static String sort(String permutation) {
        char[] sortArr = permutation.toCharArray();
        Arrays.sort(sortArr);
        return new String(sortArr);
    }

    private static String reverse(String str, int beginIndex, int endIndex) {
        StringBuilder reverse = new StringBuilder();
        String applyString = str.substring(beginIndex, endIndex);

        for(int i = applyString.length() - 1; i >= 0; i--) {
            reverse.append(applyString.charAt(i));
        }

        return str.substring(0, beginIndex) + reverse + str.substring(endIndex);
    }

    private static class Node {
        private String sentence;
        private int depth;

        private Node(String sentence, int depth) {
            this.sentence = sentence;
            this.depth = depth;
        }
    }
}