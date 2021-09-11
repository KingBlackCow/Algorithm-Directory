import java.util.ArrayList;
import java.util.List;


class Solution5 {
    static int peachPoint = 0;
    static int lionPoint = 0;
    static int maxDiff = -1;
    static boolean[] visit;
    static int[] lionInfo = new int[11];
    static int[] peachInfo = new int[11];
    static List<Integer> list = new ArrayList<>();
    static public int[] solution(int n, int[] info) {
        visit = new boolean[11];
        peachInfo = info;
        dfs(0, n);
        if (list.isEmpty()) return new int[]{-1};
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private static void dfs(int x, int n) {
        if (x == n) {
            peachPoint = 0;
            lionPoint = 0;
            for (int i = 0; i <= 10; i++) {
                if (lionInfo[i] > peachInfo[i]) {
                    lionPoint += 10 - i;
                } else if (lionInfo[i] != 0 || peachInfo[i] != 0) {
                    peachPoint += 10 - i;
                }
            }
            if (lionPoint > peachPoint) {
                int score = lionPoint - peachPoint;
                if (maxDiff < score) {
                    maxDiff = score;
                    list.clear();
                    for (Integer i : lionInfo) {
                        list.add(i);
                    }
                }
            }
            return;
        }
        for (int i = 0; i <= 10; i++) {
            if (lionInfo[i] > peachInfo[i] + 1) continue;
            lionInfo[i]++;
            dfs(x + 1, n);
            lionInfo[i]--;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] info = new int[]{2,1,1,1,0,0,0,0,0,0,0};
        int[] answer = solution(n, info);
        for (int i = 0; i < 11; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}