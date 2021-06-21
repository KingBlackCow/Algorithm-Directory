package Map;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class BOJ4358_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Map<String,Integer> map = new TreeMap<>();

        double sum = 0.0;
        while (true){
            String str=br.readLine();
            if(str == null || str.length() == 0) {
                break;
            }
            map.put(str, map.getOrDefault(str,0)+1);
            sum++;
        }

        for (Map.Entry<String, Integer> cnt:map.entrySet()) {
            double a=cnt.getValue()/sum *100;
            String percent=String.format("%.4f", a);
            System.out.println(cnt.getKey()+" "+percent);
        }

        bw.flush();
        bw.close();
        br.close();
    }

}