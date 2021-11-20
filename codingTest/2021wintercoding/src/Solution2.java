class Solution2 {
    public int solution(int time, int gold, int[][] upgrade) {
        int answer = -1;
        int upgradeOneAnswer = 0;
        int upgradeTwoAnswer = 0;

        // 업그레이드 x
        answer = time / upgrade[0][1] * gold;


        // 업그레이드 1회
        int upgradeZeroCount = upgrade[1][0] % gold > 0 ? upgrade[1][0] / gold + 1 : upgrade[1][0] / gold; // 업그레이드 안한 상태로 캔 횟수
        time -= upgradeZeroCount * upgrade[0][1];
        if (time < 0) // 만약 업그레이드가 불가능하다면 리턴
            return answer;
        System.out.println("time = " + time);

        upgradeOneAnswer = upgradeOneAnswer + gold * upgradeZeroCount - upgrade[1][0];
        upgradeTwoAnswer = upgradeTwoAnswer + gold * upgradeZeroCount - upgrade[1][0];

        System.out.println("upgradeTwoAnswer = " + upgradeTwoAnswer);


        // 만약 업그레이드 2까지 같이할 수 있다면
        boolean up2 = false;
        if (upgradeTwoAnswer > upgrade[2][0]) {
            up2 = true;
            upgradeTwoAnswer -= upgrade[2][0];
            System.out.println("upgradeTwoAnswer = " + upgradeTwoAnswer);

            int upgradeTwoCount = time / upgrade[2][1];
            upgradeTwoAnswer += upgradeTwoCount * gold;
            System.out.println("upgradeTwoAnswer = " + upgradeTwoAnswer);
            answer = Math.max(answer, upgradeTwoAnswer);
        }

        int upgrageOneCount = time / upgrade[1][1];
        upgradeOneAnswer += upgrageOneCount * gold;
        answer = Math.max(answer, upgradeOneAnswer);

        // 업그레이드 2회
        if (up2) return answer;
        int upgradeOneCount = upgrade[2][0] % gold > 0 ? upgrade[2][0] / gold + 1 : upgrade[2][0] / gold; // 업그레이드 안한 상태로 캔 횟수
        time = time - upgradeOneCount * upgrade[0][1];
        if (time < 0) // 만약 업그레이드가 불가능하다면 리턴
            return answer;

        upgradeTwoAnswer += gold * upgradeOneCount - upgrade[2][0];
        int upgradeTwoCount = time / upgrade[2][1];
        upgradeTwoAnswer += upgradeTwoCount * gold;
        answer = Math.max(answer, upgradeTwoAnswer);

        return answer;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();

        System.out.println(s.solution(100,200,
                new int[][]{{0, 5}, {1500, 3}, {3000, 1}}));

        System.out.println(s.solution(49,200,
                new int[][]{{0, 5}, {1500, 3}, {1501, 1}}));

        System.out.println(s.solution(11,1100,
                new int[][]{{0, 5}, {100, 4}, {200, 3}}));
    }
}