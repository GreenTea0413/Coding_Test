import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
   
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int text_case = Integer.parseInt(br.readLine());
        for(int i = 0; i < text_case; i ++){
            st = new StringTokenizer(br.readLine());

            pq.add(new int[]{Integer.parseInt(st.nextToken()), 
                Integer.parseInt(st.nextToken())});
        }
        // 방을 하나씩 꺼내서 끝나는 시간만 담아서 우선순위에 넣은 후에
        // 가장 빨리 끝나는 시간과 비교해서 다음에 들어올 것을 넣으면 해결!
        // 끝내는 조건을 우선순위 큐 담아놓은거 다 비울 때까지하도록 해야s
        PriorityQueue endTime = new PriorityQueue<>();
        while(!pq.isEmpty()){
            int [] n = pq.poll();
            int start = n[0];
            int end = n[1];

            if(!endTime.isEmpty() && (int)endTime.peek() <= start){
                endTime.poll();
            }
            endTime.add(end);
        }
        System.out.println(endTime.size());
    }
}
