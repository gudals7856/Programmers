public class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        double inclination = (double)h / (double)w;
        double before = 0.0;

        for (int i = 1; i < w + 1; i++) {
            double num = (long) Math.ceil(inclination * i) - (long) Math.floor(before);
            answer += num;
            before = inclination * i;
        }

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(8, 12));
    }
}