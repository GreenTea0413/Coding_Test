import java.util.*;

class Solution {
    
    public String[] solution(int[][] line) {
        List<long[]> star = new ArrayList<>();
        
        // 1. 교점 구하기
        for(int i = 0; i < line.length - 1; i++){
            for(int j = i + 1; j < line.length; j++){
                int[] a = line[i];
                int[] b = line[j];
                
                long deno = (long)a[0]*b[1] - (long)b[0]*a[1];
                if(deno == 0) continue;
                
                long xNum = (long)a[1]*b[2] - (long)a[2]*b[1];
                long yNum = (long)a[2]*b[0] - (long)a[0]*b[2];
                
                if(xNum % deno != 0 || yNum % deno != 0) continue;
                
                long x = xNum / deno;
                long y = yNum / deno;
                
                star.add(new long[]{x, y});
            }
        }
        
        // 2. 범위 구하기
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        
        for(long[] p : star){
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            minY = Math.min(minY, p[1]);
            maxY = Math.max(maxY, p[1]);
        }
        
        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        
        // 3. 배열 생성
        char[][] board = new char[height][width];
        for(int i = 0; i < height; i++){
            Arrays.fill(board[i], '.');
        }
        
        // 4. 별 찍기
        for(long[] p : star){
            int row = (int)(maxY - p[1]);
            int col = (int)(p[0] - minX);
            board[row][col] = '*';
        }
        
        // 5. String[] 변환
        String[] answer = new String[height];
        for(int i = 0; i < height; i++){
            answer[i] = new String(board[i]);
        }
        
        return answer;
    }
}