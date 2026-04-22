import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 교집합 / 합집합
        // 두 글자씩 끊어서 다중집합
        Map <String, Integer> map1 = new HashMap<>();
        Map <String, Integer> map2 = new HashMap<>();
        
        // 1 1 2 2 3
        // 1 2 2 4 5
        // 1 2개 2 2개 3 1개 
        // 1 1개 2 2개 4 1개 5 1개
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        for(int i = 0; i < str1.length() - 1; i++){
            // System.out.printf("%c%c ", str1.charAt(i), str1.charAt(i + 1));
            Character c1 = str1.charAt(i);
            Character c2 = str1.charAt(i + 1);
            // 대문자로 바꾸고 거기서 'A'랑 'Z'포함해서 안에 있는지 확인하기
            if(c1 >= 'A' && c1 <= 'Z'  && c2 >= 'A' && c2 <= 'Z'){
                String temp = "" + c1 + c2;
                map1.put(temp, map1.getOrDefault(temp, 0) + 1);
            }
        }
        for(int i = 0; i < str2.length() - 1; i++){
            // System.out.printf("%c%c ", str2.charAt(i), str2.charAt(i + 1));
            Character c1 = str2.charAt(i);
            Character c2 = str2.charAt(i + 1);
            // 대문자로 바꾸고 거기서 'A'랑 'Z'포함해서 안에 있는지 확인하기
            if(c1 >= 'A' && c1 <= 'Z'  && c2 >= 'A' && c2 <= 'Z'){
                String temp = "" + c1 + c2;
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
            }
        }
        
        int total = 0;
        int sub = 0;
        for(String key : map1.keySet()){
            System.out.printf("%s ", key);
        }
        System.out.println();
        for(String key : map2.keySet()){
            System.out.printf("%s ", key);
        }
        
        // 교집합 갯수 구하기
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                int min = Math.min(map1.get(key), map2.get(key));
                sub += min;
            }
        }
        
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for(String key : keys){
            int a = map1.getOrDefault(key, 0);
            int b = map2.getOrDefault(key, 0);
            total += Math.max(a, b);
        }
        
        return total == 0 ? 65536 : (int)(((double) sub / total) * 65536);
    }
}