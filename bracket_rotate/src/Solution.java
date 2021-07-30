import java.util.*;

class Solution {

    public static void main(String[] args) {
        String s = "}]()[{";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;
        int c1 = 0;
        int c2 = 0;
        char wantC;
        Queue<Character> q = new LinkedList<>();
        Stack<Character> st = new Stack<>();

        // 큐에 문자열을 하나씩 삽입
        for (int i = 0; i < s.length(); i++) {
            char nowC = s.charAt(i);
            if (nowC == '(') {
                st.push(')');
                c1++;
            }
            else if (nowC == '{') {
                st.push('}');
                c1++;
            }
            else if (nowC == '[') {
                st.push(']');
                c1++;
            }

            if (nowC == ')' || nowC == '}' || nowC == ']') {
                if (!st.isEmpty()) {
                    if (nowC == st.peek())
                        st.pop();
                }
                c2++;
            }
            q.offer(nowC);
        }

        // 열고 닫는 괄호의 개수가 서로 같지 않으면 0 return
        if (c1 != c2)
            return answer;

        for (int i = 0; i < s.length(); i++) {
            char c = q.poll();

            // 만약 큐에서 빼낸 괄호가 올바른 괄호를 위한 괄호라면 스택에서 pop
            if (!st.isEmpty()) {
                wantC = st.peek();
                if (c == wantC)
                    st.pop();
            }

            if (c == '(') {
                st.push(')');
            }
            else if (c == '{') {
                st.push('}');
            }
            else if (c == '[') {
                st.push(']');
            }
            q.add(c);

            // 스택이 비어있다면 answer 증가
            if (st.isEmpty())
                answer++;
        }
        return answer;
    }

}