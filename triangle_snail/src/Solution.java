import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        int total = 0;
        for (int i = 1; i < n + 1; i++) total += i;

        int[] answer = new int[total];
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) arr[i] = new int[i + 1];

        arr[0][0] = 1;
        int r = 1, c = 0;
        int count = 2;
        while (count <= total) {
            System.out.println("r = " + r + "  c = " + c + "  count = " + count);
            if (r == c) {
                if (arr[r - 1][c - 1] != 0) arr[r++][c] = count;
                else arr[r--][c--] = count;
            } else if (r + 1 < n && arr[r + 1][c] == 0) {
                arr[r++][c] = count;
            } else if (c + 1 < n && arr[r][c + 1] == 0) {
                if ()
                arr[r][c++] = count;
            }
            count++;
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(6)));
    }
}