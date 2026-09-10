import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        
        // 1 2 4 밖에 못씀
        // 1 2 4 11 12 14 -> 나눴을 때 나머지가 0 1 2에 따라 4 1 2 부여해서 계속 쌓아가면 될듯
        while(n > 0){
            int rest = n % 3;
            
            if(rest == 0){
                answer = "4" + answer;
                n = n / 3 - 1;
            }
            else if(rest == 1){
                answer = "1" + answer;
                n /= 3;
            }
            else{
                answer = "2" + answer;
                n /= 3;
            }
        }
        return answer;
    }
}