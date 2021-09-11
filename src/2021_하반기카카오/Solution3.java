import java.text.CollationElementIterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


class Solution3 {
    static Set<String> carSet = new HashSet<>();

    static public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> carMap = new TreeMap<>();

        for (String record : records) {
            String[] info = record.split(" ");
            String[] timeStr = info[0].split(":");
            int time = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);
            if (info[2].equals("IN")) {
                map.put(info[1], time);
            } else if (info[2].equals("OUT")) {
                int diff = time - map.get(info[1]);
                carMap.put(info[1], carMap.getOrDefault(info[1], 0) + diff);
                map.remove(info[1]);
            }
        }
        for (String carNum : map.keySet()) {
            int diff = 23 * 60 + 59 - map.get(carNum);
            carMap.put(carNum, carMap.getOrDefault(carNum, 0) + diff);
        }
        int[] answer = new int[carMap.keySet().size()];
        int turn = 0;
        for (String car : carMap.keySet()) {
            double fee = fees[1];
            double parkTime = carMap.get(car);
            if (parkTime > fees[0]) {
                double k = (parkTime - fees[0]) / fees[2];
                fee += (int) (Math.ceil(k) * fees[3]);
            }
            answer[turn++] = (int) fee;
        }
        return answer;
    }

    public static void main(String[] args) throws ParseException {
        int[] fees = new int[]{1, 461, 1, 10};
        String[] records = new String[]{"00:00 1234 IN"};
        solution(fees, records);
        System.out.println();
    }
}