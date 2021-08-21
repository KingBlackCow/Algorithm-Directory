package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16401_과자나눠주기 {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st  = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] ary = new int[m];
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            ary[i] =Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);
        int left = 0;
        int right = ary[m-1];
        while (left<=right){
            int mid = (left+right)/2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if(mid != 0) {
                    cnt += ary[i] / mid;
                }
            }
            if(cnt>=n){
                left= mid+1;
            }else{
                right = mid-1;
            }
        }
        if(left<=0){
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(left-1);
    }
}

