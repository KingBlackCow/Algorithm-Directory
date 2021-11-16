package 구현;

class Programmers_기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int end = n;
        int pivot = 2 * w + 1;
        int low = 0;
        int high = 0;

        for(int i = 0; i < stations.length; i++){
            low = stations[i] - w - 1;
            high = stations[i] + w + 1;
            if(low >= start){
                int range = low - start;
                answer += range/pivot+1;
            }
            start = high;
        }
        if(high <= n){
            int range = end - high;
            answer += range/pivot + 1;
        }
        return answer;
    }
}