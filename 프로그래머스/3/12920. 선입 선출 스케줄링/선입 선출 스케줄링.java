class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
      
        // 일하는 시간에서 / core를 했을 때 나머지가 0이면 일 할 수 있음
        // 일단 처음에는 cores개수만큼 다 들어야함
        // 그리고 50000 * 10000하면 시간초과 발생하니까 시간으 이분탐색으로 미리 찾기
        long left = 0;
        long right = 10000 * n;
        long time = 0;
        int len = cores.length;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long count = len;
            
            for(int core : cores){
                count += mid / core;
            }
            
            if(count >= n){right = mid - 1; time = mid;}
            else {left = mid + 1;}
        }
        
        // 타임을 보다 1시간 전의 작업 개수를 구하고 거기서 부족한 만큼 다시 돌려서 처리해아함
        long rest = len;
        for(int core : cores){rest += (time - 1) / core;}
        rest = n - rest;
        
        for(int i = 0; i < len; i++){
            if(time % cores[i] == 0){
                rest -= 1;
                if(rest == 0) return i + 1;
            }
        }
        
        return answer;
    }
}