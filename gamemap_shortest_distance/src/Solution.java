/*
프로그래머스 - 게임 맵 최단거리
https://programmers.co.kr/learn/courses/30/lessons/1844
 */
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static class Pair {
        int r, c, depth;
        public Pair(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }

    static boolean flag;
    static boolean[][] isChecked;
    static Queue<Pair> q = new LinkedList<>();
    static Pair destination;
    static int answer;

    public int solution(int[][] maps) {
        destination = new Pair(maps.length - 1, maps[0].length - 1, 0);
        isChecked = new boolean[maps.length][maps[0].length];

        q.add(new Pair(0, 0, 1));
        isChecked[0][0] = true;
        bfs(maps);

        return flag ? answer : -1;
    }

    public void bfs(int[][] maps) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            Pair loc = q.poll();
            for (int[] dir : dirs) {
                int nextLocR = loc.r + dir[0];
                int nextLocC = loc.c + dir[1];

                if (nextLocR >= 0 && nextLocR < maps.length && nextLocC >= 0 && nextLocC < maps[0].length && maps[nextLocR][nextLocC] == 1 && !isChecked[nextLocR][nextLocC]) {
                    isChecked[nextLocR][nextLocC] = true;
                    if (nextLocR == destination.r && nextLocC == destination.c) {
                        flag = true;
                        answer = loc.depth + 1;
                        return;
                    }
                    q.add(new Pair(nextLocR, nextLocC, loc.depth + 1));
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{
                {1,0,1,1,1,1},
                {1,0,1,0,0,1},
                {1,0,1,1,1,1},
                {1,1,1,0,1,1},
                {0,0,0,0,0,1}}));
//        System.out.println(s.solution(new int[][]{
//                {1,0,1,1,1},
//                {1,0,1,0,1},
//                {1,0,1,1,1},
//                {1,1,1,0,0},
//                {0,0,0,0,1}}));
    }
}

