public class Solution1 {
    public String solution(String character, String[] monsters) {
        String answer = "";

        double[] exp = new double[monsters.length];
        int[] characterStat = new int[3];
        for (int i = 0; i < 3; i++) {
            characterStat[i] = Integer.parseInt(character.split(" ")[i]);
        }

        String[][] monsterStat = new String[monsters.length][5];
        for(int i = 0; i < monsters.length; i++){
            monsterStat[i] = monsters[i].split(" ");
        }

        for (int i = 0; i < monsterStat.length; i++) {
            int playersDamage = characterStat[1] - Integer.parseInt(monsterStat[i][4]);
            int monstersDamage = Integer.parseInt(monsterStat[i][3]) - characterStat[2];

            // 플레이어의 데미지가 몬스터를 한번에 죽이지 못하고
            // 몬스터의 데미지로 플레이어를 한번에 죽일 수 있다면 게임 종료
            if (playersDamage < Integer.parseInt(monsterStat[i][1]) && monstersDamage >= characterStat[0]) {
                continue;
            }

            // 몇번만에 몬스터를 잡을 수 있는지
            int count = 0;
            if (Integer.parseInt(monsterStat[i][2]) % playersDamage == 0)
                count = Integer.parseInt(monsterStat[i][2]) / playersDamage;
            else
                count = Integer.parseInt(monsterStat[i][2]) / playersDamage + 1;

            exp[i] = Double.parseDouble(monsterStat[i][1]) / (double)count;
        }

        answer = monsterStat[0][0];
        double maxExp = exp[0];
        int maxIdx = 0;
        for (int i = 1; i < exp.length; i++) {
            if (exp[i] > maxExp) {
                maxIdx = i;
                maxExp = exp[i];
                answer = monsterStat[i][0];
            }
            if (exp[i] == maxExp) {
                // 주는 경험치가 같은 경우는 어차피 maxIdx가 더 작은 인덱스이므로 그대로 둔다.
                if (Integer.parseInt(monsterStat[maxIdx][1]) >= Integer.parseInt(monsterStat[i][1])) continue;
                else {
                    maxIdx = i;
                    maxExp = exp[i];
                    answer = monsterStat[i][0];
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.solution("10 5 2", new String[]{"Knight 3 10 10 3", "Wizard 5 10 15 1", "Beginner 1 1 15 1"});
        s.solution("10 5 2", new String[]{"Knight 3 10 10 3", "Wizard 5 10 15 1", "dfasdfaf 5 3 19 2"});
    }
}