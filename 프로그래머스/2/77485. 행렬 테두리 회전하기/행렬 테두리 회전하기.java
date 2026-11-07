class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int len = queries.length;
        int[] answer = new int[len];
        
        int[][] arr = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = (i * columns + j + 1);
            }
        }
        
        for(int i = 0; i < len; i++){
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            
            int temp = arr[x1][y1]; 
            int min = temp;
            
            // ^
            for(int x = x1; x < x2; x++) 
            {arr[x][y1] = arr[x + 1][y1]; min = Math.min(min, arr[x + 1][y1]);}
            
            // <
            for(int y = y1; y < y2; y++) 
            {arr[x2][y] = arr[x2][y + 1]; min = Math.min(min, arr[x2][y + 1]);}
            
            // 아래
            for(int x = x2; x > x1; x--) 
            {arr[x][y2] = arr[x - 1][y2]; min = Math.min(min, arr[x - 1][y2]);}
            
            // >
            for(int y = y2; y > y1; y--) 
            {arr[x1][y] = arr[x1][y - 1]; min = Math.min(min, arr[x1][y - 1]);}
            
            // 빈자리 채워주기
            arr[x1][y1 + 1] = temp;
            
            // 그리고 최솟값 한거 넣어주기
            answer[i] = min;
        }
        return answer;
    }
}