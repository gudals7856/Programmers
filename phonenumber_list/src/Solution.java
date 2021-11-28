/*
프로그래머스 - 전화번호 목록
https://programmers.co.kr/learn/courses/30/lessons/42577
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public boolean solution(String[] phone_book) {
        List<String> list = new ArrayList<>(Arrays.asList(phone_book));
        Collections.sort(list);
        
        // 수들을 사전순으로 배열
        for (int i = 0; i < list.size() - 1; i++) {
            String str1 = list.get(i);
            String str2 = list.get(i + 1); // str1 뒤에 있는 수만 확인하면 된다.

            // 만약 str1의 길이가 길어졌다면 (123, 13)과 같은 형태이므로 불가능
            if (str1.length() > str2.length()) continue;

            // str2를 str1의 길이만큼 자른 후 비교한다.
            str2 = str2.substring(0, str1.length());

            if (str1.equals(str2)) return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(s.solution(new String[]{"123","456","789"}));
        System.out.println(s.solution(new String[]{"12","123","1235","567","88"}));
    }
}