package 문자열;

import java.io.*;
import java.util.*;

public class BOJ1342_행운의문자열 {

    static String str;
    static char [] stt;
    static boolean[] visit;
    static int size;
    static ArrayList<Character> list = new ArrayList<>();
    static int alpha[] = new int[26];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        for(int i=0; i<str.length(); i++) {
            alpha[str.charAt(i)-'a']++;
        }
        stt=new char[str.length()];
        visit = new boolean[str.length()];
        backtracking(0, ' ');

        for(int i=0; i<26; i++) {
            try {
                if(alpha[i] > 1) {
                    size /= factorial(alpha[i]);
                }
            }catch (Exception e){

            }
        }
        System.out.println(size);
    }

    private static void backtracking(int x, char past) {
        if (x == str.length()) {

            size++;

            return;
        }
        for (int i = 0; i < str.length(); i++) {

            if (!visit[i]&&str.charAt(i)!=past) {
                visit[i] = true;
                list.add(str.charAt(i));
                backtracking(x + 1, str.charAt(i));
                list.remove(list.size()-1);
                visit[i] = false;
            }
        }
    }

    public static int factorial(int N) {
        if(N==1)
            return 1;

        return N*factorial(N-1);
    }

}