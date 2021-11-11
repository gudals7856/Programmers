import java.util.Arrays;

public class Solution1 {
    public int[] solution(int[] arr) {
        int[] answer = new int[3];
        int[] count = new int[3];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) count[0]++;
            else if (arr[i] == 2) count[1]++;
            else count[2]++;
        }

        int max = Math.max(count[0], Math.max(count[1], count[2]));

        for (int i = 0; i < 3; i++)
            answer[i] = max - count[i];

        return answer;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(Arrays.toString(s.solution(new int[]{2, 1, 3, 1, 2, 1})));
        System.out.println(Arrays.toString(s.solution(new int[]{3, 3, 3, 3, 3, 3})));
    }
}
