class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            answer = lcm(arr[i], answer);
        }
           
        return answer;
    }
    
    // 최소 공배수
    public int lcm (int a, int b){
        return a / gcd(a, b) * b;
    }
    
    
    // 최대 공약수 먼저 구하기
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}