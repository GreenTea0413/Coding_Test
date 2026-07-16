class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        
        left[0] = a[0];
        for(int i = 1; i < len; i++){
            left[i] = Math.min(left[i - 1], a[i]);
        }
        
        right[len - 1] = a[len - 1];
        for(int i = len - 2; i >= 0; i--){
            right[i] = Math.min(right[i + 1], a[i]);
        }
        
        for(int i =0; i < len;i++){
            if(a[i] <= left[i] || a[i] <= right[i]){
                answer++;
            }
        }
        return answer;
    }
}