class Solution {
    public int[] solution(int[][] arr) {
        int n = arr.length;
        // 0,0 부터 시작해서 길이 4
        return compress(arr, 0, 0, n);
    }
    
    // 압축가능한지 확인하기
    public int[] compress(int[][] arr, int startX, int startY, int len){
        int sum = 0;
        int max = len * len;
        for(int i = startX; i < startX + len; i++){
            for(int j = startY; j < startY + len; j++){
                sum += arr[i][j];
            }
        }
        // 압축 실패했으니 4등분 하러 가기
        if (sum != 0 && sum != max){
            return quad(arr, startX, startY, len / 2);
        }
        return (sum == 0) ? new int[]{1,0} : new int[]{0,1};
    }
    
    public int[] quad(int[][] arr, int startX, int startY, int halfLen){
        int[] answer = {0, 0};       
        
        for(int i = 0; i < 2; i++){
            for(int j =0; j < 2; j++){
                // 0,0 길이 2 / 0,2 길이 2 / 2,0 길이 2 / 2, 2 길이 2
                int[] result = compress(arr, startX + i * halfLen, startY + j * halfLen, halfLen);          
                answer[0] += result[0];
                answer[1] += result[1];
            }
        }
        
        return answer;
    }
}