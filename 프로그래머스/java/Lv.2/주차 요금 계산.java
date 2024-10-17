import java.util.*;

class Solution {
    static int[] feeList;
    
    public List<Integer> solution(int[] fees, String[] records) {
        feeList = fees;
        Map<String, Integer> inMap = new HashMap<>(); // 차량 번호, 시간(분)
        TreeMap<String, Integer> resultMap = new TreeMap<>();
        
        for(String record:records) {
            String[] info = record.split(" ");

            String[] time = info[0].split(":");
            int hour = Integer.parseInt(time[0], 10) * 60;
            int minute  = Integer.parseInt(time[1], 10);
            int currentTime = hour + minute;

            String carNum = info[1];

            if(info[2].equals("IN")) { // 입차라면
                inMap.put(carNum, currentTime);
            } else { // 출차라면
                int parkedTime = currentTime - inMap.get(carNum); // 주차한 시간
                inMap.remove(carNum);

                resultMap.put(carNum, resultMap.getOrDefault(carNum, 0) + parkedTime);
            }
        }

        // 아직 출차되지 않은 차량들 -> 23:59로 간주
        for (String carNum : inMap.keySet()) {
            int parkedTime = (23 * 60 + 59) - inMap.get(carNum);
            resultMap.put(carNum, resultMap.getOrDefault(carNum, 0) + parkedTime);
        }

        // 차량별 요금 계산
        List<Integer> feeList = new ArrayList<>();
        for (String carNum : resultMap.keySet()) {
            int totalTime = resultMap.get(carNum);
            feeList.add(calculateFee(totalTime));
        }

        return feeList;
    }
    
    public static int calculateFee(int totalTime) {
        int basicTime = feeList[0];
        int basicFee = feeList[1];
        int unitTime = feeList[2];
        int unitFee = feeList[3];
        int fee;

        if(totalTime <= basicTime) {
            fee = basicFee;
        } else {  // 기본 시간을 초과했을 경우
            fee = basicFee + (int) Math.ceil((double) (totalTime - basicTime) / unitTime) * unitFee;
        }

        return fee;
    }
}
