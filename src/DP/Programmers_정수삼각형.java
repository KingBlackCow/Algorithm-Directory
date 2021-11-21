package DP;

class Programmers_정수삼각형 {
    static int[][] map;

    public static int solution(int[][] triangle) {
        int answer = 0;
        map = new int[triangle.length][triangle[triangle.length - 1].length];
        map[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    map[i][j] = map[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    map[i][j] = map[i - 1][j - 1] + triangle[i][j];
                } else {
                    map[i][j] = Math.max(map[i - 1][j], map[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }
        for (int i = 0; i < map[map.length - 1].length; i++) {
            answer = Math.max(answer, map[map.length - 1][i]);
        }
        return answer;
    }


    public static void main(String[] args) {

        int[][] triangles = new int[][]{
                {7}, {3, 8},
                {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
        };
        int name = solution(triangles);
        System.out.println(name);
    }
}
