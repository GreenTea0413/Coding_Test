class Solution {
    public int solution(int n) {
        int answer = n + 1;
        
        while(true){
            if(isCheck(n, answer)){ return answer;}
            answer += 1;
        }
    }
    
    public boolean isCheck (int n, int next){
        if (toBin(n) == toBin(next)) return true;
        return false;
    }
    
    public int toBin(int num){
        int countOne = 0;
        
        while(num > 0){
            int r = num % 2;
            if (r == 1){
                countOne += 1;
            }
            num /= 2;
        }
        return countOne;
    }
}