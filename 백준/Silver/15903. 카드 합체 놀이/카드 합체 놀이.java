
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        long answer = 0;
        // 첫번째 줄 받기 3 1
        st= new StringTokenizer(br.readLine());
    
        int n = Integer.parseInt(st.nextToken()); // 카드 수
        int m = Integer.parseInt(st.nextToken()); // 합체 수

        // 두번째 줄 받기 
        st= new StringTokenizer(br.readLine());
    
        for(int i = 0; i < n; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }
        
        // 자 그러면 이제 순서대로 2개를 꺼낸 후에 값을 바꿔서 넣어야 하는데 같으면 안들어가도 됨
        for(int j = 0; j < m; j++){
            long x = pq.poll();
            long y = pq.poll();
            long sum = x + y;
            pq.add(sum);
            pq.add(sum);          
        }
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}
