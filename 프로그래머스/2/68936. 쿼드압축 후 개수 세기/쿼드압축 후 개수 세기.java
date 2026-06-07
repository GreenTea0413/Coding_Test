class Solution {
    public int[] solution(int[][] arr) {
        // 1 / 2 씩 가로 세로 잘라서 4등분 한 다음 0, 1비교
        int len = arr.length;
        return compress(arr, 0, 0, len);
    }
    
    // 여기서 이제 네모가 오면 처음부터 시작점에서부터 len길이만큼 전체 합을 구하기
    // - 0이면 0 max면 1
    public int[] compress(int[][] arr, int x, int y, int len){
        int max = len * len;
        int sum = 0;
        for(int i = x; i < x + len; i++){
            for(int j = y; j < y + len; j++){
                sum += arr[i][j];
            }
        }
        
        if(sum != 0 && sum != max) return qurt(arr, x, y, len / 2);
        return (sum == max) ? new int[]{0, 1} : new int[]{1, 0};
    }
    
    public int[] qurt(int[][] arr, int x, int y, int half){
        int[] answer = new int[2];
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                int[] result = compress(arr, x + half * i, y + half * j, half);
                answer[0] += result[0];
                answer[1] += result[1];
            }
        }
        
        return answer;
    }
}