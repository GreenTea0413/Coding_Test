import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        // young -> edward
        // tod -> jaimie
        // jaimie -> mary 
        // emily -> mary
        // sam -> edward
        // edward -> mary
        // mary -> -
        // jonh -> -
        for(int i = 0; i < n; i++){
            String parent = referral[i];
            String child = enroll[i];
            
            parentMap.put(child, parent);
            indexMap.put(child, i);
        }
        
        for(int i = 0; i < seller.length; i++){
            String now = seller[i];
            int money = amount[i] * 100;
            
            while(!now.equals("-") && money > 0){
                int give = money / 10;
                int keep = money - give;
                
                answer[indexMap.get(now)] += keep;
                now = parentMap.get(now);
                
                money = give;
            }
        }
        
        return answer;
    }
}