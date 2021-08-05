package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1270_전쟁땅따먹기 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pivot = Integer.parseInt(st.nextToken());
            boolean flag = true;
            while (st.hasMoreTokens()) {
                int cnt = Integer.parseInt(st.nextToken());
                int cntPivot = map.getOrDefault(cnt,0)+1;
                if(cntPivot>pivot/2){
                    sb.append(cnt + "\n");
                    flag = false;
                    break;
                }
                map.put(cnt, cntPivot);
            }
            if (flag) {
                sb.append("SYJKGW\n");
            }
            map.clear();
        }
        System.out.println(sb.toString());
    }
}



