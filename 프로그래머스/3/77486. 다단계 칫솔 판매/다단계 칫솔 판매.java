import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int l = enroll.length;
        int[] answer = new int[l];
        // <자식, 부모> 1 : 1 매칭
        // 밑에는 이제 idx 담아놓을 곳
        Map<String, String> nmap = new HashMap<>();
        Map<String, Integer> imap = new HashMap<>();
        
        // young -> edward
        // young -> 7
        for(int i = 0; i < l; i++){
            String e = enroll[i];
            String r = referral[i];
            nmap.put(e, r);
            imap.put(e, i);
        }
        
        // 이제 seller 하나씩 꺼내서 밑에서 부터 쭈욱 올라오면서 answer에다가 값 넣어야함
        for(int i = 0; i < seller.length; i++){
            String key = seller[i];
            int num = amount[i] * 100;
            // young의 idx위치와 판 가격을 넣음
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{imap.get(key), num});
            
            while(!q.isEmpty()){
                // 7, 1200이 처음에 오는데
                int now[] = q.poll();
                int idx = now[0]; 
                int remain = now[1] / 10;
                int n = now[1] - remain;
                answer[idx] += n;
                
                if(remain == 0) break;
                // 다음 부모를 찾아서 young의 부모 이름을 찾음 -> edward
                // 그럼 edward의 idx를 찾아서 remain이랑 같이 넘김
                String p = nmap.get(enroll[idx]);
                // 하지만 하다보면 -가 나오는데 이때 멈춰야함
                if(p.equals("-")) break;
                q.offer(new int[]{imap.get(p), remain});
            }
        }
        return answer;
    }
}