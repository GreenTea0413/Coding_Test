import java.util.*;

class Solution {
    // 최대큐 최소큐 2개 만들어서 작성
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        
        for(String op : operations){
            String[] str = op.split(" ");
            
            if(str[0].equals("I")){
                int num = Integer.parseInt(str[1]);
                maxQ.offer(num);
                minQ.offer(num);
            }
            
            else{
                // 16 -5643
                // -5643 16
                if(maxQ.isEmpty() || minQ.isEmpty()) continue;
                
                if (str[1].equals("1")){
                    int max = maxQ.poll();
                    minQ.remove(max);
                }
                else{
                    int min = minQ.poll();
                    maxQ.remove(min);
                }
            }
        }
        
        if (maxQ.isEmpty()) return new int[]{0,0};
        return new int[] {maxQ.peek(), minQ.peek()};
    }
}