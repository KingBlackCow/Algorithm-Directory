package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1644_소수의연속합 {

    static boolean prime[];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        prime = new boolean[n+1];
        prime[0] = prime[1] = true;
        for(int i=2; i*i<=n; i++){
            if(!prime[i]) {
                for(int j=i*i; j<=n; j+=i) {
                    prime[j]=true;
                }
            }
        }
        for(int i=1; i<=n;i++){
            if(!prime[i]){
                list.add(i);
            }
        }

        int start=0, end=0, sum=0, cnt=0;
        while (true){
            if(sum>=n){
                sum-=list.get(start++);
            }else if(end==list.size()){
                break;
            }else{
                sum+=list.get(end++);
            }
            if(n==sum)cnt++;
        }
        System.out.println(cnt);
    }
}