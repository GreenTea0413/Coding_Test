import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        // 아래서 부터 위로 올라오면서 값을 저장하면 될거 같은데
        // 4 5 2 6 5 -> 먼저 4 5가 들어올 때 2랑 비교해서 더 큰값 넣기
        // 7 12 10 10 -> 아까 5칸인게 4칸됨
        // len = 5
        int len = triangle[triangle.length - 1].length;
        int layer = len - 1;
        int [] dp = new int[len];
        
        // dp는 길이가 5 -> 4 5 2 6 5가 들어가있는 상태
        for (int i = 0; i < len; i++){
            dp[i] = triangle[len - 1][i];
        }
        // 밑에 줄에서부터 위에 줄과 더했을 때 더 큰지 안큰지 비교
        // dp[i] = Maht.max(dp[i] + triangle[layer][i], dp[i + 1] + triangle[layer][i])
        // i는 0 ~ layer - 1까지 그래야 i가 안 넘어감
        // 4 5 2 6 5
        // 7 5 2 6 5

        while(layer > 0){
            for (int j = 0; j < layer; j++){
                dp[j] = Math.max(dp[j] + triangle[layer-1][j], dp[j + 1] + triangle[layer-1][j]);
            }
            
            layer--;
            
        }
        return dp[0];
    }
}