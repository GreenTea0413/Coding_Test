import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minPQ = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        
        for(String op : operations){
            String[] arr = op.split(" ");
            
            // 일단 들어오면 둘 다 넣기
            if(arr[0].equals("I")){
                minPQ.offer(Integer.parseInt(arr[1]));
                maxPQ.offer(Integer.parseInt(arr[1]));
            }
            else{
                if(!minPQ.isEmpty()){
                    if(arr[1].equals("1")){
                        int temp = maxPQ.poll();
                        minPQ.remove(Integer.valueOf(temp));
                    }
                    else{
                        int temp = minPQ.poll();
                        maxPQ.remove(Integer.valueOf(temp));
                    }
                }
            }
        }
        
        if(!minPQ.isEmpty()){return new int[]{maxPQ.poll(), minPQ.poll()};}
        return answer;
    }
}