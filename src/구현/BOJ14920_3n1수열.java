package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ14920_3n1수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int turn = 0;
        while (n!=1){
            if(n%2==0){
                n/=2;
            }else{
                n=3*n+1;
            }
            turn++;
        }
        System.out.println(turn+1);
    }
}