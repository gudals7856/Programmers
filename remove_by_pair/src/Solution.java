import java.util.Stack;

class Solution {
    public int solution(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
            
            // 스택의 크기가 2 이상일 때만 진행
            while (st.size() >= 2) {
                char first = st.pop();
                char second = st.pop();

                // 스택의 가장 위 두개가 같을 경우
                if (first == second) {
                    continue;
                } else {    // 다를경우 다시 두 알파벳을 스택에 넣는다
                    st.push(second);
                    st.push(first);
                    break;
                }
            }
        }
        if (st.size() == 0) return 1;
        else return 0;
    }
}

/*
배열로 풀었을 때 코드

import java.util.ArrayList;

class Solution {
    public int solution(String s) {

        // 알파벳이 홀수 개 있을 땐 항상 불가능
        if (s.length() % 2 == 1) return 0;

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            list.add(s.charAt(i));

        for (int i = 0; i < list.size() - 1; i++) {

            // 현재 위치, 다음 위치의 알파벳이 같다면 제거
            if (list.get(i) == list.get(i + 1)) {
                list.remove(i + 1);
                list.remove(i);

                // 알파벳 제거 시 문자열 크기가 0이라면 1 리턴
                if (list.size() == 0) return 1;

                // i가 0일 땐 그 위치에서부터 다시 확인하기 위해 -1, 아니라면 그 전 위치부터 확인하기 위해 -2.
                if (i != 0) i -= 2;
                else i--;
            }
        }
        return 0;  // 중간에 끝나지 않았다면 무조건 불가능한 것.
    }
}
 */

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("baabaa");
        s.solution("cdcd");
    }
}