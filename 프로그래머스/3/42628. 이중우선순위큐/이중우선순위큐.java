import java.util.*;

class Solution {
    public int[] solution(String[] operations) {        
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> (b - a));
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        for(String op : operations){
            String[] s = op.split(" ");
            
            if(s[0].equals("I")) {
                maxPQ.offer(Integer.parseInt(s[1]));
                minPQ.offer(Integer.parseInt(s[1]));
            }
            else{
                if(maxPQ.isEmpty()) continue;
                
                if(s[1].equals("-1")){
                    int min = minPQ.poll();
                    maxPQ.remove(Integer.valueOf(min));
                }
                else{
                    int max = maxPQ.poll();
                    minPQ.remove(Integer.valueOf(max));
                }
            }
        }
        
        int[] answer = new int[2];
        if(!maxPQ.isEmpty()) { 
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }
        return answer;
    }
}