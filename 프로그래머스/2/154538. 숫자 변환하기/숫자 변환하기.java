import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[] v = new boolean[y + 1];
        
        q.offer(new int[]{x, 0});
        v[x] = true;
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int num = arr[0], dist = arr[1];
            
            if(num == y){return dist;}
            
            int num1 = num + n;
            if(num1 <= y && !v[num1]){q.offer(new int[]{num1, dist + 1}); v[num1] = true;}
            
            int num2 = num * 2;
            if(num2 <= y && !v[num2]){q.offer(new int[]{num2, dist + 1}); v[num2] = true;}
            
            int num3 = num * 3;
            if(num3 <= y && !v[num3]){q.offer(new int[]{num3, dist + 1}); v[num3] = true;}
        }
        
        
        return answer;
    }
}