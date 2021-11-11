import java.util.HashSet;
import java.util.Stack;

class Solution2 {
    public static HashSet<Long> primeNumbers = new HashSet<>();
    public static int answer = 0;

    public int solution(int n, int k) {
        Stack<Integer> st = new Stack<>();

        primeNumbers.add((long) 2); // 2는 소수

        while(true) {
            st.push(n % k);
            n = n / k;
            if (n < k) {
                st.push(n);
                break;
            }
        }

        String str = "";

        while(!st.isEmpty()) {
            int now = st.pop();

            // 0을 만난 경우
            if(now == 0) {
                if(str.equals("")) continue;

                // 소수인지 판별한다
                checkNum(Long.parseLong(str));
                str = "";
            }
            // 0이 아닌 다른 숫자를 만난 경우
            else {
                String nowStr = Integer.toString(now);
                str += nowStr;

                // now가 마지막 숫자였을 경우 소수인지 판별한다.
                if(st.isEmpty()) {
                    checkNum(Long.parseLong(str));
                }
            }
        }
        System.out.println(answer);

        return answer;
    }
    private static void checkNum(long num) {
        // 1인 경우 소수가 되지 못한다.
        if (num == 1) return;

        // 이미 primenumbers에 들어 있는 경우 확인하지 않고 answer 증가
        if(primeNumbers.contains(num)) {
            answer++;
            return;
        }

        // 소수인지 확인
        for (long i = 2; i * i <= num; i++)
            if (num % i == 0) return;

        answer++;
        primeNumbers.add(num);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.solution(437674, 3);
        s.solution(110011, 10);
    }
}