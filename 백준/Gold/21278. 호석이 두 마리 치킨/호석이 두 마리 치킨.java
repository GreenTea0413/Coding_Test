
import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 100000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫줄 받기
        st= new StringTokenizer(br.readLine());

        // N은 건물 수 M은 도로 수
        int N = Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());
        
        // 이번엔 거리를 바로 2차원 배열로 자기 자신의 위치는 i,i는 0 나머지는 INF
        int [][] dist = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <=N; j++){
                dist[i][j] = (i==j) ? 0 : INF;
            }
        }
        // 왔다갔다 무방향 그래프 만들었음
        for(int j = 0; j < M; j++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] =1;
            dist[b][a] =1;
        }
        // 플로이드 워셜
        for(int k = 1; k <=N; k++){
            for(int i = 1; i <=N; i++){
                for(int j = 1; j <=N; j++){
                    // i -> k -> j 그냥 바로 i -> j 비교 했을 떄 뭐가 더 값이 작은지
                    // 1 -> 3  1 -> 2 -> 3  / 1-> 4  1 -> 2 -> 4 뭐 등등~
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 이제 해야하는건 그래프 정점 2개를 선택해서 그때 모든 도시에 대해서 왕복 시간
        int answer = INF;
        int a = 0, b = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                // 이걸로 i,j 중복 안되게 해서 1,2 ~ 4,5 까지 돌게하고
                // 오름차순으로 내보내야하니까 작은 수부터 비교
                int sum = 0;

                for (int k = 1; k <= N; k++) {
                    // 여기서 1,1 1,2 / 2,1 2,2 / 3,1 3,2 싹다 돌게 해서 그만큼 거리 최대한 많이 안움직이는
                    // 이제 왕복이니까 *2 해서 sum에 놓고 
                    int toChicken = Math.min(dist[k][i], dist[k][j]);
                    sum += toChicken * 2;
                }
                // 여기서 최소 비교해서 맞으면 계속 최신화
                if (sum < answer) {
                    answer = sum;
                    a = i;
                    b = j;
                }
            }
        }

        System.out.println(a + " " + b + " " + answer);
    }
}
