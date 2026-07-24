import java.util.*;
class Solution {
    int answer = Integer.MAX_VALUE;
    int w;
    public int solution(int n, int[] weak, int[] dist) {
        // n미터
        // 사람마다 1시간당 거리
        w = weak.length;
        int[] weak2 = new int[w * 2];
        for(int i = 0; i < w; i++){
            weak2[i] = weak[i];
            weak2[i + w] = weak[i] + n;
        }

        // 친구 순서를 고려해서 풀어야함
        dfs(n, weak2, dist, new boolean[dist.length], new ArrayList<>());
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void dfs(int n, int[] weak2, int[] dist, boolean[] v, List<Integer> friend){
        if(dist.length == friend.size()){
            // 같아지면 이제 여기서 확인
            for(int i = 0; i < w; i++){
                int count = check(weak2, i, friend) ;
                if(count != -1){answer = Math.min(answer, count);}
            }
            return;
        }
        
        for(int i = 0; i < dist.length; i++){
            if(!v[i]){
                friend.add(dist[i]);
                v[i] = true;
                
                dfs(n, weak2, dist, v, friend);
                
                friend.remove(friend.size() - 1);
                v[i] = false;
            }
        }
    }
    // friend가 4 3 2 1
    public int check(int[] weak2, int start, List<Integer> friend){
        int f = 0;
        int cur = weak2[start] + friend.get(f); // 1
        // start지점으로 부터 w개수 만큼만 진행
        for(int i = start; i < start + w; i++){
            // 이러면 1 5 6 10 / 5 6 10 11 / ... 가능
            if(weak2[i] > cur){
                f++;
                if(f == friend.size()){return -1;}
                cur = weak2[i] + friend.get(f);
            }
        }
        return f + 1;
    }
}