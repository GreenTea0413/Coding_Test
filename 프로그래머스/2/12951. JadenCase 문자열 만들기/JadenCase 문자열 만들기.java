class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ", -1);
        
        for(int i = 0; i < arr.length; i++){
            String temp = arr[i].toLowerCase();
            if(temp.length() > 0){
                sb.append(temp.substring(0,1).toUpperCase() + temp.substring(1));
            }
                      
            if(i < arr.length - 1){sb.append(" ");}
        }
        
        return sb.toString();
    }
}