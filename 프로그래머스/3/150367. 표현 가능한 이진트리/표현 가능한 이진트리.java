class Solution {
    public int[] solution(long[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++){
            String bin = Long.toBinaryString(numbers[i]);
            
            int size = 1;
            while(size < bin.length()){
                size = size * 2 + 1;
            }
            
            while(bin.length() < size){
                bin = "0" + bin;
            }
            
            answer[i] = check(bin, 0, size - 1) ? 1 : 0;
        }
        return answer;
    }
    
    // 여기서 이제 말도 안되는 루트가 있으면 false;
    boolean check(String s, int left, int right){
        if(left == right) return true;
        
        int mid = (left + right) / 2;
        char root = s.charAt(mid);
        
        if(root == '0'){
            int leftMid = (left + mid - 1) / 2;
            int rightMid = (right + mid + 1) / 2;
            
            if(s.charAt(leftMid) == '1' || s.charAt(rightMid) == '1'){return false;}
        }
        
        return check(s, left, mid - 1) && check(s, mid + 1, right);
    }
}