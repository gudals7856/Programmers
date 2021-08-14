import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        int[][] road1 = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int[][] road2 = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};

        System.out.println(solution(5, road1, 3));
        System.out.println(solution(6, road2, 4));
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static PriorityQueue<Edge> pq;
    static ArrayList<ArrayList<Edge>> edges;
    static int[] dist;

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        pq = new PriorityQueue<>();
        edges = new ArrayList<>();
        dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < N + 1; i++) edges.add(new ArrayList<>());

        for (int i = 0; i < road.length; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];

            edges.get(from).add(new Edge(to, weight));
            edges.get(to).add(new Edge(from, weight));
        }

        dist[1] = 0;
        pq.offer(new Edge(1, 0));

        dijkstra();

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;

    }

    private static void dijkstra() {
        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            for (int i = 0; i < edges.get(e.to).size(); i++) {
                Edge edge = edges.get(e.to).get(i);
                if (dist[edge.to] > dist[e.to] + edge.cost) {
                    dist[edge.to] = dist[e.to] + edge.cost;
                    pq.offer(edge);
                }
            }
        }
    }
}