import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public String binaryTransform(int num) {
        StringBuilder sb = new StringBuilder();
        while (num >= 1) {
            int remain = num % 2;
            sb.insert(0, remain);
            num /= 2;
        }

        return sb.toString();
    }

    public int[] solution(String s) {
        int[] answer = new int[2];
        int transCount = 0;
        int deleteCount = 0;

        while (!s.equals("1")) {
            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') deleteCount++;
                else list.add('1');
            }
            int size = list.size();
            s = binaryTransform(size);
            transCount++;
        }
        answer[0] = transCount;
        answer[1] = deleteCount;

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution("110010101001")));
        System.out.println(Arrays.toString(s.solution("01110")));
    }
}