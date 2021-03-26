package KMP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ16172_나는친구가적다 {
    static int cnt=0;
    static List<Integer> list;
    static int[] getPi(String ptn) {
        int[] pi = new int[ptn.length()];
        int j=0;
        for(int i=1;i<ptn.length();i++) {
            while(j>0 && ptn.charAt(i)!=ptn.charAt(j)) {
                j=pi[j-1];
            }
            if(ptn.charAt(i)==ptn.charAt(j))
                pi[i]=++j;
        }
        return pi;
    }

    static void KMP(String org, String ptn) {
        int pi[] = getPi(ptn);
        int j=0;
        for(int i=0;i<org.length();i++) {
            if(org.charAt(i) >= '0' && org.charAt(i) <= '9')
                continue;
            while(j>0 && org.charAt(i)!=ptn.charAt(j)) {
                j = pi[j-1];
            }
            if(org.charAt(i)==ptn.charAt(j)) {
                if(j==ptn.length()-1) {
                    cnt=1;
                    list.add(i-j+1);
                    j=pi[j];
                }
                else
                    j++;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String pattern = br.readLine();
        list = new ArrayList<>();
        KMP(origin,pattern);
        System.out.println(cnt);

    }
}