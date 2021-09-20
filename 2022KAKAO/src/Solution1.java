import java.util.*;

class Solution1 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, Integer> result = new HashMap<>();
        HashMap<String, String> map = new HashMap<>();  // 신고받은자, 신고자 저장

        for (int i = 0; i < id_list.length; i++) {
            result.put(id_list[i], 0);
            map.put(id_list[i], null);
        }

        for (int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");

            boolean isExist = false;
            if (map.get(str[1]) != null) {
                StringTokenizer st = new StringTokenizer(map.get(str[1]));

                while (st.hasMoreTokens()) {
                    if (str[0].equals(st.nextToken())) {
                        isExist = true;
                        break;
                    }
                }
            }
            if (!isExist){
                if (map.get(str[1]) == null) map.put(str[1], str[0]);
                else map.put(str[1], map.get(str[1]) + " " + str[0]);
            }
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.get(id_list[i]) != null) {
                String[] str = map.get(id_list[i]).split(" ");
                if (str.length >= k) {
                    for (int j = 0; j < str.length; j++) {
                        result.put(str[j], result.get(str[j]) + 1);
                    }
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = result.get(id_list[i]);
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2);
    }
}