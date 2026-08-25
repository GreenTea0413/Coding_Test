import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum <= limit) {
                left ++;
                right --;
            }
            else{
                right --;
            }
            answer++;
        }
        return answer;
    }
}