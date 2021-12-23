import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean solution(String s) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') {
                q.add(s.charAt(i));
            } else {
                if (q.isEmpty()) return false;
                else q.poll();
            }
        }
        return q.isEmpty();
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("()()"));
        System.out.println(s.solution("(())()"));
        System.out.println(s.solution(")()("));
    }
}