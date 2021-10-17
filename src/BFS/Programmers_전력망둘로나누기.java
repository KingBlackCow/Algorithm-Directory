package BFS;

import java.util.*;

class Programmers_전력망둘로나누기 {
    static boolean[] visit;
    static List<Integer>[] list;
    static int max = 0;
    public int solution(int n, int[][] wires) {
        int answer = 987654321;
        int ans = 0;
        list = new ArrayList[n+1];

        for(int i = 1; i < n; i++){
            for(int k = 1; k <= n; k++){
                list[k] = new ArrayList<>();
            }
            for(int j = 0; j < wires.length; j++){
                if(i-1==j)continue;
                list[wires[j][0]].add(wires[j][1]);
                list[wires[j][1]].add(wires[j][0]);
            }

            List<Integer> tmp = new ArrayList<>();
            visit = new boolean[n+1];
            for(int j = 1; j <=n; j++){
                if(!visit[j]){
                    max = bfs(j, 0);
                    tmp.add(max);
                }
            }
            Collections.sort(tmp);
            answer = Math.min(answer, tmp.get(1)-tmp.get(0));
        }

        return answer;
    }

    static int bfs(int x, int floor){
        visit[x] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        int turn = 1;
        while(!q.isEmpty()){
            int cnt = q.poll();
            for(Integer i: list[cnt]){
                if(!visit[i]){
                    visit[i] = true;
                    turn++;
                    q.add(i);
                }
            }
        }
        return turn;
    }
}