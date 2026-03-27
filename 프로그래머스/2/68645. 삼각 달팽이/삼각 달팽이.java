import java.util.*;
class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[][] result = new int[n][n];
        int[][] d = new int[][]{{1,0}, {0,1}, {-1, -1}};
        // 이게 뭐람
        // 2차원 배열을 만들어서 방향 바꾸면서 만들기?
        // 처음 n 만큼씩 이동하고 결국 n-1, n-2 이렇게만 움직이면됨
        // n번 반복하는 동안
        int x = -1;
        int y = 0;
        int dir = 0;
        int num = 1;
        for(int i = n; i > 0; i--){
            int count = i;
            while (count > 0){
                int nx = x + d[dir % 3][0];
                int ny = y + d[dir % 3][1];
                
                result[nx][ny] = num;
                num ++;
                count--;
                x = nx;
                y = ny;
            }
            dir += 1;
        }
        for(int[] res : result){
            for(int r : res){
                if(r != 0) {answer.add(r);}
            } 
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}