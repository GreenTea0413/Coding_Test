class Solution {
    int answer = 0;
    String[] datas;
    public int solution(int n, String[] data) {    
        datas = data;
        permute(new String[] {"A", "C", "F", "J", "M", "N", "R", "T"}, 0, new String[8], new boolean[8]);
    
        return answer;
    }
    
    public void permute(String[] name, int depth, String[] now, boolean[] v){
        if(depth == 8){
            if(check(now)){answer++;}
            return;
        }
        
        for(int i = 0; i < 8; i++){
            if(!v[i]){
                v[i] = true;
                now[depth] = name[i];
                
                permute(name, depth + 1, now, v);
                
                now[depth] = "";
                v[i] = false;
            }
        }
    }
    
    public boolean check(String[] now) {
        for (String d : datas) {
            String[] s = d.split("");

            int num1 = -1, num2 = -1;
            for (int i = 0; i < 8; i++) {
                if (s[0].equals(String.valueOf(now[i]))) num1 = i;
                if (s[2].equals(String.valueOf(now[i]))) num2 = i;
            }

            int gap = Integer.parseInt(s[4]);
            int dist = Math.abs(num1 - num2) - 1;

            if (s[3].equals("=")) {
                if (dist != gap) return false;
            } else if (s[3].equals(">")) {
                if (dist <= gap) return false;
            } else { 
                if (dist >= gap) return false;
            }
        }
        return true;
    }
}