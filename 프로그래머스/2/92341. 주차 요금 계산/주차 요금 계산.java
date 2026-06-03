import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 차 번호, 차 들어오는 시간 <Integer, Integer>
        // 차 번호, 총 시간 <Integer, Integer>
        
        Map<String, Integer> times = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        // fee 기본 시간, 기본 요금
        for(String record : records){
            String[] arr = record.split(" ");
            int time = toMin(arr[0]);
            String num = arr[1];
            
            if(arr[2].equals("IN")){
                times.put(num, time);
            }
            else{
                int rest = time - times.get(num);
                total.put(num, total.getOrDefault(num, 0) + rest);
                times.remove(num);
            }
        }
        
        for(Map.Entry<String,Integer> entry : times.entrySet()){
            int rest = toMin("23:59") - entry.getValue();
            total.put(entry.getKey(), total.getOrDefault(entry.getKey(), 0) + rest);
        }
        List<String> carNums = new ArrayList<>(total.keySet());
        Collections.sort(carNums);
        
        List<Integer> answer = new ArrayList<>();
        for(String carNum: carNums){
            int t = total.get(carNum);
            int num = t - fees[0];
            if(num > 0) answer.add(fees[1] + (int)Math.ceil((double)num / fees[2]) * fees[3]);
            else answer.add(fees[1]);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public int toMin(String str){
        String[] n = str.split(":");
        return Integer.parseInt(n[0]) * 60 + Integer.parseInt(n[1]);
    }
}