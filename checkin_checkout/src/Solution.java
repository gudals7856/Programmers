import java.util.*;

public class Solution {

    public int[] solution(int[] enter, int[] leave) {
        int size = enter.length;

        int[] answer = new int[size];
        Map<Integer, Integer> mapOut = new HashMap<>();

        // 현재 확인하는 사람 번호
        for (int num : enter) {
            int out = 0;            // 나온 순서
            for (int j = 0; j < size; j++) {
                if (leave[j] == num) {
                    out = j;
                    break;
                }
            }
            mapOut.put(num, out);
        }

        // p1, p2를 서로 비교하면서 무조건 만나는지 확인한다.
        for (int i = 0; i < size; i++) {
            int p1 = enter[i];  // 비교할 사람 1

            for (int j = i + 1; j < size; j++) {
                int p2 = enter[j];   // 비교할 사람 2

                // 먼저들어간 사람이 나중에 나온 경우 무조건 만남
                int p1_out = mapOut.get(p1), p2_out = mapOut.get(p2);
                if (p1_out > p2_out) {
                    answer[p1 - 1]++;
                    answer[p2 - 1]++;
                    continue;
                }

                // 두 사람보다 늦게 들어간 사람이 더 빨리 나온 경우 무조건 만남
                for (int k = j + 1; k < size; k++) {
                    int p3 = enter[k];
                    int p3_out = mapOut.get(p3);

                    // p2는 p1보다 늦게 나온 것을 이미 위에서 확인했으므로 p1이랑만 확인
                    if (p3_out < p1_out) {
                        answer[p1 - 1]++;
                        answer[p2 - 1]++;
                        break;
                    }
                }
            }

        }
        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 3, 2, 4, 6, 5, 8, 7, 9, 10}, new int[]{9, 5, 1, 10, 7, 4, 8, 6, 2, 3})));
    }
}
