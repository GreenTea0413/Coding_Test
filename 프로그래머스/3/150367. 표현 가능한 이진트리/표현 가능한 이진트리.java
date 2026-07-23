class Solution {
    public int[] solution(long[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        for(int i = 0 ; i < len; i++){
            String bin = Long.toBinaryString(numbers[i]);
            
            // 트리는 꽉 채우는걸로 해야하고 차피 비어있으면 그만큼 + 0 해주면 됨
            int size = 1;
            while(size < bin.length()){
                size = size * 2 + 1;
            }
            
            while(bin.length() < size){
                bin = "0" + bin;
            }
            
            // 이러면 원래 7이면 111이니까 size 가 3일 때 안돌아감
            // 0 추가되는거 없이
            answer[i] = check(bin, 0, size - 1) ? 1 : 0;
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