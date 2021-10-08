package Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ23056_참가자명단 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> odd = new ArrayList<>();
        List<Student> even = new ArrayList<>();
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        Map<Integer, Integer> map = new HashMap<>();
        while (true) {
            String[] str = br.readLine().split(" ");
            int num = Integer.parseInt(str[0]);
            String name = str[1];

            if (num == 0 && name.equals("0")) break;
            int mapNum = map.getOrDefault(num, 0);
            if (mapNum < m) {
                if (num % 2 != 0) {
                    odd.add(new Student(num, name));
                } else {
                    even.add(new Student(num, name));
                }
                map.put(num, mapNum + 1);
            }
        }
        Collections.sort(odd);
        Collections.sort(even);
        for (Student student : odd) {
            System.out.println(student.num + " " + student.name);
        }
        for (Student student : even) {
            System.out.println(student.num + " " + student.name);
        }
    }

    static class Student implements Comparable<Student> {
        int num;
        String name;

        public Student(int num, String name) {
            this.num = num;
            this.name = name;
        }

        @Override
        public int compareTo(Student o) {
            if (this.num == o.num) {
                if (this.name.length() == o.name.length()) {
                    return this.name.compareTo(o.name);
                }
                return this.name.length() - o.name.length();
            }
            return Integer.compare(this.num, o.num);
        }
    }

}