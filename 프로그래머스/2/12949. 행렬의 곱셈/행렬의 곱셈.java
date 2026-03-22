class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 배열 2개가 주어지면
        // 1의 전체길이, 2[0]의 길이, 1[0]의 길이
        // i -> n, j -> m , t -> k
        // answer[i][j] = 1[i][t] + 2[t][j];
        int n = arr1.length;
        int m = arr2[0].length;
        int k = arr1[0].length;
        int[][] answer = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int t = 0; t < k; t++){
                    answer[i][j] += arr1[i][t] * arr2[t][j];
                }
            }
        }
        return answer;
    }
}