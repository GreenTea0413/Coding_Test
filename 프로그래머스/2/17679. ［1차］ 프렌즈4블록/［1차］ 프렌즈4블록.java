import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        Character[][] arr = new Character[m][n];
        
        int idx = 0;
        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                arr[x][y] = board[x].charAt(y);
            }
        }

        // 블록 위치 하나당 (0,0) 이면 좌표 4개 검사
        // 같은거면 위치 기억
        while(true){
            boolean[][] v = new boolean[m][n];
            int count = 0;
            for(int x = 0; x < m - 1; x++){
                for(int y = 0; y < n - 1; y++){
                    if(arr[x][y] != '.'
                       && arr[x][y] == arr[x][y + 1] 
                       && arr[x][y] == arr[x + 1][y] 
                       && arr[x][y] == arr[x + 1][y + 1]){
                        v[x][y] = true;
                        v[x][y+1] = true;
                        v[x+1][y] = true;
                        v[x+1][y+1] = true;
                    }
                }
            }
            
            // v에 true들 체크해서 바꿔줘야함
            for(int x = 0; x < m; x++){
                for(int y = 0; y < n; y++){
                    if(v[x][y]) {arr[x][y] = '.'; count++;}
                }
            }
            
            if(count == 0) break;
            answer += count;
            
            // 이제 .으로 바꿨으니까 어떻게 내려와야할까
            // 제일 밑부분부터 .이면 x - 1에 있는걸 아래로 내리기
            for(int y = 0; y < n; y++){
                for(int x = m - 1; x >= 0; x--){
                    if(arr[x][y] == '.'){
                        // 여기서 단순하게 한칸만 내리면 안됨
                        for(int z = x - 1; z >= 0; z--){
                            if(arr[z][y] != '.'){
                                arr[x][y] = arr[z][y];
                                arr[z][y] = '.';
                                break;
                            }
                        }
                    }
                }
            }
            
            
        }
        
        return answer;
    }
}