import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

class Solution {

    static HashSet<Integer> member = new HashSet<>();   // 중복된 원소를 포함하지 않기위해

    public static void main(String[] args) {
        int[] sales = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
        int[][] links = {{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};
        int[] sales2 = {5, 6, 5, 3, 4};
        int[][] links2 = {{2, 3}, {1, 4}, {2, 5}, {1, 2}};
        int[] sales3 = {5, 6, 5, 1, 4};
        int[][] links3 = {{2, 3}, {1, 4}, {2, 5}, {1, 2}};
        int[] sales4 = {10, 10, 1, 1};
        int[][] links4 = {{3, 2}, {4, 3}, {1, 4}};

        System.out.println("문제 1 ---------------------------------------");
        solution(sales, links);
        member.clear();
        System.out.println("문제 2 ---------------------------------------");
        solution(sales2, links2);
        member.clear();
        System.out.println("문제 3 ---------------------------------------");
        solution(sales3, links3);
        member.clear();
        System.out.println("문제 4 ---------------------------------------");
        solution(sales4, links4);
    }

    //  값이 무조건 작은걸 고르면 안된다.
    //  상위 팀과 하위 팀에 공통된 팀원(하위 팀의 팀장)의 매출액이
    //  상위 팀, 하위 팀의 가장 작은 매출액을 더한 합보다 작을 경우도 고려해야한다.
    public static int solution(int[] sales, int[][] links) {
        int answer = 0;
        ArrayList<int[]> linksList = new ArrayList<>(Arrays.asList(links));
        
        makeTeam(sales, linksList, 1, 0);

        // member 배열에 삽입된 팀원들의 매출액을 더함
        Iterator it = member.iterator();

        System.out.print("워크샵에 포함된 팀원 번호 : ");
        while(it.hasNext()){
//            answer += sales[(int) it.next() - 1];
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println();
//        System.out.println(answer);
        return answer;
    }

    public static void makeTeam(int[] sales, ArrayList<int[]> links, int leader, int before) {
        int n = sales.length;
        ArrayList<int[]> team = new ArrayList<>();
        int compare = 300001;
        int min = 0;
        boolean flag1 = false;
        boolean flag2 = false;

        int[] teamleader = {leader, sales[leader - 1]};
        team.add(teamleader);

        for (int i = 0; i < links.size(); i++) {
            if (links.get(i)[0] == leader) {
                int[] info = new int[2];
                info[0] = links.get(i)[1];      // 팀원 번호
                info[1] = sales[info[0] - 1];   // 팀원 매출액
                team.add(info);
                links.remove(i--);
            }
        }

        if (team.size() == 1)
            return;

        for (int i = 0; i < team.size(); i++) {
            System.out.println(team.get(i)[0] + " " + team.get(i)[1]);
        }
        System.out.println();

        // member에 이미 들어가있는 팀원이 있다면(팀장이 갔다면) 아무도 추가하지 않는다
        for (int i = 0; i < team.size(); i++) {
            if (member.contains(team.get(i)[0])) {
                flag1 = true;
                break;
            }
            if (team.get(i)[1] < compare) {
                compare = team.get(i)[1];
                min = team.get(i)[0];
            }
        }
        if (!flag1) {
            member.add(min);
        }

        // 상위 팀에서 팀장이 워크숍에 가지 않았고
        if (!flag1 && before != 0) {
            // 상위 팀의 최소 매출액과 현재 팀의 최소 매출액의 합이 팀장의 매출액보다 크면 둘을 빼고 팀장을 투입
            if (sales[min-1] + sales[before-1] > sales[leader-1]) {
                member.remove(min);
                member.remove(before);
                member.add(leader);
                flag2 = true;
            }
        }

        // 팀장이 워크숍에 갔다면 before를 0, 아니라면 min을 하위 팀에 넘김
        if (flag2) {
            before = 0;
        } else {
            before = min;
        }

        // 팀장을 제외한 나머지 팀원들을 팀장으로한 팀을 확인
        team.remove(0);
        for (int i = 0; i < team.size(); i++) {
            makeTeam(sales, links, team.get(i)[0], before);
        }
    }
}