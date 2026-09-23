class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        
        //  2 1 3 2 면 3 양옆에는 둘 다 작기 때문에 한번만 터트렸을 때 3은 1 터트리면 결국 못터트림
        // 그러면 왼쪽에서 쭈욱 오면서 최솟값을 구하기
        // 오른쪽에서도 쭈욱 오면서 최솟값 구하기
        // 그러고 이제 양쪽에 대해서 둘 다 최솟값이면 그 풍선은 못터트림
        
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = a[0];
        right[len - 1] = a[len - 1];
        
        for(int i = 1; i < len; i++) left[i] = Math.min(left[i - 1], a[i]);
        for(int i = len - 2; i >= 0; i--) right[i] = Math.min(right[i + 1], a[i]);
        
        for(int i = 0; i < len; i++){
            if(a[i] == left[i] || a[i] == right[i]) answer++;
        }
        return answer;
    }
}