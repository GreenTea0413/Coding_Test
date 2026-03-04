import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        
        // [0] = "2" [1] = "2,1" [2] = "2,1,3"
        String[] sets = s.replace("},{","a").split("a");
        Arrays.sort(sets, (a, b) -> a.split(",").length - b.split(",").length);
        
        List<Integer> answer = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        
        for(String set : sets){
            for(String c : set.split(",")){
                int num = Integer.parseInt(c);
                
                if(!visited.contains(num)){
                    answer.add(num);
                    visited.add(num);
                }
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}