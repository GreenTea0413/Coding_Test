import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for(String t : terms){
            String[] arr = t.split(" ");
            map.put(arr[0], Integer.parseInt(arr[1]));
        }
        int to = date(today);
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++){
            String[] arr = privacies[i].split(" ");
            int p = date(arr[0]);
            
            if(to >= p + map.get(arr[1]) * 28) answer.add(i + 1);
        }
               
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public int date(String s){
        String[] arr = s.split("\\.");
        return Integer.parseInt(arr[0]) * 12 * 28 + Integer.parseInt(arr[1]) * 28 
            + Integer.parseInt(arr[2]);
    }
}