class Solution {
    public int solution(String name) {
        int answer = 0;
        
        // 글자 위아래로 움직이기
        for(char c : name.toCharArray()){
            int zGap = 'Z' - c + 1;
            int aGap = c - 'A';
            
            if(zGap >= aGap){answer += aGap;}
            else{answer+= zGap;}
        }
        
        int len = name.length();
        int move = len - 1;
        for(int i = 0; i < len; i++){
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A'){
                next ++;
            }
            
            move = Math.min(move, i * 2 + (len - next));
            move = Math.min(move, i + (len - next) * 2);
        }
        
        return answer + move;
    }
}