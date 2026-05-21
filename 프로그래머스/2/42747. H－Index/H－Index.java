import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        Arrays.sort(citations);
        
        // 0 1 3 5 6
        // i=0일 떄 0 이상 인용된 나머지 논문이 5개이상이고 이하인가? x
        // i=1 1번 이상 인용된게 4개, 이하 2개
        // i=2 3번 이상 인용된게 3개, 이하 3개
        for(int i = 0 ; i < len; i++){
            int h = len - i;
            if(citations[i] >= h){
                return h;
            }
        }
        return answer;
    }
}