import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        // 앞의 숫자를 내림차순 뒤의 숫자를 오름차순
        // [3,2][3,2][2,1][2,2][1,4] 로 한다면
        // 왼쪽 max = 3 오른쪽 max = 2이다. 내라가면 자연스럽게 앞의 숫자는 줄어드니까 뒤에숫자까지 작다면?
        // 그 사람은 보너스 못받는거임
        int len = scores.length; 
        int[] wanho = scores[0];
        int wSum = wanho[0] + wanho[1];
        Arrays.sort(scores, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return b[0] - a[0];
        });
        
        // 2를 넣어주는거임
        int rMax = scores[0][1];
        for(int[] s : scores){
            if(s[1] < rMax){
                if(wanho[0] == s[0] && s[1] == wanho[1]) return -1;
                else continue;
            }
            
            rMax = Math.max(s[1], rMax);
            if(s[0] + s[1] > wSum) answer++;
        }
        
        return answer + 1;
    }
}