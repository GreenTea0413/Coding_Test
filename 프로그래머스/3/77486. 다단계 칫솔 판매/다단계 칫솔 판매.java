import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        
        // 그래프 만들기
        // r에 따라 e 넣어주기
        // 그래프 반대로 만들어줘야지 타고올라가는거 처럼 만들기 가능
        Map<String, String> pMap = new HashMap<>();
        Map<String, Integer> iMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            String e = enroll[i];
            String r = referral[i];
            
            pMap.put(e, r);
            iMap.put(e, i);
        }
                
        // 그 다음 seller를 하나씩 꺼내서 이름 비교해서 pMap에 다음 값 찾고 -이면 중단
        // 그러면서 iMap에서는 idx를 꺼내서 answer에 바로 바로 값 더해주기
        for(int i = 0; i < seller.length; i++){
            int total = amount[i] * 100;
            String now = seller[i];
            
            while(!now.equals("-") && total > 0){
                int rest = total / 10;
                int num = total - rest;
                
                answer[iMap.get(now)] += num;
                now = pMap.get(now);
                
                total = rest;
            }
        }
        
        return answer;
    }
}