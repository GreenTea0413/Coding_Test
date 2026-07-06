import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> maxP = new PriorityQueue<>((a, b) -> (b - a));
        PriorityQueue<Integer> minP = new PriorityQueue<>();
        
        for(String op : operations){
            String[] s = op.split(" ");
            int n = Integer.parseInt(s[1]);
            
            if(s[0].equals("I")){
                maxP.offer(n);
                minP.offer(n);
            }
            else{
                if(maxP.isEmpty()) continue;
                if(n == 1){
                    int m = maxP.poll();
                    minP.remove(Integer.valueOf(m));
                }
                else{
                    int m = minP.poll();
                    maxP.remove(Integer.valueOf(m));
                }
            }
        }
        
        if(!maxP.isEmpty()){
            answer[0] = maxP.poll();
            answer[1] = minP.poll();
        }
        return answer;
    }
}