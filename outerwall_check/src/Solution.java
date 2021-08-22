class Solution {

    public static void main(String[] args) {
        int n = 12;
        int[] weak1 = {1, 5, 6, 10};
        int[] dist1 = {1, 2, 3, 4};

        int[] weak2 = {1, 3, 4, 9, 10};
        int[] dist2 = {3, 5, 7};

        System.out.println(solution(n, weak1, dist1));
//        System.out.println(solution(n, weak2, dist2));
    }

    static int nCpy, answer;
    static int[] spreadWeak, weakCpy, distCpy;
    static boolean[] distCheck;

    static int min = Integer.MAX_VALUE;
    static boolean isPossible = false;

    // 원형으로 생긴 외벽을 직선이라 생각하고, 길이를 2배 늘려 생각한다.(마지막 weak로 부터도 한바퀴 돌아야하므로)
    // ex) n=12, weak={1,5,6,10} >>> weak={1,5,6,10,13,17,18} 가 있다고 생각하고 푼다!
    public static int solution(int n, int[] weak, int[] dist) {
        answer = 0;
        nCpy = n;
        weakCpy = weak;
        distCpy = dist;
        spreadWeak = new int[weak.length * 2 - 1];     // 확장된 weak 배열
        distCheck = new boolean[dist.length]; // dist 배열을 이용해 순열을 만든다

        for (int i = 0; i < spreadWeak.length; i++) {
            if (i < weak.length)
                spreadWeak[i] = weak[i];
            else
                spreadWeak[i] = weak[i-weak.length] + n;
        }

        permutation(0, new int[dist.length]);
        if (!isPossible)
            return -1;

        return answer;
    }

    public static void permutation (int depth, int[] permuteDist) {

        // 순열이 하나씩 만들어지면 외벽 점검을 시작한다
        if (depth == distCpy.length) {
            wallCheck(permuteDist);
        }

        for (int i = 0; i < distCpy.length; i++) {
            if (!distCheck[i]) {
                permuteDist[depth] = distCpy[i];
                distCheck[i] = true;
                permutation(depth + 1, permuteDist);
                distCheck[i] = false;
            }
        }
    }

    public static void wallCheck (int[] permuteDist) {
        int pos = 0;        // 현재 있는 위치

        // 취약지점 파악할 시작점 선정 [1,5,6,10,13,17,18,22]일때 1,5,6,10을 시작점으로 두고 확인
        for (int i = 0; i < weakCpy.length; i++) {
            int count = 0;
            int friendCount = 0;
            int k = i + 1;
            pos = spreadWeak[i];    // 점검 시작 지점을 i번째 취약지점으로

            // 친구의 수만큼 반복함. 중간에 완료되면 그때까지 친구 수(answer) 반환, 완료되지 않으면 -1 반환
            for (int j = 0; j < distCpy.length; j++) {
                friendCount++;
                pos += permuteDist[j];
                count++;

                // 아직 취약지점을 모두 확인하지 않았다면 가능한 취약지점을 모두 확인
                if (count < weakCpy.length) {
                    while (pos >= spreadWeak[k]) {
                        count++;
                        if (count == weakCpy.length)
                            break;
                        k++;
                    }
                    pos = spreadWeak[k];
                }
                if (count == weakCpy.length)
                    break;
            }

            // 취약지점을 모두 확인 했을 때
            if (count == weakCpy.length) {
                isPossible = true;
                min = Math.min(friendCount, min);
                answer = min;
            }
        }
    }
}