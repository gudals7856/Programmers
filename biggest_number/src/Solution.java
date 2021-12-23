import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            strArr[i] = Integer.toString(numbers[i]);

        Arrays.sort(strArr, (o1, o2) -> {
            if (Integer.parseInt(o1 + o2) <= Integer.parseInt(o2 + o1)) {
                return 0;
            }
            return -1;
        });

        if (strArr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : strArr) sb.append(s);

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{6, 10, 2, 22, 21}));
        System.out.println(s.solution(new int[]{0, 0, 0, 0, 0}));
        System.out.println(s.solution(new int[]{0, 0, 1, 0, 0}));
        System.out.println(s.solution(new int[]{3, 30, 34, 5, 9}));
    }
}