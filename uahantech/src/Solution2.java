public class Solution2 {

    static int[] time;  // log 배열을 int형으로 변환한 배열

    public String solution(String[] log) {
        String answer = "";
        int studyingTime = 0;
        time = new int[log.length];
        
        for (int i = 0; i < log.length; i++) {
            String[] strArr = log[i].split(":");
            time[i] = Integer.parseInt(strArr[0]) * 60 + Integer.parseInt(strArr[1]);
        }

        for (int i = 0; i < log.length - 1; i = i + 2) {
            if (time[i + 1] - time[i] < 5) continue;
            else studyingTime += Math.min(time[i + 1] - time[i], 105);
        }

        answer = studyingTime / 60 + ":" + studyingTime % 60;
        if (answer.length() == 4) answer = "0" + answer;

        return answer;
    }
}