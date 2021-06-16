package 구현;

class Programmers_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i<n ;i ++){
            String str=Integer.toBinaryString(arr1[i]);
            while(str.length() < n){
                str="0"+str;
            }
            String str2=Integer.toBinaryString(arr2[i]);
            while(str2.length() < n){
                str2="0"+str2;
            }
            String tmp="";
            for(int j=0;j<n;j++){
                if(str.charAt(j)=='1'|| str2.charAt(j)=='1'){
                    tmp+= "#";
                }else{
                    tmp+=" ";
                }
            }
            answer[i]=tmp;
        }
        return answer;
    }
}
//나보다 효율적인코드
/*
class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
}
 */