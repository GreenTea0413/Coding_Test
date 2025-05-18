import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        // N개의 집 C개의 공유기
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        // 집 좌표 가까운 순으로 설치

        // 집 순서대로 한 다음에 3개를 설치해야하는데
        // 일단 공유기가 있는 곳의 위치들의 거리를 구해야함
        // 근데 공유기를 어디다가 달지 고민해야함
        // 거리를 각 좌표마다 다 구해야하나?
        
        long left = 1;
        // 젤 끝에랑 앞에 비교해서
        // 총 길이 구해놓고
        long right = home[N-1] - home[0]; 
        long answer = 0;
        // 그러면 총 거리가 1 ~ 9 까지
        // 공유기는 3개를 달아야하는데 거리를 어떻게 구하냐..
        while(left <= right){
            // 얘가 계속 공유기 사이 거리 바뀌면서 비교
            // 첨에 1 + 8 / 2 = 4
            // 5 + 8 = 13 / 2 6
            long mid = (left + right) / 2;
            int h = home[0]; // 1
            int count = 1;
            // 근데 4를 어떻게 비교하지
            // 아 일단 거리가 최대가 될려고하면 맨 앞에 집에 설치하고
            // 그 다음부터 하나씩 Mid랑 비교해서 거리가 Mid보다 멀면?
            // 멀게 되면 이제 또 h를 방금 mid 통과한 집에 설치하고
            // 또 비교 하나씩 하면 최대 몇개까지 할 수 있는지 mid 범위 안에서
            // 그리고 이제 그 Mid를 내보내면 되는거임
            for(int i = 1 ; i < N; i++){
                // 첨에 2 4 8 9 -> 2 - 1 x 4 - 1 x 8 - 1 o 9 - 8 x
                if(home[i] - h >= mid){
                    count ++;
                    h = home[i];
                }
            }
            // 그러다가 공유기 개수랑 여기서 설치한 수가 같거나 크게 되면
            if(count >= C){
                answer = mid;
                left = mid + 1;
            }
            // 처음에 2개 밖에 안되서 줄어듬
            else right = mid - 1;
        }
        System.out.println(answer);
    }
}
