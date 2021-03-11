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
        int a=Integer.parseInt(br.readLine());
        int b=Integer.parseInt(br.readLine());
        int c=Integer.parseInt(br.readLine());
        int sum=a+b+c;
        if(a==60&&b==60&&c==60){
            System.out.println("Equilateral");
        }else if(sum==180&&((a==b)||(b==c)||(c==a))){
            System.out.println("Isosceles");
        }else if(sum==180){
            System.out.println("Scalene");
        }else{
            System.out.println("Error");
        }
    }

}
