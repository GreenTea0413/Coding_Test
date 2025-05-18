
import java.util.*;
import java.io.*;

public class Main {
    static int K,N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken()); 

        int[] arr = new int[K];
        long min = 1;
        long max = 0;
        long answer = 0;
        // K번 반복
        for(int i =0; i < K; i++){
            // 여기서 주어지는 입력인 802 743 457 539
            // 이 길이들로 N개의 줄을 만들건데 그게 최대 몇 cm인지 맞추라는 듯
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            // 그럼 범위를 정해야하니까 0 ~ 배열 안에서 젤 큰 숫자
            if(max < arr[i]) max = arr[i];
        }
        // min max
        // 0 803 -> 0 401 -> 201 401 ===> 201 201
        while (min <= max){
            // 401 -> 200 
            long mid = (min + max) / 2;
            // 처음에 길이 중간값으로 정해놓고 배열 돌면서 나눠서 나온 값들 +해서
            // 11개가 나오면 정답
            long count = 0;

            for(int i = 0; i< arr.length; i++){
                count += (arr[i] / mid);
            }
            // 정답이 200이니까 당연히 401이면 적게 나옴
            // 근데 적게 나눠지면 이제 최대를 줄이고
            if(count < N){
                max = mid - 1;
            }
            // 아니면 최소를 줄여서 더 나뉘게 끔하기
            // 여기서 같아지면 이제 min을 200 + 1로 넣음
            else{
                answer = mid;
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
