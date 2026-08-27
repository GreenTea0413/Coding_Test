class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr1[0].length;
        int l = arr2[0].length;
        int[][] answer = new int[n][l];
        // 2 3 2 arr1의 첫번째 칸에 대해서
        // arr2의 각 칸에 대해서 첫번재 값을 곱해서 넣어야함
        // 2 [5 4 3]  
        // 3 [2 4 1]
        // 2 [3 1 1]
        // arr1의 i 번째 값을 가져와야하고 [2 3 2]
        // arr2는 arr1[0].length 만큼 반복하고 넣어줘야함
        // i = 0일 때 arr[0][0] * arr2[0][0] / arr1[0][1] * arr2[1][0] / arr1[0][2] * arr2[2][0]
        // answer[0][0]에 넣어야함
        // i = 1일 떄 arr[1][0] * arr2[0][1] / arr1[1][1] * arr2[1][1] / arr1[1][2] * arr2[2][1]
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < l; j++){
                for(int k = 0; k < m; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}