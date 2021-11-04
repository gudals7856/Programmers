import java.util.ArrayList;

class Solution {

    static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean[][] board;
    static boolean[] check;
    static int answer;
    static int N;

    // 체스판 내의 모든 퀸을 확인
    public boolean checkBoard(Pair[] queens) {
        for (int i = 0; i < N - 1; i++) {
            Pair q1 = queens[i];

            for (int j = i + 1; j < N; j++) {
                Pair q2 = queens[j];

                // 두 퀸이 대각선에 있는 경우
                if (Math.abs(q1.r - q2.r) == Math.abs(q1.c - q2.c)) return true;
            }
        }

        return false;
    }

    // 퀸 배치
    public void arrangeQueen(int r, Pair[] queens) {
        if (r == N) {
            if (!checkBoard(queens)) answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            // 같은 세로 선상에 있는 경우는 퀸을 배치하지 않음
            if (!check[i]) {
                board[r][i] = true;
                check[i] = true;
                queens[r] = new Pair(r, i);

                arrangeQueen(r + 1, queens);

                board[r][i] = false;
                check[i] = false;
                queens[r] = null;
            }
        }
    }

    public int solution(int n) {
        board = new boolean[n][n];
        check = new boolean[n];
        N = n;
        Pair[] queens = new Pair[N];
        for (int i = 0; i < N; i++) queens[i] = null;

        arrangeQueen(0, queens);

        return answer;
    }
}
class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(12));
    }
}
