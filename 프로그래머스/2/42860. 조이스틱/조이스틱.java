class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();

        // 이거는 위아래 방향만 더하기
        for(int i = 0; i < len; i++){
            // A에서 Z갔다가 돌아서 가는거
            int z_gap = 'Z' - name.charAt(i) + 1;
            // A에서 출발 했을 때
            int a_gap = name.charAt(i) - 'A';
            
            if(z_gap >= a_gap){
                answer += a_gap;
            }
            else{
                answer += z_gap;
            }
        }
        
        // ZAAAAJAA
        // 01234567
        // 최대로 움직이게 되는 move
        int move = len - 1;
        for (int i = 0; i < len; i++){
            int next = i + 1;
            // 여기서 i = 0 일 때 next는 J 위치임 len - 1까지 가게됨
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            // next = 8
            move = Math.min(move, (len - next) + i * 2);
            move = Math.min(move, i + (len - next) * 2);
            
        }
        
        return answer + move;
    }
}