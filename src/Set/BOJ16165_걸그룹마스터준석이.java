package Set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class BOJ16165_걸그룹마스터준석이 {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<String> set[] = new HashSet[n];
        for (int i = 0; i < n; i++) {
            set[i] = new HashSet<>();
        }
        String[] girlGroupName = new String[n];
        for (int i = 0; i < n; i++) {
            girlGroupName[i] = br.readLine();
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                set[i].add(br.readLine());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            int mode = Integer.parseInt(br.readLine());
            if (mode == 1) {
                for (int j = 0; j < n; j++) {
                    if (set[j].contains(str)) {
                        sb.append(girlGroupName[j] + "\n");
                        break;
                    }
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (girlGroupName[j].equals(str)) {
                        List<String> list = new ArrayList<>(set[j]);
                        Collections.sort(list);
                        for (String name : list) {
                            sb.append(name + "\n");
                        }
                    }
                }

            }
        }
        System.out.println(sb.toString());

    }

}

