import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        // 우박 수열
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(k);
        while(k > 1){
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
            arr.add(k);
        }
        
        // 넓이구하고
        int n = arr.size() - 1;
        double[] sqr = new double[n];
        for(int i = 0; i < n; i ++){
            sqr[i] = (arr.get(i) + arr.get(i+1)) / 2.0;
        }
        
        // 각 범위별로 0,0 ~~ 현재 위치에 대한 총 넓이
        double[] total_sqr = new double[n + 1];
        for(int i = 0; i < n; i++){
            total_sqr[i + 1] = total_sqr[i] + sqr[i];
        }
        
        double[] answer = new double[ranges.length];
        for(int i = 0; i < ranges.length; i++){
            int a = ranges[i][0];
            int b = n + ranges[i][1];
            
            if (a > b) answer[i] = -1;
            else {answer[i] = total_sqr[b] - total_sqr[a];}
        }
        
        
        return answer;
    }
}