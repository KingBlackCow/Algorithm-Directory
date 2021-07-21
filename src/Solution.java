import java.util.*;

public class Solution {
    public static Integer[] solution(int []arr) {

        List<Integer> list = new ArrayList<>();
        int pivot = 0;
        for(int i = 0; i<arr.length;i++){
            if(pivot!=arr[i]){
                list.add(arr[i]);
                pivot = arr[i];
            }
        }
        Integer[] answer = list.toArray(new Integer[list.size()]);

        return answer;
    }

    public static void main(String[] args) {
        Integer[] arr=solution(new int[]{1,1,3,3,0,1,1});
    }
}