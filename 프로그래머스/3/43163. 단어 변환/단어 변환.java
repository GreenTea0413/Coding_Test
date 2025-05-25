class Solution {
    static int answer = 100;
    static boolean[] visited;
    public void dfs(String start, String end, String[] words, int count){
        if(start.equals(end)){
            answer = Math.min(answer, count);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            String w = words[i];
            String temp = "";
            int num = 0;
            for(int j = 0; j < w.length(); j++){
                if(w.charAt(j) != start.charAt(j)){
                    temp += w.charAt(j);
                    num ++;
                }
                else{
                    temp += start.charAt(j);
                }
            }
            if(num == 1 && !visited[i]) {
                visited[i] = true;
                dfs(temp,end,words,count+1);
                visited[i] = false;
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        if(answer == 100) answer = 0;
        return answer;
    }
}