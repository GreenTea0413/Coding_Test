import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        // m명 늘어날때마다 서버 1대 추가
        // m명 미만이면 안늘려도 됨
        // 근데 서버 한번 늘리면 k동안 운영됨
        int answer = 0;
        int server = 0;
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 그러면 어떻게 관리를 해야하는가..
        // time을 하나씩 증가시키고 이 타임이 24보다 작으면 도는데
        // 여기서 만약에 서버 증설하는 시간을 q에 넣는거임 그러고 time이 만약에 2에 증설하고
        // 7에 도착하면 tiem - q.peek() == k server --; 시키는건데
        // 그러면 이때 문제 발생 한번에 여러개 증설했다면?
        // map으로 <시간, 증설횟수>를 담는거임
        // 7에 도착하면 time - q.peek() == k -> server -= map.get(q.poll()); 이러면 되겠네
        while(time < 24){
            int p = players[time];
            
            while(!q.isEmpty() && time - q.peek() == k){
                server -= map.get(q.poll());
            }
            
            // (서버 개수 + 1) * m보다 크면 서버 증설해줘야함
            if((server + 1) * m <= p) {
                // 그러면 p / m가 현재 필요한 서버 수
                // n - server해서 이거를 횟수로 생각해서 gap넣어주기
                int n = p / m;
                int gap = n - server;
                
                map.put(time, gap);
                q.offer(time);
                answer += gap;
                server = n;
            }
            time ++;
        }
        return answer;
    }
}