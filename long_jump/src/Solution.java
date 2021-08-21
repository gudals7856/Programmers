import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    long[] dp = new long[2001];

    public long solution(int n) {
        if (n == 1) dp[1] = 1;
        else if (n == 2) dp[2] = 2;
        else {
            if (dp[n] == 0)
                dp[n] = solution(n - 2) + solution(n - 1);
        }
        return dp[n] % 1234567;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(Integer.parseInt(br.readLine())));
    }
}
