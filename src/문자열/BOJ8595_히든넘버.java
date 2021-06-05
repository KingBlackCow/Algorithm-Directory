package 문자열;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ8595_히든넘버 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String tmp = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9) {
                tmp += str.charAt(i);
                if(tmp.length()>6){
                    tmp="";
                }
            } else if (!tmp.equals("")) {
                list.add(tmp);
                tmp = "";
            }
        }
        long sum = 0;
        if (tmp.length() > 0) { sum += Long.parseLong(tmp); tmp = ""; }
        for (int i = 0; i < list.size(); i++) {
            sum += Long.parseLong(list.get(i));
        }
        System.out.println(sum);
        bw.flush();
        bw.close();
        br.close();
    }


}
