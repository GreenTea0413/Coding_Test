class Solution {
    public int[] solution(long[] numbers) {
        int len =numbers.length;
        int[] answer = new int[len];
        
        // 이진트리 꽉찬 이진트리 사이즈는 1 3 7 ...
        for(int i = 0; i < len; i++){
            String bin = Long.toBinaryString(numbers[i]);
            
            int size = 1;
            while(size < bin.length()){
                size = size * 2 + 1;
            }
            
            while(bin.length() < size){
                bin = "0" + bin;
            }
            
            answer[i] = check(bin, 0, size - 1) ? 1 : 0 ;
        }
        return answer;
    }
    
    boolean check(String bin, int left ,int right){
        if(left == right) return true;
        
        int mid = (left + right) / 2;
        if(bin.charAt(mid) == '0'){
            int leftMid = (left + mid - 1) / 2;
            int rightMid = (right + mid + 1) / 2;
            
            if(bin.charAt(leftMid) == '1' || bin.charAt(rightMid) == '1'){return false;}
        }
        
        return check(bin, left, mid - 1) && check(bin, mid + 1, right);
    }
}