import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> inout = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        
        for(String r : records){
            String[] arr = r.split(" ");
            int time = min(arr[0]);
            String car = arr[1];
            String type = arr[2];
            
            if(type.equals("IN")) inout.put(car, time);
            else{
                int out = time - inout.get(car);
                total.put(car, total.getOrDefault(car, 0) + out);
                inout.remove(car);
            }
        }
        // 만약에 IN하고 안나가면 23:59에서 총 시간에 넣기
        if(inout.size() > 0){
            for(String key : inout.keySet()){
                int end = min("23:59") - inout.get(key);
                total.put(key, total.getOrDefault(key, 0) + end);
            }
        }
        
        // 이제 total에 차 번호에 따른 모든걸 넣었다면??
        // 5000 + ⌈(334 - 180) / 10⌉ x 600 = 14600
        // 시간을 구해야하고 차량 번호가 작은 자동차부터 한다고 하네요
        List<String> keyList = new ArrayList<>(total.keySet());
        keyList.sort((a, b) -> (a.compareTo(b)));
        
        for(String k : keyList){
            int time = total.get(k);

            // 단위 시간에 따라 올림 해야하는지 안해야하는지
            if((time - fees[0]) <= 0) answer.add(fees[1]);
            else{
                int t = (time - fees[0]) / fees[2];
                if((time - fees[0]) % fees[2] > 0) t++;
            
                answer.add(fees[1] + t * fees[3]);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    int min(String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}