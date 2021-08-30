package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ3079_입국심사 {
    static Long T, n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Long> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());

        for (int i = 0; i < n; i++) {
            list.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(list);
        long left = 0;
        long right = list.get(list.size() - 1) * m;

        while (left <= right) {
            Long mid = (left + right) / 2;
            long cnt = 0;
            for (Long i : list) {
                cnt += mid / i;
            }
            if (cnt >= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}