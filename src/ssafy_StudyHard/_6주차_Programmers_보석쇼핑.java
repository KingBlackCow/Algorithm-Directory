package ssafy_StudyHard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class _6주차_Programmers_보석쇼핑 {
    static Queue<String> q = new LinkedList<String>();
    static HashSet<String> set = new HashSet<String>();
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    static int Point = 0;
    static int length = Integer.MAX_VALUE;
    public static int[] solution(String[] gems) {
        int[] answer;
        for(String g : gems) {
            set.add(g);
        }
        int start = 0;
        for(int i = 0; i < gems.length; i++) {
            if(!map.containsKey(gems[i])) map.put(gems[i], 1);
            else map.put(gems[i], map.get(gems[i]) + 1);
            q.add(gems[i]);

            while(true) {
                String temp = q.peek();
                if(map.get(temp) > 1) {
                    map.put(temp, map.get(temp) - 1);
                    q.poll();
                    Point++;
                }
                else {
                    break;
                }
            }

            if(map.size() == set.size() && length > q.size()) {
                length = q.size();
                start = Point;
            }
        }
        return new int[]{start + 1, start + length};
    }
}