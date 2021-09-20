
/*
효율성 테스트 전부 실패
 */

class Solution6 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];


            // 현재 스킬이 공격일 때
            if (type == 1) {
                for (int r = r1; r <= r2; r++) {
                    for (int c = c1; c <= c2; c++) {
                        board[r][c] = board[r][c] - degree;
                    }
                }
            }

            // 현재 스킬이 회복일 때
            else {
                for (int r = r1; r <= r2; r++) {
                    for (int c = c1; c <= c2; c++) {
                        board[r][c] = board[r][c] + degree;
                    }
                }
            }
        }

        for (int j = 0; j < board.length; j++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[j][k] > 0) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();
        System.out.println(s.solution(new int[][] {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}},
                new int[][] {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}}));
    }
}