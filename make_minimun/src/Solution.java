import java.util.Arrays;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        int size = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < size; i++) {
            answer += A[i] * B[size - 1 - i];
        }

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(s.solution(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(s.solution(new int[]{1, 2, 5, 9}, new int[]{8, 7, 5, 1}));
    }
}