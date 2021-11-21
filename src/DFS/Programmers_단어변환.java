package DFS;

import java.util.HashSet;
import java.util.Set;

class Programmers_단어변환 {
    static int res = Integer.MAX_VALUE;
    static String last;
    static Set<String> set = new HashSet<>();

    public static int solution(String begin, String target, String[] words) {
        boolean existFlag = false;
        last = target;
        for (String word : words) {
            if (word.equals(target)) {
                existFlag = true;
                break;
            }
        }
        if (!existFlag) return 0;
        set.add(begin);
        dfs(begin, 0,words);
        if(res== Integer.MAX_VALUE){
            return 0;
        }
        return res;
    }

    private static void dfs(String x, int floor, String[] words) {
        if (x.equals(last)) {
            res = Math.min(floor, res);
            return;
        }
        for (String word : words) {
            if (set.contains(word)) continue;
            if (diffOne(x, word)) {
                set.add(word);
                dfs(word, floor + 1,words);
                set.remove(word);
            }
        }
    }

    private static boolean diffOne(String x, String word) {
        int diffSize = 0;
        for (int i = 0; i < x.length(); i++) {
            if (word.charAt(i) != x.charAt(i)) {
                diffSize++;
            }
        }
        return diffSize == 1 ? true : false;
    }


    public static void main(String[] args) {
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        int name = solution("hit", "cog", words);
        System.out.println(name);
    }
}