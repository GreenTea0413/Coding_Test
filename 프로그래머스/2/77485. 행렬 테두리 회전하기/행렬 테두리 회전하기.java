import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int[][] arr = new int[rows][columns];
        
        // 1,2,3,4,5,6
        // 7,8,9,... 채워주기
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = i * columns + j + 1;
            }
        }
        
        for(int[] q : queries){
            // 2,2,5,4
            // 실제로는 [1][1] ~ [4][3]까지임
            int startX = q[0] - 1;
            int startY = q[1] - 1;
            int endX = q[2] - 1;
            int endY = q[3] - 1;
            
            // 시작점을 기준으로 한칸씩 당기기
            int start = arr[startX][startY];
            
            // 최소값을 구하기 위한 값
            int min = start;
            
            // 왼쪽 라인부터 위로 한칸씩
            for(int x = startX; x < endX; x++){
                arr[x][startY] = arr[x + 1][startY];
                min = Math.min(arr[x + 1][startY], min);
            }
            
            // 밑 라인 왼쪽으로
            for(int y = startY; y < endY; y++){
                arr[endX][y] = arr[endX][y + 1];
                min = Math.min(arr[endX][y + 1], min);
            }
            
            // 으론쪽 라인 아래로
            for(int x = endX; x > startX; x--){
                arr[x][endY] = arr[x - 1][endY];
                min = Math.min(arr[x - 1][endY], min);
            }
            
            // 이제 마지막 윗라인 오른쪽으로
            for(int y = endY; y > startY; y--){
                arr[startX][y] = arr[startX][y - 1];
                min = Math.min(arr[startX][y - 1], min);
            }
            
            //여기서 다시 8넣어주기
            arr[startX][startY + 1] = start;
            answer.add(min);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}