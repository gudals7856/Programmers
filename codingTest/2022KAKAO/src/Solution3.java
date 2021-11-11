import java.util.*;

class Solution3 {
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Integer> cars = new ArrayList<>(); // 주차했던 차 오름차순으로 저장
        HashMap<Integer, Integer> resultMap = new HashMap<>(); // 차량 번호 & 주차 시간
        HashMap<Integer, String> stateMap = new HashMap<>();   // 차량 번호 & 입차 시간
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        // 입/출차 기록
        for (int i = 0; i < records.length; i++) {
            String[] str = records[i].split(" ");
            String time = str[0];
            int carNum = Integer.parseInt(str[1]);
            String state = str[2];

            // 입차일 때
            if (state.equals("IN")) {
                stateMap.put(carNum, time);
                
                // 처음 들어온 차라면 cars, resultMap에 추가
                if (!resultMap.containsKey(carNum)) {
                    cars.add(carNum);
                    resultMap.put(carNum, 0);
                }
            }

            // 출차일 때
            else {
                String inTime = stateMap.get(carNum);
                int parkingTime = getIntTime(time) - getIntTime(inTime);    // 주차시간 계산
                resultMap.put(carNum, resultMap.get(carNum) + parkingTime); // resultMap 갱신
                stateMap.remove(carNum);
            }
        }

        // 출차 내역이 없다면(아직 stateMap에 남아있다면) 23:59에 출차된 것으로 계산
        Iterator<Integer> keys = stateMap.keySet().iterator();
        while(keys.hasNext() ){
            Integer carNum = keys.next();
            int parkingTime = getIntTime("23:59") - getIntTime(stateMap.get(carNum));
            resultMap.put(carNum, resultMap.get(carNum) + parkingTime);
        }

        Collections.sort(cars);     // 차 번호 오름차순 정렬
        int[] answer = new int[cars.size()];

        for (int i = 0; i < cars.size(); i++) {
            int fee = 0;
            int nowCarParkingTime = resultMap.get(cars.get(i));
            if (nowCarParkingTime <= basicTime) fee = basicFee;
            else {
                int overFee = 0;
                if ((nowCarParkingTime - basicTime) % unitTime != 0) {
                    overFee = ((nowCarParkingTime - basicTime) / unitTime + 1) * unitFee;
                } else {
                    overFee = ((nowCarParkingTime - basicTime) / unitTime) * unitFee;
                }
                fee = basicFee + overFee;
            }
            answer[i] = fee;
        }
        return answer;
    }

    private int getIntTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        return 60 * hour + min;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        s.solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                        "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                        "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
    }
}