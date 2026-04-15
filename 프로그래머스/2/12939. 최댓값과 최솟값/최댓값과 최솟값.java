import java.util.*;
class Solution {
    public String solution(String s) {
        String[] temp = s.split(" ");
        int[] num = new int[temp.length];
        
        for(int i = 0; i < temp.length; i++){
            int n = Integer.parseInt(temp[i]);
            num[i] = n;
        }
        
        Arrays.sort(num);
        return String.valueOf(num[0]) + " " + String.valueOf(num[num.length - 1]);
    }
}