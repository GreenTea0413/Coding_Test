class Solution {
    public int[] solution(int[][] arr) {
        int n = arr.length;
        return compress(arr, 0, 0, n);
    }
    
    public int[] compress(int[][] arr, int x, int y, int len){
        int sum = 0;
        int max = len * len;
        
        for(int i = x; i < x + len; i++){
            for(int j = y; j < y + len; j++){
                sum += arr[i][j];
            }
        }
        
        if(sum != 0 && sum != max){
            return quad(arr, x, y, len / 2);
        }
        return sum == 0 ? new int[]{1, 0} : new int[]{0, 1};
    }
    
    public int[] quad(int[][] arr, int x, int y, int half){
        int[] a = {0, 0};
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                int[] result = compress(arr, x + i * half, y + j * half, half);
                a[0] += result[0];
                a[1] += result[1];
            }
        }
        
        return a;
    }
}