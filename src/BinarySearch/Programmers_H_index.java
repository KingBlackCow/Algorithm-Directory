package BinarySearch;

import java.util.Arrays;

class Programmers_H_index {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int left = 0;
        int right = 10000;
        while(left<=right){
            int mid = (left+right)/2;
            int cnt = 0;
            int namuge = 0;
            for(int i = 0; i < citations.length; i++){
                if(citations[i]>=mid){
                    cnt++;
                }else{
                    namuge++;
                }
            }
            if(cnt >= mid && namuge<= mid){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return right;
    }
}