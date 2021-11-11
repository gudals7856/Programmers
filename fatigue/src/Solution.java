class Solution {

    static int maxDepth;
    static boolean[] check;
    static int answer;

    public void dfs(int[][] dungeons, int depth, int count, int k) {
        if (depth == maxDepth) {
            answer = Math.max(answer, count);
            return;
        }

        for (int i = 0; i < maxDepth; i++) {
            if (check[i]) continue;
            check[i] = true;
            if (k < dungeons[i][0])
                dfs(dungeons, depth + 1, count, k);
            else
                dfs(dungeons, depth + 1, count + 1, k - dungeons[i][1]);
            check[i] = false;
        }
    }

    public int solution(int k, int[][] dungeons) {
        maxDepth = dungeons.length;
        check = new boolean[maxDepth];

        dfs(dungeons, 0, 0, k);

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(80, new int[][]{{80,20},{50,40},{30,10}}));
        System.out.println(s.solution(200,
                new int[][]{{200,10},{150,40},{180,100},{160,110},{110,60},{80,30},{30,10}}));
    }
}

