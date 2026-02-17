import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        for(int a = 0; a < len; a++){
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            int[] copy = Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(copy);
            answer[a] = copy[k-1];
        }
        return answer;
    }
}