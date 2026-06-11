import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] dir = {{1,0}, {0,1}, {-1,-1}};
        List<Integer> answer = new ArrayList<>();
        
        int[][] arr = new int[n][n];
        int d = 0;
        int x = -1;
        int y = 0;
        int count = 1;
        int k = n;
        while(k > 0){
            for(int i = 0; i < k; i++){
                x += dir[d][0];
                y += dir[d][1];
                arr[x][y] = count;
                count++;
            }
            k--;
            d = (d + 1) % 3;
        }
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] != 0){answer.add(arr[i][j]);}
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}