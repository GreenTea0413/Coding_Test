class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = (i * columns) + j + 1;
            }
        }
        
        for(int i = 0; i < queries.length; i++){
            int[] q = queries[i];
            
            int x1 = q[0] - 1; int y1 = q[1] - 1; int x2 = q[2] - 1; int y2 = q[3] - 1;
            int temp = arr[x1][y1];
            int min = arr[x1][y1];
            // 왼쪽, 아래, 오른쪽, 위
            for(int x = x1; x < x2; x++) {arr[x][y1] = arr[x + 1][y1]; 
                                          min = Math.min(min, arr[x + 1][y1]);}
            for(int y = y1; y < y2; y++) {arr[x2][y] = arr[x2][y + 1]; 
                                          min = Math.min(min, arr[x2][y + 1]); }
            for(int x = x2; x > x1; x--) {arr[x][y2] = arr[x - 1][y2]; 
                                          min = Math.min(min, arr[x - 1][y2]); }
            for(int y = y2; y > y1; y--) {arr[x1][y] = arr[x1][y - 1];
                                          min = Math.min(min, arr[x1][y - 1]);}
            arr[x1][y1 + 1] = temp;
            answer[i] = min;
        }
        return answer;
    }
}