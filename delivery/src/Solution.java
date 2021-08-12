import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        int[][] road1 = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int[][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        System.out.println(solution(5, road1, 3));
        System.out.println(solution(6, road2, 4));
    }

    static HashSet<Integer> check = new HashSet<>();

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        for (int i = 0; i < road.length; i++) {
            if (road[i][0] == 1 && road[i][2] <= K) {
                ArrayList<Integer> route = new ArrayList<>();
                int sum = road[i][2];

                check.add(1);
                route.add(1);

                nextTown(road, road[i][1], route, K, sum);
            }
        }

        answer = check.size();
        return answer;
    }

    public static void nextTown(int[][] road, int now, ArrayList<Integer> route, int K, int sum) {

        for (int i = 0; i < road.length; i++) {
            if (road[i][0] == now && road[i][2] <= K) {

                // 이미 지나온 길이라면 확인하지 않음.
                if (route.contains(road[i][1])) continue;

                sum += road[i][2];
                if (sum > K) return;

                check.add(now);
                route.add(now);

                nextTown(road, road[i][1], route, K, sum);
            }
        }
    }
}