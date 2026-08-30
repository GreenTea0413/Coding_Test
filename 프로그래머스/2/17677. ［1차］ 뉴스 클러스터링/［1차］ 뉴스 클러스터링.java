import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        // 두글자씩 끊어서 사용
        // 우서는 대소문자 무시하니까 toUpperCase로 통일
        // 이제 다중집합 여러개 만들어서 교집합과 합집합을 구해야함
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        if(str1.equals(str2)) return 65536;
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        int len1 = str1.length();
        for(int i = 0; i < len1 - 1; i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            
            if('A' <= c1 && c1 <= 'Z' && 'A' <= c2 && c2 <= 'Z'){
                String s = "" + c1 + c2;
                map1.put(s, map1.getOrDefault(s, 0) + 1);
            }
        }
        
        int len2 = str2.length();
        for(int i = 0; i < len2 - 1; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            
            if('A' <= c1 && c1 <= 'Z' && 'A' <= c2 && c2 <= 'Z'){
                String s = "" + c1 + c2;
                map2.put(s, map2.getOrDefault(s, 0) + 1);
            }
        }

        // 이렇게 이제 map에다가 다 넣었음
        // 각 맵의 전체 key를 구해놔야함
        Set<String> allKey = new HashSet<>();
        allKey.addAll(map1.keySet());
        allKey.addAll(map2.keySet());
        
        // 교집합 먼저 구하기
        // 해당 키 값에 대해서 둘 다 있어야하고
        // 있으면 키 더 작은 값을 더해줘야함
        int inter = 0;
        for(String key : allKey){
            if(map1.get(key) == null || map2.get(key) == null) continue;
            inter += Math.min(map1.get(key), map2.get(key));
        }
        
        // 합집합
        // 키 값에 대해서 다 더해주면 됨.
        // 이건 없어도 더하기 때문에 그냥 최댓값만 구분해주기
        int sum = 0;
        for(String key : allKey){
            int n1 = map1.getOrDefault(key, 0);
            int n2 = map2.getOrDefault(key, 0);
            
            sum += Math.max(n1, n2);
        }
        
        System.out.println(inter);
        System.out.println(sum);
        if(sum == 0 || inter == 0) return 0;
        return (int) ((double) (inter * 65536 / sum));
    }
}