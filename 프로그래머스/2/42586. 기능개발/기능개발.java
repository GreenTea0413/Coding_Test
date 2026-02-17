import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = speeds.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        int prev = (100 - progresses[0]) / speeds[0];
        if ((100 - progresses[0]) % speeds[0] > 0){
            prev ++;
        }
        
        int count = 1;
        for (int i = 1; i < len; i++){
            int now = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0){
                now ++;
            }
            
            if (prev >= now){
                count ++;
            }
            else{
                list.add(count);
                count = 1;
                prev = now;
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int j = 0; j < list.size(); j++){
            answer[j] = list.get(j);
        }
        
        return answer;
    }
}