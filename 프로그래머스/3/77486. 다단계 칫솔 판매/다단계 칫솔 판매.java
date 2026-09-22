import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // enroll에서 가져오는 이름과 idx 저장
        Map<String, Integer> indexMap = new HashMap<>();
        // 자식, 부모이름 저장
        Map<String, String> parentMap = new HashMap<>();
        
        // 그래야 seller에서 자식에 대해서 부모 타고가고 거기서 그 사람 이름 idx 꺼내서 result에 적용
        int len = enroll.length;
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++){
            indexMap.put(enroll[i], i);
            parentMap.put(enroll[i], referral[i]);
        }
        
        for(int i = 0; i < seller.length; i++){
            int a = amount[i] * 100;
            String s = seller[i];
            
            // 처음에 값 가져오면 계속 위로 거슬러가야함
            while(a > 0){
                // 하지만 -가 오면 최상단이니까 종료
                if(s.equals("-")) break;
                // 현재 사람이 판매한거에서 90%는 본인의 몫
                // 그리고 이전에 값에서 - 90%한 값
                // 1200 -> 1080이 young에 들어가고 120이 다음 
                int idx = indexMap.get(s);
                int rest = a / 10;
                
                answer[idx] += a - rest;
                a = rest;
                s = parentMap.get(s);
            }
        }
        
        return answer;
    }
}