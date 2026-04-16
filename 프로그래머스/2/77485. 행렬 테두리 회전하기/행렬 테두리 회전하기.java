import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        
        int[][] arr = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                arr[i][j] = i * columns + j + 1;
            }
        }
        
        for(int[] query : queries){
            // 2,2  4,5
            int startX = query[1] - 1;
            int startY = query[0] - 1;
            int endX = query[3] - 1;
            int endY = query[2] - 1;
            
            // 8
            // 배열에서는 앞이 Y, 뒤가 X임
            int temp = arr[startY][startX];
            int min = temp;
            
            // 왼쪽
            for(int i1 = startY; i1 < endY; i1++){
                arr[i1][startX] = arr[i1 + 1][startX];
                min = Math.min(min, arr[i1][startX]);
            }
            
            // 아래쪽
            for(int i2 = startX; i2 < endX; i2++){
                arr[endY][i2] = arr[endY][i2 + 1];
                min = Math.min(min, arr[endY][i2]);
            }
            // 오른쪽
            for(int i3 = endY; i3 > startY; i3--){
                arr[i3][endX] = arr[i3 - 1][endX];
                min = Math.min(min, arr[i3][endX]);
            }
            
            // 위쪽
            for(int i4 = endX; i4 > startX + 1; i4--){
                arr[startY][i4] = arr[startY][i4 - 1];
                min = Math.min(min, arr[startY][i4]);
            }
            
            arr[startY][startX + 1] = temp;
            answer.add(min);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}