class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        
        long max1 = 0;
        long max2 = 0;
        for(int i = 0; i < sequence.length; i++){
            int val1 = sequence[i] * (i % 2 == 0 ? 1 : -1);
            int val2 = sequence[i] * (i % 2 == 0 ? -1 : 1);
            
            // max1이랑 val1 더하는게 점차 나아가는건데 더한 값보다 현재 val1이 더 크면 새로 시작
            max1 = Math.max(val1, val1 + max1);
            max2 = Math.max(val2, val2 + max2);
            
            answer = Math.max(answer, Math.max(max1, max2));
        }
        
        return answer;
    }
}