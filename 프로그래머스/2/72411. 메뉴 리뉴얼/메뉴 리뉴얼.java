import java.util.*;

class Solution {
    public Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        map = new HashMap<>();
        // 메뉴가 2개 이상이여야함
        // 문자 길이가 같다면 횟수가 더 많은 걸로 하기
        // 이걸로 코스 길이만큼 문자열 만들어 내기
        for(String order : orders){
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            for(int c : course){
                combine(arr, "", 0, c);
            } 
        }
        
        for(int c : course){
            int max = 1;
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if (entry.getKey().length() == c){
                    max = Math.max(max, entry.getValue());
                }
            }
            
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(entry.getKey().length() == c && max == entry.getValue() && max >= 2){
                    answer.add(entry.getKey());
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public void combine(char[] arr, String now, int start, int depth){
        if(depth == 0){
            map.put(now, map.getOrDefault(now, 0) + 1);
            return;
        }
        for(int i = start; i < arr.length; i++){
            combine(arr, now + arr[i], i + 1, depth -1);
        }
    }
}