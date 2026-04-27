class Solution {
    public long solution(int w, int h) {
        long W = (long) w;
        long H = (long) h;
        return (W * H) - (W + H - gcd(W, H));
    }
    
    public long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);    
    }
}