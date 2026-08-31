import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> time = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        Map<String, Integer> money = new HashMap<>();
        
        Set<String> set = new HashSet<>();
        
        // 맵으로는 IN 하면 차 번호 넣어주고 시간 분으로 환산해서 넣기
        // OUT은 값 꺼내서 있었던 시간 구하기 -> 꺼내고 계산하고 map에서 그 차 번호 지워야함
        // OUT이 없는 차도 있음. 그거는 남아있으면 꺼내서 23:59랑 계산해야함
        // Set은 차 번호 기억하기
        for(String rec : records){
            String[] arr = rec.split(" ");
            int num = toNum(arr[0]);
            String car = arr[1];
            String type = arr[2];
            
            set.add(car);
            if(type.equals("IN")) time.put(car, num);
            else{
                // 들어온 시간과 나가는시간을 분으로 계산 
                // 그냥 모든 총시간만 구하는 거였음
                int start = time.get(car);
                int rest = num - start;
                
                time.remove(car);
                totalTime.put(car, totalTime.getOrDefault(car, 0) + rest);
            }
        }
        
        // 이제 OUT 처리안한거 계산하기
        for(String key : time.keySet()){
            int rest = toNum("23:59") - time.get(key);
            totalTime.put(key, totalTime.getOrDefault(key, 0) + rest);
        }
        
        // 이제 totalTime에 총 시간 구해놨음
        for(String key : totalTime.keySet()){
            int t = totalTime.get(key);
            int sum = fees[1];
            if(t > fees[0]){
                int m = (t - fees[0]) / fees[2];
                if((t - fees[0]) % fees[2] > 0) m ++;
                sum += m * fees[3];
            }
            money.put(key, sum);
        }
        
        List<String> list = new ArrayList<>(money.keySet());
        Collections.sort(list, (a, b) -> (a.compareTo(b)));
        
        int idx = 0;
        int[] answer = new int[set.size()];
        for(String key : list){
            answer[idx] = money.get(key);
            idx++;
        }
        
        return answer;
    }
    
    int toNum(String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}