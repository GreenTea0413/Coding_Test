class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        
        if(len == 1) return sticker[0];
        if(len == 2) return Math.max(sticker[0], sticker[1]);
        
        int num1 = dp(sticker, 0, len - 2);
        int num2 = dp(sticker, 1, len - 1);

        return Math.max(num1, num2);
    }
    
    int dp(int[] sticker, int start, int end){
        // 0 6
        int len = end - start + 1;
        int[] arr = new int[len];
        arr[0] = sticker[start];
        arr[1] = Math.max(arr[0], sticker[start + 1]);
        
        for(int i = 2; i < len; i++){
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + sticker[start + i]);
        } 
        
        return arr[len - 1];
    }
}