import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long min = 1;
        long max = 0;
        long answer = 0;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i])max = arr[i];
        } 

        // 절단기 높이를 지정하면 H미터 올라가고 한줄에 연속해 있는 나무를 모두 절단
        // 아 절단기 15로 정하는 이유가 딱 필요한 만큼만
        // 그럼 최대에서 부터 중간지점 자른 것들을 더했을 때 M이랑 같으면 끝
        // 1 20 -> 10 -> sum이 커서 min 업데이트
        // 11 20 -> 15 -> 15면 맞아야하는데 왜 13으로 나올까..
        // 
        while(min <= max){
            long mid = (min + max) / 2;
            long sum = 0;
            for(int i = 0; i <  N; i++){
                // 음수 고려 안했음 ㅋㅋ
                if(arr[i] - mid > 0) sum += arr[i] - mid;
            }
            if(sum == M){
                answer= mid;
                break;
            }
            else if(sum < M){
                max = mid - 1;
            }
            else{
                answer = mid;
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
