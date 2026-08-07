import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] wanho = scores[0];
        int wSum = wanho[0] + wanho[1];
        Arrays.sort(scores, (a, b) ->{
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        int rMax = scores[0][1];
        
         
        for(int[] s : scores){
            if(s[1] < rMax){
                if(s[0] == wanho[0] && s[1] == wanho[1]) return -1;
                else continue;
            }
            
            rMax = Math.max(rMax, s[1]);
            if(s[0] + s[1] > wSum) answer++;
        }
        return answer + 1;
    }
}