class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 시침/분침 - 초침과 동일하면 알람 / 동시에 해도 1번
        // 24 * 3600 = 충분하겟네
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;
        
        int answer = (start == 0 || start == 43200) ? 1 : 0;
        // 각도 값
        // h는 1시간에 30도 1분에 0.5도 1초에 0.5 / 60도
        // m는 1시간에 360도 1분에 6도 1초에 0.1도
        
        // 초당 움직이는 걸로 계산하기
        for(int i = start; i < end; i++){
            double hA = hAngle(i);
            double mA = mAngle(i);
            double sA = sAngle(i);
            
            double nhA = hAngle(i + 1); if(nhA == 0) nhA = 360;
            double nmA = mAngle(i + 1); if(nmA == 0) nmA = 360;
            double nsA = sAngle(i + 1); if(nsA == 0) nsA = 360;
            
            boolean h = (hA > sA && nhA <= nsA);
            boolean m = (mA > sA && nmA <= nsA);
            
            if(h) answer++;
            if(m) answer++;
            if(h && m && nmA == nhA) answer--;
        }
        return answer;
    }
    
    // 3905 - > 1시간 5분 5초
    // 13시 일때? 
    double hAngle(int time){
        int h = time / 3600; int m = (time % 3600) / 60; int s = (time % 60);
        double angle = h * 30 + m * 0.5 + (s * 0.5) / 60;
        
        if(angle >= 360) angle = angle - 360;
        return angle;
    }
    double mAngle(int time){
        int m = (time % 3600) / 60; int s = time % 60;
        double angle = m * 6 + s * 0.1;
        
        if(angle >= 360) angle = angle - 360;
        return angle;
    }
    double sAngle(int time){
        int s = (time % 60);
        double angle = s * 6;
        
        return angle;
    }
}