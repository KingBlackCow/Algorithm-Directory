import java.util.ArrayList;
import java.util.List;


class Solution6 {

    static public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int turn = skill.length;
        while (turn-- > 0) {
            int point = skill[turn][0] == 1 ? -1 * skill[turn][5] : skill[turn][5];
            int sR = skill[turn][1];
            int sC = skill[turn][2];
            int eR = skill[turn][3];
            int eC = skill[turn][4];
            for (int i = sR; i <= eR; i++) {
                for (int j = sC; j <= eC; j++) {
                    board[i][j] += point;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]>0){
                    answer++;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int n = 5;
        int[][] board = new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = new int[][]{
                {1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}
        };

        System.out.println(solution(board, skill));
    }
}