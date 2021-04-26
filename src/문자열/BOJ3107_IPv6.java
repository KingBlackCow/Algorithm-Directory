package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ3107_IPv6 {
    static boolean first = false;
    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[9];
        Arrays.fill(s, "");
        String[] str2 = br.readLine().split(":");
        boolean flag2 = false;
        int str2Count=0;
        for (int i = 0; i < str2.length; i++) {
            if (str2[i].equals("") && !flag2) {
                flag2 = true;
                s[i] += str2[str2Count++];
                continue;
            }
            if (!str2[i].equals("")) {
                s[i] += str2[str2Count];
            } else {
                str2Count++;
                s[i] += str2[str2Count];
            }
            str2Count++;
            if(str2Count>=str2.length)break;
        }
        for (int i = 0; i < 8; i++) {
            if (s[i].equals("") && !first) {
                first = true;
                list.add(s[i]);
                continue;
            }
            if (!s[i].equals("")) {
                list.add(s[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String tmp = "";
            int zeroCount = 4 - str.length();
            if (str.equals("")) {
                for (int j = 0; j < 8 - list.size() + 1; j++) {
                    sb.append("0000:");
                }
            } else {
                for (int j = 0; j < zeroCount; j++) {
                    tmp += "0";
                }
                tmp += str;
                sb.append(tmp + ":");
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}