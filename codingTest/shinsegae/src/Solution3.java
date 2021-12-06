import java.util.*;

class Solution3 {

    List<String> list = new ArrayList<>();  // dfs 진행하면서 조건을 만족하는 문자열을 저장하는 배열
    Set<String> set = new HashSet<>();      // 동일한 문자열이 있는지 확인
    boolean[] check;    // 확인한 문자인지 체크

    public String[] solution(String letters) {
        char[] letter = new char[letters.length()]; // letters의 문자들을 담기 위한 char 배열
        check = new boolean[letters.length()];

        // letter배열에 문자 삽입
        for(int i = 0; i < letter.length; i++) letter[i] = letters.charAt(i);

        // 모든 경우의 수 체크를 위해 dfs 진행
        dfs(0, letter, new StringBuilder());

        // answer배열에 list의 정보를 담는다.
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);

        Arrays.sort(answer);    // 사전순 정렬

        return answer;
    }

    public void dfs(int depth, char[] letter, StringBuilder sb) {
        // depth가 letter의 크기가 되면 가능 여부를 확인
        if(depth == letter.length) {
            String str = sb.toString();

            // 이미 확인된 문자열이라면 확인하지 않고 return
            if(set.contains(str)) return;

            set.add(str);

            if(isPossible(str)) list.add(str);
            return;
        }

        for(int i = 0; i < letter.length; i++) {
            // 확인되지 않은 문자에 대해서만 확인하며 dfs진행
            if(!check[i]) {
                check[i] = true;
                dfs(depth + 1, letter, sb.append(letter[i]));
                sb.delete(sb.length() - 1, sb.length());
                check[i] = false;
            }
        }
    }

    // 연속된 문자열이 있으면 false, 없으면 true
    public boolean isPossible(String str) {
        char before = str.charAt(0);
        for(int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == before) return false;
            before = str.charAt(i);
        }
        return true;
    }
}