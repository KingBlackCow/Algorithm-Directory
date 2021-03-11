import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main3 {
    static int n;
    static boolean[] ary;
    static boolean[] visit;
    static List<Integer> list[];

    static int P[];
    static boolean finished[];
    static int res=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int year=1;
        int aTmp=1;
        int bTmp=1;
        int cTmp=1;
        while (aTmp!=a||bTmp!=b||cTmp!=c) {
            year++;
            aTmp++;
            bTmp++;
            cTmp++;
            if(aTmp==16)aTmp=1;
            if(bTmp==29)bTmp=1;
            if(cTmp==20)cTmp=1;
        }
        System.out.println(year);
    }

}
