package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ1076_저항 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,String> map=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();
        map.put("black","0");
        map2.put("black",1);

        map.put("brown","1");
        map2.put("brown",10);

        map.put("red","2");
        map2.put("red",100);

        map.put("orange","3");
        map2.put("orange",1000);

        map.put("yellow","4");
        map2.put("yellow",10000);

        map.put("green","5");
        map2.put("green",100000);

        map.put("blue","6");
        map2.put("blue",1000000);

        map.put("violet","7");
        map2.put("violet",10000000);

        map.put("grey","8");
        map2.put("grey",100000000);

        map.put("white","9");
        map2.put("white",1000000000);
        String a=map.get(br.readLine());
        String b=map.get(br.readLine());
        long c=map2.get(br.readLine());
        System.out.println(Integer.parseInt(a+b)*c);

    }
}