import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 5000 + ⌈(334 - 180) / 10⌉ x 600 = 14600
        // [180, 5000, 10, 600]  기본시간, 기본 요금, 단위 시간(분), 단위 요금
        
        Map<String, Integer> inTime = new HashMap<>();   // 현재 입차시간
        Map<String, Integer> totalTime = new TreeMap<>(); // 누적 주차시간

        for(String record : records){
            String[] s = record.split(" ");
            int time = toMin(s[0]);
            String carNum = s[1];
            String status = s[2];

            if(status.equals("IN")){
                inTime.put(carNum, time);
            } else {
                int parked = time - inTime.get(carNum);
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + parked);
                inTime.remove(carNum);
            }
        }

        // 23:59에 아직 입차중인 차량 처리
        for(String carNum : inTime.keySet()){
            int parked = toMin("23:59") - inTime.get(carNum);
            totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + parked);
        }
        
        List<Integer> answer = new ArrayList<>();
        for(String carNum : totalTime.keySet()){
            int parkedTime = totalTime.get(carNum);
            int price;
            if(parkedTime <= fees[0]){
                price = fees[1];
            } else {
                price = fees[1] + (int)Math.ceil((double)(parkedTime - fees[0]) / fees[2]) * fees[3];
            }
            
            answer.add(price);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public int toMin(String time){
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}