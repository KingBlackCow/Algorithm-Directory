package 구현;

class Programmers_n2배열자르기 {
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left+1)];
        int cnt = 0;
        left--;
        while (++left<=right) {
            answer[cnt++]=((int) (Math.max(left/n,left%n)+1));
        }
        return answer;
    }
}