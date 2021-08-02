import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static class Car {
        int first;
        int second;
        int dir;
        int val;
        Car(int a, int b, int dir, int val) {
            this.first = a;
            this.second = b;
            this.dir = dir;
            this.val = val;
        }
    }

    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] check;
    static Queue<Car> q = new LinkedList<>();

    public static void main(String[] args) {

        int[][] board1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] board2 = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        int[][] board3 = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        int[][] board4 = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}};
        int[][] board5 = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 1, 0, 0}, {1, 0, 0, 0, 1}, {0, 1, 1, 0, 0}};

//        System.out.println(solution(board1));
//        System.out.println(solution(board2));
//        System.out.println(solution(board3));
//        System.out.println(solution(board4));
        System.out.println(solution(board5));
    }


    // 오른쪽:1, 아래:2, 왼쪽:3, 위:4
    public static int solution(int[][] board) {
        int answer = 0;

        check = new int[board.length][board.length]; //최소값이 들어감
        for (int[] ints : check) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        if (board[0][1] == 0) {
            q.add(new Car(0, 1, 1, 100));
            check[0][1] = 100;
        }

        if (board[1][0] == 0) {
            q.add(new Car(1, 0, 2, 100));
            check[1][0] = 100;
        }

        answer = bfs(board);

        return answer;
    }

    public static int bfs(int[][] board) {

        while (!q.isEmpty()) {
            Car now = q.poll();
            checkBoard(now, board);
        }
        return check[check.length - 1][check.length - 1];
    }

    public static void checkBoard(Car now, int[][] board) {
        int nowDir = now.dir;
        int nextRow = 0;
        int nextCol = 0;

        for (int dir = 1; dir < 5; dir++) {
            nextRow = now.first + direction[dir - 1][0];
            nextCol = now.second + direction[dir - 1][1];

            if (nextCol < 0 || nextRow < 0 || nextCol >= board.length || nextRow >= board.length) continue;

            if (board[nextRow][nextCol] == 0) {
                int value;
                if (nowDir == dir) {
                    value = now.val + 100;
                } else {
                    value = now.val + 600;
                }
                if (value <= check[nextRow][nextCol]) {
                    check[nextRow][nextCol] = value;
                    q.add(new Car(nextRow, nextCol, dir, value));
                }
            }
        }
    }
}