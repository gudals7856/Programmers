import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {

    public String[] solution(String[] record) {

        HashMap<String, String> users = new HashMap();
        ArrayList<String> list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);
            String func = st.nextToken();
            String id = st.nextToken();

            if (func.equals("Enter")) {             // Enter
                String name = st.nextToken();
                users.put(id, name);
                list.add(id + "님이 들어왔습니다.");
            }
            else if (func.equals("Leave")) {        // Leave
                list.add(id + "님이 나갔습니다.");
            }
            else {                                  // Change
                String name = st.nextToken();
                users.put(id, name);
            }
        }
        String[] answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            String id = list.get(i).split("님")[0];
            String str = list.get(i).split("님")[1];
            list.set(i, users.get(id) + "님" + str);
            answer[i] = list.get(i);
        }

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[]{"Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        });
    }
}