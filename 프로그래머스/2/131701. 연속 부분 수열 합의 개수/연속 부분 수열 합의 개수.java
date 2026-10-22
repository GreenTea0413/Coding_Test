import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        int len = elements.length;
        int[] arr = new int[len * 2];
        for(int i = 0; i < len; i ++){
            arr[i] = elements[i];
            arr[i + len] = elements[i];
        }
        
        // 길이가 1 길이가 2...
        for(int i = 1; i <= len; i++){
            // 0번부터 쭈욱~ 갯수 만큼 가는거임 1은 그냥 5번 하면 되고 2는 79 91 11 14 47까지 가야함
            // 3은 791 911 114 147 479 가야함
            // 시작점을 기준으로 길이만큼만 더해주면 됨
            for(int start = 0; start < len; start++){
                int sum = 0;
                for(int j = start; j < start + i; j++){
                    sum += arr[j];
                }
                answer.add(sum);
            }
        }
        return answer.size();
    }
}