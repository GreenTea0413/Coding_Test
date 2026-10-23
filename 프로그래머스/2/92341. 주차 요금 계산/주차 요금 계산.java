import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> time = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        
        for(int i = 0; i < records.length; i++){
            String[] s = records[i].split(" ");
            // 시간, 차번호, 타입
            int t = toNum(s[0]);
            
            if(s[2].equals("IN")) time.put(s[1], t);
            else {
                total.put(s[1], total.getOrDefault(s[1], 0) + t - time.get(s[1]));
                time.remove(s[1]);
            }
        }
        
        if(time.size() >= 1){
            for(Map.Entry<String, Integer> ent : time.entrySet()){
                String key = ent.getKey();
                int value = ent.getValue();
                total.put(key, total.getOrDefault(key, 0) + toNum("23:59") - value);
            }
        }
                          
                          
        int[] answer = new int[total.size()];
        List<String> keyList = new ArrayList<>(total.keySet());
        Collections.sort(keyList, (a, b) -> a.compareTo(b));
        
        int idx = 0;
        for(String k : keyList){
            int value = total.get(k);
            System.out.print(value);
            if((value - fees[0]) >= 0) {
                int f = (value - fees[0]) / fees[2];
                if((value - fees[0]) % fees[2] > 0) f++;
                answer[idx++] = fees[1] + f * fees[3];
            }
            else answer[idx++] += fees[1];
        }
                
        return answer;
    }
    
    int toNum(String time){
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}