import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> {return b - a;});
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        
        for(String op : operations){
            String[] arr = op.split(" ");
            int num = Integer.valueOf(arr[1]);
            if(arr[0].equals("I")){
                maxQ.offer(num);
                minQ.offer(num);
            }
            else{
                if(!maxQ.isEmpty()){
                    if(num == 1){
                        int temp = maxQ.poll();
                        minQ.remove(Integer.valueOf(temp));
                    }
                    else{
                        int temp = minQ.poll();
                        maxQ.remove(Integer.valueOf(temp));
                    }
                }
            }
        }
        
        if(maxQ.size() == 0) return answer;
        answer[0] = maxQ.poll();
        answer[1] = minQ.poll();
        return answer;
    }
}