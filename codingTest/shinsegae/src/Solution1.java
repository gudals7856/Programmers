import java.util.*;

class Solution1 {

    Queue<String>[] q;

    public String[] solution(int n, String[] record) {

        // n개의 큐 생성
        q = new LinkedList[n];
        for(int i = 0; i < n; i++) q[i] = new LinkedList<>();

        // record를 돌며 서버에 캐릭터를 생성
        for(int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            int serverNum = Integer.parseInt(st.nextToken()) - 1;   // q의 인덱스가 0부터 시작하므로 -1
            String name = st.nextToken();

            // 닉네임이 이미 존재하면 다음 캐릭터 확인
            if(contains(q[serverNum], name)) continue;

            // 서버 내에 5개의 캐릭터가 이미 만들어져 있으면 poll후 새 캐릭터 생성
            if(q[serverNum].size() == 5) q[serverNum].poll();
            q[serverNum].add(name);
        }

        List<String> list = new ArrayList<>();  // 캐릭터 명을 임시로 저장해놓기 위한 배열

        // q에 존재하는 캐릭터들을 list에 삽입
        for(int i = 0; i < q.length; i++) {
            while(!q[i].isEmpty()) list.add(q[i].poll());
        }

        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    // 이미 들어있는 닉네임인지 확인
    public boolean contains(Queue<String> q, String name) {
        List<String> tmpList = new ArrayList<>();     // q의 요소들을 임시로 저장하기 위한 배열
        boolean flag = false;

        while(!q.isEmpty()) {
            if(q.peek().equals(name)) flag = true;
            tmpList.add(q.poll());
        }

        for(int i = 0; i < tmpList.size(); i++)
            q.add(tmpList.get(i));

        return flag;
    }
}