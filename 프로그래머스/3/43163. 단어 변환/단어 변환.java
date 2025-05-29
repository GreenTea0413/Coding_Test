class Solution {
    boolean [] v;
    int answer = 51;
    void dfs(String start, String end, String[] words, int count){
        if(start.equals(end)){
            answer = Math.min(answer,count);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            String w = words[i];
            int num = 0;
            String t = "";
            for(int j = 0; j < w.length(); j++){
                if(start.charAt(j) != w.charAt(j)){
                    t += w.charAt(j);
                    num++;
                }
                else{
                    t+= start.charAt(j);
                }
            }
            if(num == 1 && !v[i]){
                v[i] = true;
                dfs(t,end,words,count+1);
                v[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        v = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        if(answer == 51) answer = 0;
        return answer;
    }
}