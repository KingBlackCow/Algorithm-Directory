package 구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

class Programmers_메뉴리뉴얼 {

    static HashMap<String, Integer> map;

    public static void combi(String str, StringBuilder sb, int idx, int cnt, int n) {
        if (cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            combi(str, sb, i + 1, cnt + 1, n);
            sb.delete(cnt, cnt + 1);
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                if (course[i] <= orders[j].length())
                    combi(orders[j], sb, 0, 0, course[i]);
            }

            for (Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());

            }
            for (Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && entry.getValue() == max)
                    answer.add(entry.getKey());
            }
        }
        Collections.sort(answer);
        String[] answers = new String[answer.size()];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = answer.get(i);
        }
        return answers;
    }

    public static void main(String[] args) {
        //String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] orders ={"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String[] solution = solution(orders, course);
        for (String s : solution) {
            System.out.println(s);
        }
    }
}