
class Solution {
    public int solution(String name) {
        int answer = 0;
        int index = 0;

        char[] arrName = new char[name.length()];

        for (int i = 0; i < name.length(); i++)
            arrName[i] = name.charAt(i);

        for (int i = 0; i < name.length(); i++) {
            // 알파벳 이동횟수 (상하)
            answer += Math.min(arrName[0] - 'A', 'Z' - arrName[0] + 1);


        }
        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("JEROEN");
        s.solution("JAN");
    }
}