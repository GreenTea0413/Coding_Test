import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum > limit) right --;
            else{ 
                left ++;
                right --;
            }
            
            answer++;
        }
        return answer;
    }
}