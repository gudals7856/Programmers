class Solution {

    public static void main(String[] args) {
        int[][] key = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};

        boolean answer = solution(key, lock);
        System.out.println(answer);
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int c = 0;
        for(int a=0; a<lock[0].length; a++) {
            for(int b=0; b<lock[0].length; b++) {
                if (lock[a][b] == 0)
                    c++;
            }
        }

        // 회전시키기 전 true가 되는지 확인
        answer = isMatched(key, lock, c);

        // 회전시키면서 true가 되는지 확인
        for(int i=0; i<3; i++) {
            key = rotate(key);
            answer = isMatched(key, lock, c);
            if (answer == true) {
                return answer;
            }
        }
        return answer;
    }

    public static boolean isMatched (int[][] key, int[][] lock, int c) {
        int count = 0;
        int keySize = key[0].length;
        int lockSize = lock[0].length;
        int[][] tmpLock = new int[lockSize + keySize * 2 - 2][lockSize + keySize * 2 - 2];

        for (int i = keySize - 1; i < keySize - 1 + lockSize; i++) {
            for (int j = keySize - 1; j < keySize - 1 + lockSize; j++) {
                tmpLock[i][j] = lock[i - keySize + 1][j - keySize + 1];
            }
        }

        for (int i = 0; i < keySize + lockSize - 1; i++) {
            for (int j = 0; j < keySize + lockSize - 1; j++) {

                // key가 자물쇠에 맞는지 확인
                for (int a = 0; a < keySize; a++) {
                    for (int b = 0; b < keySize; b++) {
                        int lockIndexI = i + a;
                        int lockIndexJ = j + b;

                        // key가 자물쇠 바깥에 있는 부분은 생각하지 않음 
                        if (lockIndexI >= keySize - 1 && lockIndexI <= keySize + lockSize - 2 &&
                                lockIndexJ >= keySize - 1 && lockIndexJ <= keySize + lockSize - 2) {

                            // 자물쇠는 0이고 열쇠는 1일 때
                            if (tmpLock[lockIndexI][lockIndexJ] == 0 && key[a][b] == 1)
                                count++;
                            else
                                continue;
                        }
                        if (count == c)
                            return true;
                    }
                }
                System.out.print(count);
                count = 0;
            }
        }
        return false;
    }

    public static int[][] rotate (int[][] key) {
        int keySize = key[0].length;
        int[][] tmpKey = key;
        int[][] nextKey = new int[keySize][keySize];
        for (int i = 0; i < keySize; i++) {
            for (int j = 0; j < keySize; j++) {
                int a = j;
                int b = keySize - 1 - i;
                nextKey[a][b] = tmpKey[i][j];
            }
        }
        key = nextKey;

        return key;
    }
}