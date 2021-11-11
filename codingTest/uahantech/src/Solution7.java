import java.util.Arrays;

public class Solution7 {

    // true : 시계, false : 반시게
    public String[] solution(String[] grid, boolean clockwise) {
        String[] answer = new String[grid.length];

        if (clockwise) {    // 시계방향
            for (int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = grid.length - 1; j >= grid.length - 1 - i; j--) {
                    if (j == grid.length - 1 - i) {
                        sb.append(grid[j], 0, 1);
                        grid[j] = grid[j].substring(1);
                    } else {
                        for (int k = 1; k >= 0; k--)
                            sb.append(grid[j].charAt(k));
                        grid[j] = grid[j].substring(2);
                    }
                }
                answer[i] = sb.toString();
            }
        } else {    // 반시계방향
            for (int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = grid.length - 1 - i; j <= grid.length - 1; j++) {
                    if (j == grid.length - 1 - i) {
                        sb.append(grid[j], grid[j].length() - 1, grid[j].length());
                        grid[j] = grid[j].substring(0, grid[j].length() - 1);
                    } else {
                        for (int k = grid[j].length() - 1; k >= grid[j].length() - 2; k--)
                            sb.append(grid[j].charAt(k));
                        grid[j] = grid[j].substring(0, grid[j].length() - 2);
                    }
                }
                answer[i] = sb.toString();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution7 s = new Solution7();
        System.out.println(Arrays.toString(s.solution(new String[]{"1", "234", "56789"}, true)));
        System.out.println(Arrays.toString(s.solution(new String[]{"A","MAN","DRINK","WATER11"}, false)));
    }
}
