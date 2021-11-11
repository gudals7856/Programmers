public class Solution {
    public int solution(int[][] triangle) {
        func(triangle.length - 2, triangle);
        return triangle[0][0];
    }

    public void func(int depth, int[][] triangle) {
        if (depth == -1) return;

        for (int i = 0; i <= depth; i++) {
            triangle[depth][i] = Math.max(triangle[depth + 1][i] + triangle[depth][i], triangle[depth + 1][i + 1] + triangle[depth][i]);
        }
        func(depth - 1, triangle);
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}