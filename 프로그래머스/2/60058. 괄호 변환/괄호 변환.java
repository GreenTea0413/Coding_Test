class Solution {
    public String solution(String p) {
        if(p.equals("")) return "";
        
        String answer = "";
        int left = 0;
        int right = 0;
        int idx = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(') left++;
            else right++;
            if(left == right){
                idx = i;
                break;
            }
        }
        
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);
        
        // 앞에 자른게 올바른거면 이렇게 다시 시작
        if(isCheck(u)){
            return u + solution(v);
        }
        
        // 아니면
        String temp = "(" + solution(v) + ")";
        
        // u 앞뒤 제거 + 뒤집기
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < u.length() - 1; i++){
            if(u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }

        return temp + sb.toString();
    }
    
    public boolean isCheck(String u){
        int count = 0;
        for(char c : u.toCharArray()){
            if(c == '(') count++;
            else count--;
            if(count < 0) return false;
        }
        
        return count == 0;
    }
}