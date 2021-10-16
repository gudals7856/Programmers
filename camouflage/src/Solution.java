import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<String> kind = new ArrayList<>();

    public int solution(String[][] clothes) {
        int answer = 1;


        for (String[] cloth : clothes) {
            if (!map.containsKey(cloth[1])) {
                kind.add(cloth[1]);
                map.put(cloth[1], 1);
            } else {
                map.put(cloth[1], map.get(cloth[1]) + 1);
            }
        }

        for (String s : kind) {
            answer *= (map.get(s) + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }
}