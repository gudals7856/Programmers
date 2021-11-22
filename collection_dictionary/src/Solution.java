/*
프로그래머스 - 모음사전
https://programmers.co.kr/learn/courses/30/lessons/84512
 */

class Solution {

    static int count;
    static int answer;

    public int solution(String word) {
        char[] arr = new char[] {'A', 'E', 'I' ,'O', 'U'};

        for (char c : arr) {
            search(word, arr, new StringBuilder(Character.toString(c)));
        }

        return answer;
    }

    public void search(String word, char[] arr, StringBuilder sb) {
        count++;
        if (sb.toString().equals(word)) answer = count;
        if (sb.length() == 5) return;

        for (char c : arr) {
            sb.append(c);
            search(word, arr, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}

class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("AAAAE"));
    }
}