class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        return count(h2, m2, s2) - count(h1, m1, s1) + (isOverlap(h1, m1, s1) ? 1 : 0);
    }
    
    // 0시 0분 0초부터 h시 m분 s초까지 겹치는 횟수
    public int count(int h, int m, int s) {
        // 총 초
        int total = h * 3600 + m * 60 + s;
        
        // 초침 vs 분침: 5.9도/초 차이, 360/5.9 = 720/11.8 초마다 겹침
        // 초침 vs 시침: (6 - 1/120)도/초 차이 = 719/120도/초
        
        // 겹치는 횟수 = (int)(total / 주기)
        // 초침 vs 분침 주기: 360/5.9 = 3600/59
        int secMin = (int)((long)total * 59 / 3600);
        
        // 초침 vs 시침 주기: 360 / (719/120) = 43200/719
        int secHour = (int)((long)total * 719 / 43200);
        
        // 12시 정각 (0시 포함) 겹치는 횟수 (셋 다 겹칠 때 중복 방지)
        // 12시간마다 1번 → 43200초마다
        int both = (int)((long)total / 43200);
        
        return secMin + secHour - both;
    }
    
    // 특정 시각에 겹치는지 확인
    public boolean isOverlap(int h, int m, int s) {
        // 각도 계산 (소수점 정밀도 위해 정수로)
        // 초침: 6도/초 * total초
        // 분침: 0.1도/초 * total초
        // 시침: 1/120도/초 * total초
        
        int total = h * 3600 + m * 60 + s;
        
        // 43200초 기준으로 나머지 (12시간 주기)
        total = total % 43200;
        
        // 초침 각도 * 120 (정수화)
        long sec = (long)total * 720;
        // 분침 각도 * 120
        long min = (long)total * 12;
        // 시침 각도 * 120
        long hour = (long)total;
        
        sec = sec % 43200;
        min = min % 43200;
        
        return sec == min || sec == hour;
    }
}