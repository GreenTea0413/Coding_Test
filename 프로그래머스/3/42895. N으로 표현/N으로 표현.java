import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= 8; i++) list.add(new HashSet<>());
        
        // 5
        // 5 / 55 10 0 25 1
        for(int i = 1; i <= 8; i++){
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            list.get(i).add(num); // 5 55 555
            
            for(int j = 1; j < i; j++){
                for(int n1 : list.get(j)){
                    for(int n2 : list.get(i - j)){
                        list.get(i).add(n1 * n2);
                        list.get(i).add(n1 + n2);
                        list.get(i).add(n1 - n2);
                        
                        if(n2 != 0) list.get(i).add(n1 / n2);
                    }
                }
            }
            
            if(list.get(i).contains(number)) return i;
        }
        return -1;
    }
}