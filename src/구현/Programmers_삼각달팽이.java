package 구현;

class Programmers_삼각달팽이 {
    public int[] solution(int n) {
        int[] answer = {};
        int[][] map = new int[n][n];
        int cnt = 1;
        int turn = n;
        int x = 0;
        int y = 0;
        int flag = 0;
        while(turn>0){
            if(flag%3==0){

                for(int i = 0; i < turn; i++){
                    map[x++][y] = cnt++;
                }
                x--;
            }

            else if(flag%3==1){
                y++;
                for(int i = 0; i < turn; i++){
                    map[x][y++] = cnt++;
                }
                y--;
            }
            else if(flag%3==2){
                x--; y--;
                for(int i = 0; i < turn; i++){
                    map[x--][y--] = cnt++;
                }
                x++; y++; x++;
            }
            turn--;
            flag++;
        }

        answer= new int[cnt-1];
        cnt = 0;
        turn = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j<= cnt;j++){
                answer[turn++] = map[i][j];
            }
            cnt++;
        }
        return answer;
    }
}