package Map;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ2358_평행선 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;

        try {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Integer> x = new HashMap<Integer, Integer>();
            Map<Integer, Integer> y = new HashMap<Integer, Integer>();

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int input_x = Integer.parseInt(st.nextToken());
                int input_y = Integer.parseInt(st.nextToken());
                x.put(input_x,x.getOrDefault(input_x,0)+1);
                y.put(input_y, y.getOrDefault(input_y,0) + 1);
            }

            for(int key : x.keySet()) {
                if(x.get(key) > 1) count++;
            }

            for(int key : y.keySet()) {
                if(y.get(key) > 1) count++;
            }

            bw.write(String.valueOf(count));
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}