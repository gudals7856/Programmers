import java.util.StringTokenizer;

public class Solution {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(0) >= 'a' && sb.charAt(0) <= 'z')
            sb.
                    replace(0, 1, Character.toString(Character.toUpperCase(sb.charAt(0))));

        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i - 1) == ' ' && sb.charAt(i) >= 'a' && sb.charAt(0) <= 'z')
                sb.replace(i, i + 1, Character.toString(Character.toUpperCase(sb.charAt(i))));
            else if (sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z')
                sb.replace(i, i + 1, Character.toString(Character.toLowerCase(sb.charAt(i))));
        }

        return sb.toString();

//        StringBuilder answer = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(s);
//        while (st.hasMoreTokens()) {
//            String str = st.nextToken();
//
//            if (str.charAt(0) >= 'a' && str.charAt(0) <= 'z') answer.append((char) (str.charAt(0) - 32));
//            else answer.append(str.charAt(0));
//
//            for (int i = 1; i < str.length(); i++) {
//                if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') answer.append((char) (str.charAt(i) + 32));
//                else answer.append(str.charAt(i));
//            }
//
//            if (st.hasMoreTokens()) answer.append(" ");
//        }
//        return answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("3people unFollowed me"));
        System.out.println(s.solution("a"));
        System.out.println(s.solution("for the last week"));
        System.out.println(s.solution("for the  last week  "));
    }
}
