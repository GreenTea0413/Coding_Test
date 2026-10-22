class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        answer = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            answer = cho(answer, arr[i]);
        }
        return answer;
    }
    
    int cho(int a, int b){
        return a / gcd(a, b) * b;
    }
    
    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    
}