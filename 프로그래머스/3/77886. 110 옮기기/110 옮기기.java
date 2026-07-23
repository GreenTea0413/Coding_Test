class Solution {
    public String[] solution(String[] s) {
        int len = s.length;
        String[] answer = new String[len];
        
        for(int i = 0; i < len; i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;
            String str = s[i];
            
            for(char c : str.toCharArray()){
                sb.append(c);
                
                if(sb.length() >= 3){
                    char c1 = sb.charAt(sb.length() - 3);
                    char c2 = sb.charAt(sb.length() - 2);
                    char c3  = sb.charAt(sb.length() - 1);
                
                    if(c1 == '1' && c2 == '1' && c3 == '0'){
                        sb.setLength(sb.length() - 3);
                        count++;
                    }
                }
            }
            
            // 1000000 이라면 0 마지막에 와야하니까 사전순으로 인해서 110 세트는 0뒤로 와야함
            int lastIdx = sb.lastIndexOf("0");
            StringBuilder result = new StringBuilder();
            
            // 만약에 없으면?
            if(lastIdx == -1){
                for(int k = 0; k < count; k++){
                    result.append("110");
                }
                result.append(sb);
            }
            else{
                result.append(sb.substring(0, lastIdx + 1));
                for(int k = 0; k < count; k++){
                    result.append("110");
                }
                result.append(sb.substring(lastIdx + 1));
            }
            answer[i] = result.toString();
        }
        
        return answer;
    }
}