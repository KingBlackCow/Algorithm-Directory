package Math;

class Programmers_숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        int left = 0;
        int right = 1;
        while(left<n){
            if(op(right)-op(left)<n){
                right++;
            }else if(op(right)-op(left)>n){
                left++;
            }else{
                answer++;
                left++;
                right++;
            }
        }
        return answer;
    }

    static int op(int n){
        return (n+1)*n/2;
    }
}