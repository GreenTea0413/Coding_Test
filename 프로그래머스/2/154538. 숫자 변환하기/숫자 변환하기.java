import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, 0});
        Set<Integer> set = new HashSet<>();
        set.add(x);
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == y) return now[1];
            
            int n1 = now[0] + n;
            int n2 = now[0] * 2;
            int n3 = now[0] * 3;
            
            if(!set.contains(n1) && n1 <= y) {set.add(n1); q.offer(new int[]{n1, now[1] + 1});}
            if(!set.contains(n2) && n2 <= y) {set.add(n2); q.offer(new int[]{n2, now[1] + 1});}
            if(!set.contains(n3) && n3 <= y) {set.add(n3); q.offer(new int[]{n3, now[1] + 1});}
        }
        return -1;
    }
}