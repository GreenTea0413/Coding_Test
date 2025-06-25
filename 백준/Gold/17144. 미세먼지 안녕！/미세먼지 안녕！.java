
import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] v;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];

        // 여기까지 배열 채우기
        for(int i = 0; i < R; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int t = 0; t < T; t++){
            // 확산 시키기
            extend();
            // 공기청소기 일하기
            clean();
        }

        // 여기서 확산 다하고 청소 다한 후 계산
        int answer = 0;
        for(int i = 0; i < R; i ++){
            for(int j = 0; j < C; j++){
                if(arr[i][j] > 0) answer += arr[i][j];
               
            }
            
        }
        System.out.println(answer);
    }

    // 확산 시키기
    static void extend(){
        v = new boolean[R][C];
        int[][] copy = new int[R][C];

        // 여기서 0이상의 값 좌표들 저장
        // -1인 것은 미리 옮겨놓음
        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < R; i++){
            for(int j = 0; j < C; j++){
                if(arr[i][j] > 0) list.add(new int[]{i,j});
                else if(arr[i][j] == -1) copy[i][j] = -1;
            }
        }

        // 이제 여기서 list안에 좌표만 꺼내서 상하좌우로 뿌려주기
        for(int j = 0; j < list.size(); j++){
            int x = list.get(j)[0];
            int y = list.get(j)[1];
            copy[x][y] += arr[x][y];
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(0 <= nx && nx < R && 0 <= ny && ny < C && arr[nx][ny] != -1){
                    int num = arr[x][y] / 5;
                    copy[x][y] -= num;
                    copy[nx][ny] += num;
                }
            }
        }

        arr = copy;
    }

    static void clean(){
        List<int[]> xy = new ArrayList<>();
        int[][] copy = new int[R][C];
        // x1 ~ y2 저장
        for(int i = 0; i < R; i++){
            if(arr[i][0] == -1) xy.add(new int[]{i,0});
        }
        int x1, x2, y1, y2;
        x1 = xy.get(0)[0];
        y1 = xy.get(0)[1];
        x2 = xy.get(1)[0];
        y2 = xy.get(1)[1];

        //위에 돌리기
        //아래 가로 먼저
        for(int i = 1; i < C - 1; i++){
            copy[x1][i+1] = arr[x1][i];
        }
        // 다음 ^
        for(int i = x1; i > 0; i --){
            copy[i -1][C-1] = arr[i][C-1]; 
        }
        // 다음 <-
        for(int i = C -1; i > 0; i--){
            copy[0][i-1] = arr[0][i];
        }
        // 다음 아래로
        for(int i = 1; i < x1; i++){
            copy[i][0] = arr[i-1][0];
        }

        // 아래 돌리기
        // 위 가로 먼저
        for(int i = 1; i < C - 1; i++){
            copy[x2][i+1] = arr[x2][i];
        }
        //다음 아래로
        for(int i = x2 ; i < R - 1; i++){
            copy[i + 1][C-1] = arr[i][C-1];
        }
        // 다음 <-
        for(int i = C - 1; i > 0; i--){
            copy[R-1][i-1] = arr[R-1][i];
        }
        for(int i = R - 1; i > x2; i-- ){
            copy[i-1][0] = arr[i][0]; 
        }

        // 이제 나머지 처리해주기
        for(int i = 1; i < x1; i++){
            for(int j = 1; j < C-1; j++){
                copy[i][j] = arr[i][j];
            }
        }
        for(int i = x2 + 1; i < R - 1; i++){
            for(int j = 1; j < C-1; j++){
                copy[i][j] = arr[i][j];
            }
        }

        copy[x1][y1] = -1;
        copy[x2][y2] = -1;

        arr = copy;
    }
}
