import java.util.*;

public class Solution {
    public int solution(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        if(n % 2 == 0) return solution(n / 2);
        else return solution(n / 2) + 1;
    }
}