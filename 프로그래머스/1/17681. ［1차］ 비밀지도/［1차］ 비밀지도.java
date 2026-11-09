class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map1 = new String[n];
        // 이거 먼저 암호 구하기
        for(int i = 0; i < arr1.length; i++){
            int num = arr1[i];
            String bin = Integer.toString(num, 2);
            
            while(bin.length() < n) bin = "0" + bin;
            map1[i] = bin;
        }
        
        String[] map2 = new String[n];
        // 이거 먼저 암호 구하기
        for(int i = 0; i < arr2.length; i++){
            int num = arr2[i];
            String bin = Integer.toString(num, 2);
            
            while(bin.length() < n) bin = "0" + bin;
            map2[i] = bin;
        }
        
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            String s1 = map1[i];
            String s2 = map2[i];
            StringBuilder temp = new StringBuilder();
            
            for(int j = 0; j < n; j++){
                if(s1.charAt(j) == '1' || s2.charAt(j) == '1') temp.append("#");
                else temp.append(" ");
            }
            answer[i] = temp.toString();
        }
        return answer;
    }
}