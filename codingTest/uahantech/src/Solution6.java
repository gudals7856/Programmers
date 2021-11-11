public class Solution6 {
    public String solution(double time, String[][] plans) {
        String answer = "";

        for (int i = 0; i < plans.length; i++) {
            String[] trip = plans[i];   // 현재 확인할 여행지

            double start = 0.0;
            double end = 0.0;

            // PM, AM 구분
            if (trip[1].charAt(trip[1].length() - 2) == 'P') {  // PM일 때
                start = Double.parseDouble(trip[1].substring(0, trip[1].length() - 2)) + 12.0;
            } else {    // AM일 때
                start = Double.parseDouble(trip[1].substring(0, trip[1].length() - 2));
            }

            if (trip[2].charAt(trip[2].length() - 2) == 'P') {  // PM일 때
                end = Double.parseDouble(trip[2].substring(0, trip[2].length() - 2)) + 12.0;
            } else {    // AM일 때
                end = Double.parseDouble(trip[2].substring(0, trip[2].length() - 2));
            }

            double vacation1 = 18.0 - start;    // 금요일 오후6시 이전에 출발하면 vacation1이 양수가 나온다.
            if (vacation1 > 0) time -= vacation1;

            double vacation2 = end - 9.5;    // 월요일 오후6시 이후에 도착하면 vacation2가 양수가 나온다.
            if (vacation2 > 0) time -= vacation2;

            // time이 음수가 되면 휴가시간이 부족한 것이므로 i - 1번째 여행지가 마지막 여행지.
            if (time >= 0) answer = plans[i][0];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();
        System.out.println(s.solution(20, new String[][]{{"홍콩", "11PM", "9AM"}, {"엘에이", "3PM", "2PM"}}));
    }
}
