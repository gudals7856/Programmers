// 두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면,
// T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다.
import java.util.Arrays;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        // 대기실 5개
        for (int i = 0; i < 5; i++) {
            // 대기실마다 배열 생성
            char[][] place = new char[5][5];
            for (int j = 0; j < 5; j++) {
                place[j][0] = places[i][j].charAt(0);
                place[j][1] = places[i][j].charAt(1);
                place[j][2] = places[i][j].charAt(2);
                place[j][3] = places[i][j].charAt(3);
                place[j][4] = places[i][j].charAt(4);
                System.out.println(Arrays.toString(place[j]));
            }
            answer[i] = check(place);
            System.out.println();
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    // 자리에 P가 있을 경우 거리두기 확인
    private int check(char[][] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i][j] == 'P') {
                    if (!isPossible(place, i, j))
                        return 0;
                }
            }
        }
        return 1;
    }

    // 거리두기 확인 함수
    // 현재 위치 : (r,c)
    private boolean isPossible(char[][] place, int r, int c) {
        int[][] distDiagonal = new int[][]{{-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
        int[][] distTwo = new int[][]{{0, -2}, {2, 0}, {0, 2}, {-2, 0}};
        int[][] distOne = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                // 자기 자신 위치는 확인 x
                if (i == 0 && j == 0) continue;

                // 파악하는 위치가 배열의 범위 내에 있다면
                if (r + i >= 0 && r + i < 5 && c + j >= 0 && c + j < 5) {
                    if (place[r + i][c + j] == 'P') {

                        // P 주위 상하좌우에 P가 있을 경우 false
                        if (i == -1 && j == 0 || i == 1 && j == 0 || i == 0) {
                            return false;
                        }

                        // P 주위 대각선 4방향에 P가 있을 경우 파티션이 없다면 false
                        for (int k = 0; k < 4; k++) {
                            if (i == distDiagonal[k][0] && j == distDiagonal[k][1]) {
                                if (place[r + distDiagonal[k][0]][c] == 'X' && place[r][c + distDiagonal[k][1]] == 'X') continue;
                                else return false;
                            }
                        }
                    }
                }
            }
        }
        // 현재위치에서 상하좌우 2번째 떨어진 칸 확인
        for (int i = 0; i < 4; i++) {
            if (r + distTwo[i][0] >= 0 && r + distTwo[i][0] < 5 && c + distTwo[i][1] >= 0 && c + distTwo[i][1] < 5) {

                // P가 있을 경우 사이에 파티션이 없다면 false
                if (place[r + distTwo[i][0]][c + distTwo[i][1]] == 'P') {
                    if (place[r + distOne[i][0]][c + distOne[i][1]] == 'X') continue;
                    else return false;
                }
            }
        }

        return true;    // 전부다 거리두기를 지키고 있음
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[][]
                {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
    }
}