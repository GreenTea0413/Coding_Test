class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        if(len == 1) return sticker[0];
        
        // 시작점을 기준으로 어차피 0이면 len - 2까지 밖에 못씀
        // 반대로 1이면 len - 1까지 밖에 못씀
        int num1 = dp(sticker, 0, len - 2);
        int num2 = dp(sticker, 1, len - 1);
    
        return Math.max(num1, num2);
    }
    
    public int dp (int[] sticker, int start, int end){
        if(start == end) return sticker[start];
        
        int len = end - start + 1;
        int[] arr = new int[len];
        arr[0] = sticker[start];
        arr[1] = Math.max(arr[0], sticker[start + 1]);
        
        for(int i = 2; i < len; i ++){
            arr[i] = Math.max(arr[i - 2] + sticker[start + i], arr[i - 1]);
        }
        
        return arr[len - 1];
    }
}