/*
프로그래머스 - 프린터
https://programmers.co.kr/learn/courses/30/lessons/42587
 */


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
        
        // dq에 (중요도, 인덱스) 삽입
        for (int i = 0; i < priorities.length; i++) {
            dq.add(new Pair(priorities[i], i));
        }

        while (!dq.isEmpty()) {
            int nowPriority = dq.peek().priority;
            int nowLoc = dq.peek().loc;
            dq.poll();

            boolean flag = false;   // 현재 중요도가 가장 높은 문서이면 true

            Stack<Pair> tmpSt = new Stack<>();
            while (!dq.isEmpty()) {
                
                // dq에서 뽑은 문서의 우선순위가 더 높을 때
                if (dq.peek().priority > nowPriority) {
                    while (!tmpSt.isEmpty()) {  // tmpSt에 있는 모든 문서를 다시 넣음
                        dq.addFirst(tmpSt.pop());
                    }
                    dq.addLast(new Pair(nowPriority, nowLoc)); // 현재 문서는 마지막에
                    break;
                } else {    // dq에서 뽑은 문서의 우선순위가 더 작으면 tmpSt에 삽입
                    tmpSt.add(dq.pollFirst());
                }
            }

            // dq가 비워진 상태라면 현재 문서보다 중요도가 높은 문서가 없는 상태
            if (dq.isEmpty()) {
                flag = true;
                count++;
                while (!tmpSt.isEmpty()) {     // 현재 문서를 제외한 문서들을 다시 삽입
                    dq.addFirst(tmpSt.pop());
                }
            }

            // 현재 인쇄된 문서가 내가 요청한 문서라면 answer = count
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
