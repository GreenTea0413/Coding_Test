import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number){return 1;}
        
        List<Set<Integer>> set = new ArrayList<>();
        for(int i = 0; i <= 8; i++){set.add(new HashSet<>());}
        
        for(int i = 1; i <= 8; i++){
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            set.get(i).add(num);
            
            for(int j = 1; j < i; j++){
                for(int n1 : set.get(j)){
                    for(int n2 : set.get(i - j)){
                        set.get(i).add(n1 + n2);
                        set.get(i).add(n1 - n2);
                        set.get(i).add(n1 * n2);
                        if(n2 != 0) set.get(i).add(n1 / n2);
                    }
                }
            }
            if(set.get(i).contains(number)) return i;
        }
        
        
        
        
        return -1;
    }
}