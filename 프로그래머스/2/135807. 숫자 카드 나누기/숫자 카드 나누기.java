class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int a : arrayA) gcdA = gcd(gcdA, a);
        for(int b : arrayB) gcdB = gcd(gcdB, b);
        
        int answer = 0;
        if(divide(arrayA, gcdB)) answer = Math.max(answer, gcdB);
        if(divide(arrayB, gcdA)) answer = Math.max(answer, gcdA);
        
        return answer;
    }
    public int gcd (int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    public boolean divide(int[] arr, int n){
        for(int a : arr){
            if(a % n == 0){
                return false;
            }
        }
        
        return true;
    }
}