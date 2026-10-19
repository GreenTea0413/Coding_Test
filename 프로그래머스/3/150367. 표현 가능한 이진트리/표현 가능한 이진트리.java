class Solution {
    public int[] solution(long[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++){
            String bin = Long.toBinaryString(numbers[i]);
            int size = 1;
            
            while(bin.length() > size){
                size = size * 2 + 1;
            }
            
            while(size > bin.length()){
                bin = "0" + bin;
            }
            
            if(check(bin, 0, size - 1)) answer[i] = 1;
            else answer[i] = 0;
        }
        
        
        return answer;
    }
    
    boolean check(String bin, int left, int right){
        if(left == right) return true;
        int mid = (left + right) / 2;
        
        if(bin.charAt(mid) == '0'){
            int leftMid = (left + mid - 1) / 2;
            int rightMid = (right + mid + 1) / 2;
            
            if(bin.charAt(leftMid) == '1' || bin.charAt(rightMid) == '1') return false;
        }
        
        return check(bin, left, mid - 1) && check(bin, mid + 1, right);
    }
}