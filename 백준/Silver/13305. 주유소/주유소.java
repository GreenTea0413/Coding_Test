import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        long[] dist = new long[N - 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i ++){
            dist[i] = Integer.parseInt(st.nextToken());
        }

        long[] city = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < N; j++){
            city[j] = Integer.parseInt(st.nextToken());
        }
    
        // 일단 맨 처음에 무조건 기름을 넣어야함
        long answer = dist[0] * city[0];

        // 이제 여기서 비교 시작
        long min = city[0];
        for(int k = 1; k < N - 1; k++){
            // 2 5
            if(city[k] < min){
                answer += dist[k] * city[k];
                min = city[k];
            }
            else{
                answer += dist[k] * min;
            }
        }
        System.out.println(answer);
    }
}
