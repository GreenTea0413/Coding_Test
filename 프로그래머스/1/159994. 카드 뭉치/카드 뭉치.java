import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q = new LinkedList<>();
        for(String g : goal) q.offer(g);
        int n = cards1.length;
        int m = cards2.length;
        
        int idx1 = 0;
        int idx2 = 0;
        
        while(!q.isEmpty()){
            if(idx1 < n && cards1[idx1].equals(q.peek())) {q.poll(); idx1++;}
            else if(idx2 < m && cards2[idx2].equals(q.peek())){q.poll(); idx2++;}
            else return "No";
        }
        return "Yes";
    }
}
