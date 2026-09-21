class Solution {
    int len;
    public int solution(int sticker[]) {
        len = sticker.length;
        if(len == 1) return sticker[0];
        
        return Math.max(dp(0, len - 2, sticker), dp(1, len - 1, sticker));
    }
    
    int dp (int start, int end, int[] sticker){
        // 만약에 같으면 이렇게 종료 시켜줘야함
        if(start == end) return sticker[start];
        
        int gap = end - start + 1;
        int[] arr = new int[gap];
        
        arr[0] = sticker[start];
        arr[1] = Math.max(arr[0], sticker[start + 1]);
        
        for(int i = 2; i < gap; i++){
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + sticker[start + i]);
        }
        
        return arr[gap - 1];
    }
}