import java.util.PriorityQueue;

class Solution {

    // 최소 필요 피로도와 소모 피로도의 차이가 큰 순서대로 우선순위 큐에 저장
    // 최소 필요 피로도를 만족하면 큐에서 제거 후 answer++, 아니면 그냥 제거

    static class Pair implements Comparable<Pair>{
        int min, consume;

        public Pair(int min, int consume) {
            this.min = min;
            this.consume = consume;
        }

        @Override
        public int compareTo(Pair o) {
            if ((o.min - o.consume) == (this.min - this.consume)) {
                return -1;
            }
            return (o.min - o.consume) - (this.min - this.consume);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "min=" + min +
                    ", consume=" + consume +
                    '}';
        }
    }

    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public int solution(int k, int[][] dungeons) {
        int answer = 0;

        for (int[] dungeon : dungeons)
            pq.add(new Pair(dungeon[0], dungeon[1]));

        while (!pq.isEmpty()) {
            Pair dungeon = pq.poll();

            // 최소 필요 피로도보다 k가 작으면 패스
            if (k < dungeon.min) continue;

            System.out.println(dungeon);
            k -= dungeon.consume;
            answer++;
        }

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(80, new int[][]{{80,20},{50,40},{30,10}}));
        System.out.println(s.solution(200,
                new int[][]{{200,10},{150,40},{180,20},{160,110},{110,60},{80,30},{30,10}}));
    }
}

