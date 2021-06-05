package 문자열;

import java.io.*;

public class BOJ3029_경고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] str1 = br.readLine().split(":");
        String[] str2 = br.readLine().split(":");
        int hour = Integer.parseInt(str2[0]) - Integer.parseInt(str1[0]);
        int min = Integer.parseInt(str2[1]) - Integer.parseInt(str1[1]);
        int sec = Integer.parseInt(str2[2]) - Integer.parseInt(str1[2]);
        if (hour == 0 && min == 0 && sec == 0) {
            System.out.println("24:00:00");
            System.exit(0);
        }
        if (sec < 0) {
            min -= 1;
            sec += 60;
        }
        if (min < 0) {
            hour -= 1;
            min += 60;
        }
        if (hour < 0) {
            hour += 24;
        }
        if (hour < 10) {
            sb.append("0");
        }
        sb.append(hour + ":");
        if (min < 10) {
            sb.append("0");
        }
        sb.append(min + ":");
        if (sec < 10) {
            sb.append("0");
        }
        sb.append(sec);
        System.out.println(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}