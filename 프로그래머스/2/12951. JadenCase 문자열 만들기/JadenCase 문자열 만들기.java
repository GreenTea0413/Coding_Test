class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ", -1);
        int l = arr.length;
        
        for(int i = 0; i < l; i++){
            String temp = arr[i].toLowerCase();
            if(temp.length() > 0){
                sb.append(temp.substring(0, 1).toUpperCase() + temp.substring(1));
            }
            
            if(i < l - 1) sb.append(" ");
        }
        
        return sb.toString();
    }
}