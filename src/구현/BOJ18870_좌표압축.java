package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class BOJ18870_좌표압축 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(input[i]);
        }
        int[] nums=ary.clone();
        Arrays.sort(nums);
        Map<Integer,Integer> map=new HashMap<>();
        int idx=0;
        for (Integer num : nums)
            if(!map.containsKey(num))
                map.put(num,idx++);
        StringBuilder sb = new StringBuilder();
        for (Integer i:ary) {
            sb.append(map.get(i)).append(' ');
        }
        System.out.println(sb.toString());
    }
}