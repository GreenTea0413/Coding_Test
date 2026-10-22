class Solution {
    public int solution(int n) {
        int answer = n + 1;
        
        while(true){
            if(check(n, answer)) break;
            answer++;
        }
        return answer;
    }
    
    public boolean check(int n, int answer){
        if(bin(n) == bin(answer)) return true;
        return false;
    }
    
    public int bin(int num){
        int count = 0;
        
        while(num > 0){
            int r = num % 2;
            
            if(r == 1) count ++;
            num = num / 2;
        }
        return count;
    }
}