class Solution {
    public String solution(String s) {
        int max = -Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] arr = s.split(" ");
        for(int i = 0; i < arr.length; i++){
            int n = Integer.parseInt(arr[i]);
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        return String.valueOf(min) + " " + String.valueOf(max);
    }
}