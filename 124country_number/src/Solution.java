class Solution {

    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder("");

        func(sb, n);
        answer = sb.toString();
        System.out.println(answer);

        return answer;
    }

    public void func(StringBuilder sb, int n) {
        if (n == 0) return;

        if (n % 3 == 1) {
            sb.insert(0, "1");
            n = n / 3;
        } else if (n % 3 == 2) {
            sb.insert(0, "2");
            n = n / 3;
        } else if (n % 3 == 0) {
            sb.insert(0, "4");
            n = n / 3;
            n -= 1;
        }
        func(sb, n);
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(1);
        s.solution(2);
        s.solution(3);
        s.solution(4);
        s.solution(10);
    }
}