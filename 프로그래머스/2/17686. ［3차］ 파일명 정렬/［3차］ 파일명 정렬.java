import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            String head1 = getHead(a);
            String head2 = getHead(b);
            
            int headCompared = head1.toLowerCase().compareTo(head2.toLowerCase());
            if(headCompared != 0) return headCompared;
            
            int num1 = getNum(a);
            int num2 = getNum(b);
            
            return num1 - num2;
        });
        return files;
    }
    
    String getHead(String file){
        int i = 0;
        while(i < file.length() && !Character.isDigit(file.charAt(i))){
            i++;
        }
        
        return file.substring(0, i);
    }
    
    int getNum(String file){
        int i = 0;
        while(i < file.length() && !Character.isDigit(file.charAt(i))){
            i++;
        }
        
        int start = i;
        while(i < file.length() && Character.isDigit(file.charAt(i))){
            i++;
        }
        
        return Integer.parseInt(file.substring(start, i));
    }
}