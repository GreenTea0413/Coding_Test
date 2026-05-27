import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int len = citations.length;
        
        for(int i = 0; i < len; i++){
            int h = len - i;
            if(h <= citations[i]){
                return h;
            }
        }
        
        return answer;
    }
}