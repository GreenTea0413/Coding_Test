class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        // 그러니까 각각 배열에서 최대 공약수를 구한다음에 서로 배열에서 하나라도 못나누면 answer이 되는거임
        // 그리고 그 중에서 젤 큰거 찾으면 됨
        int a = arrayA[0];
        int b = arrayB[0];
        
        for(int a1 : arrayA) a = gcd(a1, a);
        for(int b1 : arrayB) b = gcd(b1, b);
        
        if(check(arrayA, b)) answer = Math.max(answer, b);
        if(check(arrayB, a)) answer = Math.max(answer, a);
        
        return answer;
    }
    
    // 최소공배수 a, b -> b == 0 이면 끝 못 나누니까 b, a % b이렇게 계속 좁혀가기
    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    boolean check(int[] arr, int num){
        for(int a : arr){
            if(a % num == 0) return false;
        }
        return true;
    }
}