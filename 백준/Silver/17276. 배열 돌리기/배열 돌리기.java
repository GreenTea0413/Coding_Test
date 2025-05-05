
import java.util.*;
import java.io.*;

public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static void angleArr(int angle, int[][] arr) throws IOException{
        int[][] copy = new int[N][N];
        // 음수면 360 더해서 하면 똑같이 진행되니까 상관 없음
        if (angle < 0) {
            angle += 360;
        }
        // 그리고 0이랑 306이면 그대로니까 그대로 출력
        if (angle ==0 || angle == 360){
            for(int i = 0; i < N; i++){
                for(int j =0; j < N; j++){
                    bw.write(arr[i][j] + " ");
                }
                bw.write("\n");
            }
            return;
        }
        // 그리고 각도가 45의 배수이기 때문에 45로 나눈 만큼 반복하면
        // 45 2번하면 90, 45 3변하면 135가 되다는 점을 이용
        int mid = (int) N / 2;
        int count = (int) angle / 45;
        for(int i = 0; i < count; i++){
            // 배열 전체를 돌면서 45도에 맞게 회전하게 끔 하기
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    // 이거 \ 45도 |
                    if(j == k) copy[j][mid] = arr[j][k];
                    // 이건 | 45도 /
                    // 0,2 -> 0,4 1,2 -> 1,3
                    else if(k == mid) copy[j][k + mid - j] = arr[j][k]; 
                    // 이건 - 45도 \
                    // 2,0 -> 0,0  2,1 -> 1,1
                    else if(j == mid) copy[j - mid + k][k] = arr[j][k]; 
                    // 이건 / 45도 -
                    // 0,4 -> 2,4 1,3 -> 2,3
                    else if(j + k == (N - 1)) copy[mid][k] = arr[j][k]; 
                    else copy[j][k] = arr[j][k];
                }
            }
            // 한바퀴 돌린거 여기서 이제 업데이트 시키기
            for(int l = 0; l < N; l++){
                for(int m =0; m < N; m++){
                    arr[l][m] = copy[l][m];
                }
            }
        }
        // 이제 출력할거 여기서 모아놓기
        for(int i = 0; i < N; i++){
            for(int j =0; j < N; j++){
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
    }
    public static void main(String[] args) throws IOException{
        // 배열 돌리기
        // n 은 무조건 홀수
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // test_case
        int test_case =  Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        
        for (int i = 0; i < test_case; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int angle = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < N; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            // 여기까지가 한 배열에 대해서 크기, 각도, 배열 값 처리
            // 이제 여기서부터 각도 값 가지고 출력 나오게 해야함
            angleArr(angle, arr);
        }
        bw.flush();
        bw.close();
    }
}
