class Solution {
    public int[] solution(long[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        for(int i = 0; i < numbers.length; i++){
            String bin = Long.toString(numbers[i], 2);
            
            int size = 1;
            // 1 3 7 15
            while(size < bin.length()) size = size * 2 + 1;
            while(bin.length() < size) bin = "0" + bin;
            
            if(check(bin, 0, size - 1)) answer[i]++;
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