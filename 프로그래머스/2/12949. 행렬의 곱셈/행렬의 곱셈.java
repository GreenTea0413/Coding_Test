class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int xLen = arr1.length;
        int yLen = arr1[0].length;
        int zLen = arr2[0].length;
        int[][] answer = new int[xLen][zLen];
        
        for(int i = 0; i < xLen; i++){
            for(int j = 0; j < zLen; j++){
                for(int k = 0; k < yLen; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}