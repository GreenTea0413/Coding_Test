class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int len = arrayA.length;
        // 음 그러니까 arrayA의 최소공배수와 arrayB의 최소공배수를 구하라?
        // 구하고나면 이걸로 최소 공배수가 다른 배열의 값을 나눌 수 있는지 확인해라?
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int a : arrayA) gcdA = gcd(gcdA, a);
        for(int b : arrayB) gcdB = gcd(gcdB, b);
        
        if(isDivide(arrayA, gcdB)) answer = Math.max(answer, gcdB);
        if(isDivide(arrayB, gcdA)) answer = Math.max(answer, gcdA);
        
        return answer;
    }
    
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    public boolean isDivide(int[] arr, int n){
        for(int a : arr){
            if(a % n == 0) return false;
        }
        return true;
    }
    
}