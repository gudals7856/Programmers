import java.util.*;

public class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < people.length; i++) {
            deque.add(people[i]);
        }

        while (!deque.isEmpty()) {

            // deque 크기가 1 이면 빼고 answer증가
            if (deque.size() == 1) {
                deque.remove(0);
                answer++;
                break;
            }

            // 가장 큰 값이랑 작은 값 더해서 limit보다 작으면 둘다 빼고, 아니면 큰 값만 뺌
            if (deque.getLast() + deque.getFirst() <= limit) {
                deque.removeLast();
                deque.removeFirst();
            } else {
                deque.removeLast();
            }
            answer++;
        }

//        ArrayList<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < people.length; i++) {
//            list.add(people[i]);
//        }
//        list.sort(Comparator.reverseOrder());
//
//        while (!list.isEmpty()) {
//            if (list.size() == 1) {
//                list.remove(0);
//                answer++;
//                break;
//            }
//
//            if (list.get(0) + list.get(list.size() - 1) <= limit) {
//                list.remove(list.size() - 1);
//                list.remove(0);
//            } else {
//                list.remove(0);
//            }
//            answer++;
//        }

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(s.solution(new int[]{70, 80, 50}, 100));
    }
}