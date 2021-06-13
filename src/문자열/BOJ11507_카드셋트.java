package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ11507_카드셋트 {
    static int p,k,h,t;
    static long[] ary;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set=new HashSet<>();
        String str=br.readLine();
        String tmp="";
        p=k=h=t=13;
        for (int i = 0; i < str.length(); i++) {
            tmp+=str.charAt(i);
            if(i%3==2){
                if(set.contains(tmp)){
                    System.out.println("GRESKA");
                    System.exit(0);
                }
                if(tmp.charAt(0)=='P'){
                    p--;
                }else if(tmp.charAt(0)=='K'){
                    k--;
                }else if(tmp.charAt(0)=='H'){
                    h--;
                }else if(tmp.charAt(0)=='T'){
                    t--;
                }
                set.add(tmp);
                tmp="";
            }
        }
        System.out.println(p+" "+k+" "+h+" "+t);


    }

}