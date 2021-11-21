package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Programmers_여행경로 {
    static List<Node> nodes;
    static boolean[] visit;
    static List<Integer> startList;
    static List<String> res;
    static int maxDepth;
    static boolean success;

    public static String[] solution(String[][] tickets) {
        nodes = new ArrayList<>();
        startList = new ArrayList<>();
        res= new ArrayList<>();
        res.add("ICN");
        maxDepth = tickets.length;
        for (int i = 0; i < tickets.length; i++) {
            nodes.add(new Node(tickets[i][0], tickets[i][1]));
        }

        Collections.sort(nodes);
        success = false;
        for (int i = 0; i < nodes.size(); i++) {
            if(success)break;
            if (nodes.get(i).start.equals("ICN")) {
                visit = new boolean[nodes.size()];
                visit[i] = true;
                dfs(nodes.get(i), 1, nodes.get(i).end+" ");
            }
        }

        return res.toArray(new String[res.size()]);
    }

    private static void dfs(Node node, int depth, String strs) {
        if (maxDepth == depth) {
            success = true;
            String[] str = strs.split(" ");
            for (String s: str) {
                res.add(s);
            }
            return;
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (visit[i]) continue;
            if (node.end.equals(nodes.get(i).start)) {
                visit[i] = true;
                if (!success) {
                    dfs(nodes.get(i), depth + 1, strs + nodes.get(i).end+" ");
                }
                visit[i] = false;
            }
        }
    }

    static class Node implements Comparable<Node> {
        String start;
        String end;

        public Node(String start, String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.end.compareTo(o.end);
        }
    }

    public static void main(String[] args) {
//        String[][] tickets = new String[][]{
//                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
//        };
        String[][] tickets = new String[][]{
                {"ICN", "SFO"},
                {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}
        };
        String[] name = solution(tickets);
        for (int i = 0; i < name.length; i++) {
            System.out.print(name[i]+" ");
        }
    }
}
