class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        // A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
        // 1  2. 3  4. 5. 6. 7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
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
        
        // 좌우 ZAAAAAAJ
        int move = len - 1;
        for (int i = 0; i < len; i++){
            int next = i + 1;
            
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            move = Math.min(move, i * 2 + len - next);
            move = Math.min(move, (len - next) * 2 + i);
        }
        
        return answer + move;
    }
}