import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String[] arr = msg.split("");
        
        // 사전 만들기
        for(int i = 0; i < 26; i++){
            String next = String.valueOf((char)('A' + i));
            map.put(next, i + 1);
        }
        
        
        // 사전에 없으면 추가
        // T 다음 오는거 까지 고려
        int idx = 0;
        int lastIdx = 27;
        
        while(idx < arr.length){
            String w = arr[idx];
            
            // 다음 거랑 합쳐서 사전에 있으면 w를 업데이트 시켜줌
            while(idx + 1 < arr.length && map.containsKey(w + arr[idx + 1])){
                w += arr[idx + 1];
                idx++;
            }
            
            // 현재입력 w에 대해 출력값 넣기
            if(map.containsKey(w)){ answer.add(map.get(w)); }
            
            if(idx + 1 < arr.length){
                map.put(w + arr[idx + 1], lastIdx);
                lastIdx++;
            } 
            
            idx++;
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}