import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public String solution(String number, int k) {
        String answer = "";
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> delete = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int count = 0;

        for (int i = 0; i < number.length(); i++) {
            num.add(Character.getNumericValue(number.charAt(i)));
        }

        st.push(0);
        for (int i = 1; i < number.length(); i++) {
            while (!st.isEmpty()) {
                // 스택의 가장 위에 있는 수보다 현재 수가 더 크다면 스택에서 값을 빼며 비교
                if (num.get(i) > num.get(st.peek())) {
                    delete.add(st.pop());
                    count++;
                    if (count == k) break;
                } else {    // 스택의 가장 위 수가 현재 수와 같거나 작다면 다음 수로 진행
                    break;
                }
            }
            if (count == k) break;
            st.push(i);
        }

        // 수가 계속 줄어들면 (7654321 같은 경우엔 delete에 아무것도 안들어감.)
        // 뒤에서부터 delete에 삽입해준다.
        if (count < k) {
            int n = num.size();
            for (int i = n - 1; i > n - 1 - (k - count); i--) {
                delete.add(i);
            }
        }

        // delete배열 내의 수들을 -1로 바꿈
        for (int i = 0; i < delete.size(); i++) num.set(delete.get(i), -1);

        // num에 있는 수 중 -1이 아닌 것을 이어붙임
        StringBuilder sb = new StringBuilder("");
        for (Integer i : num) if (i != -1) sb.append(i);
        answer = sb.toString();

        System.out.println(answer);

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("1924", 2);
        solution.solution("1231234", 3);
        solution.solution("4177252841", 4);
        solution.solution("7777765432", 3);
    }
}