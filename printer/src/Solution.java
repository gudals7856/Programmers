import java.util.*;

public class Solution {

    class Pair {
        int priority;
        int loc;

        public Pair(int priority, int loc) {
            this.priority = priority;
            this.loc = loc;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int count = 0;

        Deque<Pair> dq = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            dq.add(new Pair(priorities[i], i));
        }

        while (!dq.isEmpty()) {
            int nowPriority = dq.peek().priority;
            int nowLoc = dq.peek().loc;
            dq.poll();

            boolean flag = false;

            Stack<Pair> tmpQ = new Stack<>();
            while (!dq.isEmpty()) {
                if (dq.peek().priority > nowPriority) {
                    while (!tmpQ.isEmpty()) {
                        dq.addFirst(tmpQ.pop());
                    }
                    dq.addLast(new Pair(nowPriority, nowLoc));
                    break;
                } else {
                    tmpQ.add(dq.pollFirst());
                }
            }

            // dq가 비워진 상태라면 nowPriority가 가장 큰 상태
            if (dq.isEmpty()) {
                flag = true;
                count++;
                while (!tmpQ.isEmpty()) {
                    dq.addFirst(tmpQ.pop());
                }
            }

            if (flag && nowLoc == location) {
                answer = count;
                break;
            }
        }

        System.out.println(answer);

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{2, 1, 3, 2}, 2);
        s.solution(new int[]{1, 1, 1, 2}, 1);
        s.solution(new int[]{1, 2, 3}, 0);
        s.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }
}
