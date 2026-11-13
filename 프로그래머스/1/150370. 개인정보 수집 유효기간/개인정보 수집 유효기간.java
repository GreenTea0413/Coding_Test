import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(String t : terms){
            String[] arr = t.split(" ");
            map.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        int to = change(today);
        for(int i = 0; i < privacies.length; i++){
            String[] arr = privacies[i].split(" ");
            int date = change(arr[0]);
            
            if(to >= date + map.get(arr[1]) * 28) answer.add(i + 1);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    int change(String time){
        String[] arr = time.split("\\.");
        return Integer.parseInt(arr[0]) * 28 * 12 + Integer.parseInt(arr[1]) * 28 
                + Integer.parseInt(arr[2]);
    }
}