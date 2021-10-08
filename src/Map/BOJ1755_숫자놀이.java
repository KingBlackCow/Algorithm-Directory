package Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BOJ1755_숫자놀이 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, String> map = new HashMap<>();
        map.put('0', "zero");
        map.put('1', "one");
        map.put('2', "two");
        map.put('3', "three");
        map.put('4', "four");
        map.put('5', "five");
        map.put('6', "six");
        map.put('7', "seven");
        map.put('8', "eight");
        map.put('9', "nine");
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = n; i <= m; i++){
            String number = String.valueOf(i);
            int len = 0;
            String s = "";
            while (len < number.length()){
                s += map.get(number.charAt(len++));
            }
            pq.add(new Node(i,s));
        }
        int cnt = 0;
        while (!pq.isEmpty()){
            System.out.print(pq.poll().num);
            cnt++;
            if(cnt==10){
                System.out.println();
                cnt = 0;
            }else{
                System.out.print(" ");
            }
        }

    }

    static class Node implements Comparable<Node>{
        int num;
        String name;

        public Node(int num, String name) {
            this.num = num;
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return this.name.compareTo(o.name);
        }
    }
}