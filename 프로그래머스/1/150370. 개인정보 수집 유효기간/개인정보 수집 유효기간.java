import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        
        int to = toNum(today);
        
        for(String t : terms){
            String[] s = t.split(" ");
            termMap.put(s[0], Integer.parseInt(s[1]));
        }
        
        for(int i = 0; i < privacies.length; i++){
            String[] s = privacies[i].split(" ");
            int time = toNum(s[0]);
            String type = s[1];
            
            int dead = time + termMap.get(type) * 28;
            System.out.printf("%d %d", to, dead);
            if(to >= dead){
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    int toNum(String s){
        String[] str = s.split("[.]");
        return Integer.parseInt(str[0]) * 12 * 28 
            + Integer.parseInt(str[1]) * 28 + Integer.parseInt(str[2]);
    }
}