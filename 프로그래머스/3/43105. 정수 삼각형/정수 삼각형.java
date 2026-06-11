class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int xLen = triangle.length - 1;
        
        for(int i = xLen; i > 0; i--){
            int yLen = triangle[i].length;
            for(int j = 0; j < yLen - 1; j++){
                triangle[i - 1][j] = Math.max(triangle[i][j], triangle[i][j + 1]) + triangle[i - 1][j];
            }
        }
        
        return triangle[0][0];
    }
}