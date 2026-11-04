class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        dfs(begin, target, words, new boolean[words.length], 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    void dfs(String begin, String target, String[] words, boolean[] v, int count){
        if(begin.equals(target)) {
            answer = Math.min(count, answer);
            return; 
        }
        
        for(int i = 0; i < words.length; i++){
            // 안쓴거 && 글자 하나만 차이나는거
            if(!v[i] && check(begin, words[i])){
                v[i] = true;
                dfs(words[i], target, words, v, count + 1);
                v[i] = false;
            }
        }
    }
    
    boolean check(String a, String b){
        int l = a.length();
        int count = 0;
        for(int i = 0; i < l; i++){
            if(a.charAt(i) != b.charAt(i)) count++;
            if(count > 1) return false;
        }
        return true;
    }
}