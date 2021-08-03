package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4999_아 {
    static String n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = (br.readLine());
        m = (br.readLine());
        if(n.length()>=m.length()){
            System.out.println("go");
        }else{
            System.out.println("no");
        }
    }}

