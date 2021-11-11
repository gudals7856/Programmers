public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n >= 1) {
            if (n % 2 == 1) {
                n -= 1;
                ans++;
            }
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5000));
    }
}