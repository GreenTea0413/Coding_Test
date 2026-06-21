import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int len = scores.length;
        
        Arrays.sort(scores, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        
        // [3,2], [3,2], [2,1], [2,2], [1,4]
        int maxSecond = 0;
        int rank = 1;
        int wanhoSum = wanho[0] + wanho[1];
        for(int[] score : scores){
            
            if(score[1] < maxSecond){
                if(score[0] == wanho[0] && score[1] == wanho[1]){
                    return -1;
                }
                continue;
            }
            
            maxSecond = Math.max(maxSecond, score[1]);
            if(score[0] + score[1] > wanhoSum){rank++;}
        }
        
        return rank;
    }
}