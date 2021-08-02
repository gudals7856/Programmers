import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        String[] gems5 = {"A", "A", "B"};


        System.out.println(Arrays.toString(solution(gems1)));
        System.out.println(Arrays.toString(solution(gems2)));
        System.out.println(Arrays.toString(solution(gems3)));
        System.out.println(Arrays.toString(solution(gems4)));
        System.out.println(Arrays.toString(solution(gems5)));
    }

    static int min = Integer.MAX_VALUE;

    // 보석 종류를 저장하기 위해 Hashset 사용
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int gemNum = gems.length;
        HashSet<String> gemHash = new HashSet<>(Arrays.asList(gems).subList(0, gemNum));

        // end[i] : i번째 진열대에서 출발, end[i]의 값은 모든 보석 종류를 확인한 위치 저장
        // end[i+1] : i+1부터 출발하므로 i번째 진열대에 저장된 보석만 찾으면된다.
        int[] end = new int[gemNum];

        // 0 번째 진열장부터 시작해서 모든 종류의 보석을 찾을 때까지 반복문 수행하고 마지막 위치를 end[0]에 저장
        for (int i = 0; i < gemNum; i++) {

            // gemHash에서 현재 위치 보석 삭제
            gemHash.remove(gems[i]);

            if (gemHash.isEmpty()) {
                end[0] = i;
                answer[0] = 0;
                answer[1] = end[0];
                min = answer[1] - answer[0];
                break;
            }
        }

        // 1번째 진열장부터 다시 확인한다.
        for (int i = 1; i < gemNum; i++) {
            gemHash.add(gems[i - 1]);

            // i-1 진열장에 있는 것만 찾으면 된다.
            for (int j = i; j < gemNum; j++) {

                // gemHash에서 현재 위치 보석 삭제 (gemHash에 없으면 삭제 안되고 그냥 진행)
                gemHash.remove(gems[j]);

                // 현재 위치가 end[i-1] 이전이면 end[i] 에 end[i-1]을 저장한다. 이후에 찾아지면 현재 위치 저장
                if (gemHash.isEmpty()) {
                    if (j < end[i - 1])
                        end[i] = end[i - 1];
                    else
                        end[i] = j;

                    if (end[i] - i < min) {
                        answer[0] = i;
                        answer[1] = end[i];
                        min = answer[1] - answer[0];
                    }
                    break;
                }
            }
        }
        answer[0] += 1;
        answer[1] += 1;

        return answer;
    }
}