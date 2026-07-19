import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        //어떤 사원이 다른 임의의 사원보다 두 점수가 모두 낮은 경우가 한 번이라도 있다면 그 사원은 인센티브를 받지 못함
        // 1등 2명이면 2등없이 3등
        // 0번째가 완호의 석차임
        int[] wanho = scores[0];
        int len = scores.length;
        
        // 앞에 배열이 큰 순서대로 놓고 그 다음 하나씩 비교할때
        // 뒤의 점수가 만약에 최대값 보다 작을 때 완호랑 비교
        Arrays.sort(scores, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        
        int maxSecond = 0;
        int wanhoSum = wanho[0] + wanho[1];;
        int rank = 1;
        for(int[] score : scores){
            if(score[1] < maxSecond){
                if(score[0] == wanho[0] && score[1] == wanho[1]){
                    return -1;
                } continue;
            }
            
            maxSecond = Math.max(maxSecond, score[1]);
            if(score[0] + score[1] > wanhoSum){rank++;}
        }
        return rank;
    }
}