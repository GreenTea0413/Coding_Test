import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            String head1 = getHead(a);
            String head2 = getHead(b);
            
            int headCompared = head1.toLowerCase().compareTo(head2.toLowerCase());
            if(headCompared != 0) return headCompared;
            
            int num1 = getNumber(a);
            int num2 = getNumber(b);
            
            return num1 - num2;
        });
        return files;
    }
    
    
    public String getHead(String str){
        int i = 0;
        while(i < str.length() && !Character.isDigit(str.charAt(i))){
            i++;
        }
        return str.substring(0, i);
    }
    
    public int getNumber(String str){
        int i = 0;
        while(i < str.length() && !Character.isDigit(str.charAt(i))){
            i++;
        }
        
        int start = i;
        while(i < str.length() && Character.isDigit(str.charAt(i)) && (i - start) < 5){
            i++;
        }
        return Integer.parseInt(str.substring(start, i));
    }
}