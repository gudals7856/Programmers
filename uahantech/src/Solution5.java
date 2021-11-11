class Solution5 {

    public int[][] solution(int rows, int columns) {
        int before = 1;
        int[][] answer = new int[rows][columns];
        boolean[][] check = new boolean[rows][columns];
        int zeroCount = rows * columns - 1;
        int nowRow = 0;
        int nowCol = 0;
        boolean endCheck = false;

        answer[0][0] = 1;
        check[0][0] = true;

        while(true){
            if(endCheck) break;
            if(zeroCount == 0) break;

            // 다음 위치 : (nextRow, nextCol)
            int nextRow = nowRow;
            int nextCol = nowCol;

            if(before % 2 == 1) nextCol++;
            else nextRow++;

            if(nextRow == rows) nextRow = 0;
            if(nextCol == columns) nextCol = 0;

            // 정사각형일 경우 다음 좌표가 0,0이 되면 끝낸다
            if(rows == columns){
                if(check[nextRow][nextCol]){
                    endCheck = true;
                    return answer;
                }
            }
            before++;
            answer[nextRow][nextCol] = before;

            if(!check[nextRow][nextCol]){
                zeroCount--;
                check[nextRow][nextCol] = true;
            }
            
            // 다음 반복문을 위해 nowR, nowC 변경
            nowRow = nextRow;
            nowCol = nextCol;
        }

        return answer;
    }
}