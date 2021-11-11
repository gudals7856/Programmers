import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution4 {
    public int[] solution(String s) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);

        for (int i = 1; i < s.length(); i++) {
            // 현재 알파벳과 이전 알파벳이 같으면 list 마지막 원소에 + 1
            if (s.charAt(i - 1) == s.charAt(i)) {
                list.set(list.size() - 1, list.get(list.size() - 1) + 1);
            } else {    // 다르다면 list에 새로운 1을 추가
                list.add(1);
            }

            // s의 마지막 알파벳 확인
            if (i == s.length() - 1) {
                // 마지막과 처음 알파벳이 같다면
                if (s.charAt(i) == s.charAt(0)) {
                    list.set(0, list.get(0) + list.get(list.size() - 1));
                    list.remove(list.size() - 1);
                }
            }
        }
        Collections.sort(list);

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(Arrays.toString(s.solution("aaabbaaa")));
        System.out.println(Arrays.toString(s.solution("aaabbaab")));
    }
}

