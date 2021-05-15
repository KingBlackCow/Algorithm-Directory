package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13116_30번 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            listA.add(a);
            listB.add(b);
            while (a > 1) {
                if (a % 2 != 0) {
                    a--;
                }
                a /= 2;
                listA.add(a);
            }
            while (b > 1) {
                if (b % 2 != 0) {
                    b--;
                }
                b /= 2;
                listB.add(b);
            }
            Collections.sort(listA);
            Collections.sort(listB);
            int size = listA.size() > listB.size() ? listB.size() : listA.size();
            int max = 1;
            for (int j = 0; j < size; j++) {
                if (Integer.compare(listA.get(j),listB.get(j))!=0) {
                    break;
                }
                max = listA.get(j);
            }
            System.out.println(max * 10);
            listA.clear();
            listB.clear();
        }

    }

}
