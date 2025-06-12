import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] t = new int[4][8];
        int answer = 0;
        // 0이 N, 1이 S
        // 자 이제 톱니바퀴 다 채웠고
        for(int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            for(int j = 0; j < 8; j++){
                t[i][j] = s.charAt(j) - '0';
            }
        }

        // 몇번 돌리는지 값 받아오기
        // 여긴 몇번 돌리는지 다 정해놨고
        // 이제 여기서 t가 톱니바퀴고 r이 돌리는건데 이거 보고 뭐해야하지?
        // 아 돌려서 [0] 번쨰가 0이면 0점 1이면 1,2,4,8점
        // 근데 또 돌리는데 마주보고 있는 방향이 S, S 로 같으면 같은 방향 다르면 다른 방향
        // 보면 일단 [0][2] - [1][6] - [2][2] - [3][6] 이렇게 마주봄

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
    
        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine());
            // 3 -1
            int target = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            
            // 이러면 이제 나머지도 방향 정해줘야함
            int[] dirs = new int[4];
            dirs[target] = dir;

            // 0,1 번째 방향 정해주기
            // 0 부터할려했는데 그러면 뒤에값이 아직 안된 경우도 있으니까
            // 시작은 target에서 되도록
            for(int i = target; i > 0; i--){
                if(t[i][6] != t[i-1][2]) dirs[i-1] = dirs[i] * -1;
            }
            // 2 3
            for(int i = target; i < 3; i++){
                if(t[i][2] != t[i+1][6]) dirs[i+1] = dirs[i] * -1;
            }

            // 방향 다 정해줬으면 이제 돌려야함
            // dirs가 1이면 시계 방향 1이면 한칸씩 뒤로가고 7이 0으로 와야함
            for(int i = 0; i < 4; i++){
                if(dirs[i] == 1){
                    int temp = t[i][7];
                    for (int j = 7; j > 0; j--) {
                        t[i][j] = t[i][j - 1];
                    }
                    t[i][0] = temp;
                }
                if(dirs[i]==-1){
                    int temp = t[i][0];
                    for(int j = 0; j < 7; j++){
                        t[i][j] = t[i][j+1];;
                    }
                    t[i][7] = temp;
                }
            }
        }
        // 다 돌았으면 여기서 이제 값 구하기
        for(int i = 0; i < 4; i++){
            if(t[i][0] == 1) {
                if(i == 0) answer +=1;
                if(i == 1) answer +=2;
                if(i == 2) answer +=4;
                if(i == 3) answer +=8;
            }
        }

        System.out.println(answer);
    }
}
