class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        if(len == 3) return Math.max(Math.max(money[0], money[1]), money[2]);
        
        int dp1 = dp(money, 0, len - 2);
        int dp2 = dp(money, 1, len - 1);
        
        return Math.max(dp1, dp2);
    }
    
    int dp(int[] money, int start, int end){
        if(start == end) return money[start];
        
        int len = end - start + 1;
        int[] arr = new int[len];
        arr[0] = money[start];
        arr[1] = Math.max(money[start], money[start + 1]);
        // 이렇게 하면 
        // arr 에는 1 2가 됨
        // arr[1]은 그러면 arr[2]를 당연히 못 고르겠죠?
        for(int i = 2; i < len; i++){
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + money[start + i]);
        }
        
        return arr[len - 1];
    }
}