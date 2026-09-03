class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        // 일단 전체를 더했을 때 칸 수와 같지않다면? 나눠야함
        // 그게 아니라면 해당 값이 0이면 answer[0]++, 다시 칸수와 같다면? answer[1] ++;
        int len = arr.length;
        calculate(arr, len, 0, 0);
        
        return answer;
    }
    
    void calculate(int[][] arr, int len, int x, int y){
        int sum = 0;
        for(int i = x; i < x + len; i++){
            for(int j = y; j < y + len; j++){
                sum+= arr[i][j];
            }
        }
        
        if(sum == 0) answer[0]++;
        else if(sum == len * len) answer[1]++;
        else{
            // 여기서는 이제 절반으로 나눠서 보내야함
            // len / 2를 기점으로 다시 점검하도록 해야함
            quater(arr, len / 2, x, y);
        }
    }
    
    void quater(int[][] arr, int half, int x, int y){
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                calculate(arr, half, x + half * i, y + half * j);
            }
        }
    }
    
}