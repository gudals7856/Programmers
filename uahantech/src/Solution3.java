import java.util.HashMap;

class Solution3 {
    public int solution(String[] ings, String[] menu, String[] sell) {
        int answer = 0;
        HashMap<String, Integer> mapIngs = new HashMap<>();
        HashMap<String, Integer> mapRevenue = new HashMap<>();

        for (int i = 0; i < ings.length; i++) {
            String[] strArr = ings[i].split(" ");
            mapIngs.put(strArr[0], Integer.parseInt(strArr[1]));
        }

        for (int i = 0; i < menu.length; i++) {
            String[] priceInfo = menu[i].split(" ");
            int price = 0;
            for (int j = 0; j < priceInfo[1].length(); j++)
                price += mapIngs.get(Character.toString(priceInfo[1].charAt(j)));

            mapRevenue.put(priceInfo[0], Integer.parseInt(priceInfo[2]) - price);
        }

        for (int i = 0; i < sell.length; i++) {
            String[] sellInfo = sell[i].split(" ");
            int revenue = mapRevenue.get(sellInfo[0]);
            int num = Integer.parseInt(sellInfo[1]);
            answer += revenue * num;
        }

        return answer;
    }
}