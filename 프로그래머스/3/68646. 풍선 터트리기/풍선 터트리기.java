class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
    
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = a[0];
        right[len - 1] = a[len - 1];
        
        // 이렇게 왼쪽 오른쪽해서 현 위치보다 작으면
        // [9, 0, 0]인데 [9, -1, -5]
        for(int i = 1; i < len; i++){
            left[i] = Math.min(left[i - 1], a[i]);
        }
        
        // 이건 오른쪽에서 왼쪽으로
        // [-5, -5, -5]
        for(int i = len - 2; i >= 0; i--){
            right[i] = Math.min(a[i], right[i + 1]);
        }
        
        for(int i = 0; i < len; i++){
            if(a[i] == left[i] || a[i] == right[i]){
                answer++;
            }
        }
        return answer;
    }
}