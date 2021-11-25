public class Solution {
    public int solution(int n) {
        int answer = n + 1;
        while (true) {
            if (binaryTransform(n) == binaryTransform(answer))
                break;
            answer++;
        }
        return answer;
    }

    public int binaryTransform(int n) {
        int count = 0;
        while (n > 1) {
            if (n % 2 == 1) count++;
            n /= 2;
        }
        return count;
    }

//    Integer 클래스의 bitCount 메서드를 통해 이진변환 시 1의 개수를 바로 찾을 수 있다.
//    public int solution(int n) {
//        int answer = n + 1;
//        while (true) {
//            if (Integer.bitCount(n) == Integer.bitCount(answer))
//                break;
//            answer++;
//        }
//        return answer;
//    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(78));
        System.out.println(s.solution(15));
    }
}
