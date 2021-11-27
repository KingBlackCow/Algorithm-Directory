package Greedy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Programmers_구명보트 {
    public static int solution(int[] people, int limit) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(people);
        for (int i = 0; i < people.length; i++) {
            list.add(people[i]);
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>(list);
        int ans = 0;
        while (!dq.isEmpty()) {
            int weight = dq.pollLast();
            if (!dq.isEmpty() && weight + dq.peekFirst() <= limit) {
                dq.pollFirst();
            }
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        //int[] people ={70,50,80,50};
        int[] people = {70, 80, 50};
        int limit = 100;
        int solution = solution(people, limit);
        System.out.println(solution);
    }
}