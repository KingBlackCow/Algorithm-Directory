package 문자열;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ10769_행복한지슬픈지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int happy = 0;
        int sad = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == ':') {
                if (s.charAt(i + 1) == '-') {
                    if (s.charAt(i + 2) == ')') {
                        happy++;
                    } else if (s.charAt(i + 2) == '(') {
                        sad++;
                    }
                }
            }
        }
        if (happy > sad) {
            System.out.println("happy");
        } else if (sad > happy) {
            System.out.println("sad");
        } else if (happy == sad && happy != 0 && sad != 0) {
            System.out.println("unsure");
        } else {
            System.out.println("none");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}