import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, 0});
        
        boolean[] v = new boolean[y + 1];        
        v[x] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int cur = now[0];
            int dist = now[1];
            
            if(cur == y) {
                return dist;
            }
            
            if (cur + n <= y && !v[cur + n]) {
                v[cur + n] = true; 
                q.offer(new int[]{cur + n , dist + 1});
            }
            if (cur * 2 <= y && !v[cur * 2]) {
                v[cur * 2] = true; 
                q.offer(new int[]{cur * 2 , dist + 1});
            }
            if (cur * 3 <= y && !v[cur * 3]) {
                v[cur * 3] = true; 
                q.offer(new int[]{cur * 3 , dist + 1});
            }
        }
        return -1;
    }
}