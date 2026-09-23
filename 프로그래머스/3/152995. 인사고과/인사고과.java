import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] wanho = scores[0];
        // 3,2
        // 3,2
        // 2,1
        // 2,2
        // 1,4 
        // 앞의 숫자를 기준으로 내림차순
        // 그러면 앞 숫자는 자동으로 줄어드니까 뒤에 숫자만 계산하면 됨
        Arrays.sort(scores, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        // 점수가 이전사람 보다 둘다 낮으면 인센티브 x
        // 근데 이미 [0]의 값은 내림차순으로 더 작을 이유가 없음
        // 그러면 [1]의 숫자는 점점 작아지는 여기서 s[1]이 현 최대값 보다 작으면?
        // 비교해서 wanho의 값이 만약에 현재 점수라면 -1
        int secMax = scores[0][1];
        int wanhoSum = wanho[0] + wanho[1];
        
        for(int[] s : scores){
            if(s[1] < secMax){
                if(s[0] == wanho[0] && s[1] == wanho[1]) return -1;
                else continue;
            }
            
            // 뒤의 값만 계속 신경쓰면 되니까 갱신해주기
            // 2,2 -> 1,4가 되면 다음에 0,2가 오거나 1,2가 오거나 할 수 있으니까 secMax업데이트
            // 그리고 완호 등수만 확인하면 되니까 완호보다 크면 answer
            
            secMax = Math.max(secMax, s[1]);
            if(s[0] + s[1] > wanhoSum) answer++;
        }
        return answer + 1;
    }
}