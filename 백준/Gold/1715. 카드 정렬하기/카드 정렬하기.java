

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int answer = 0;
        int test_case = Integer.parseInt(br.readLine());
        PriorityQueue pq = new PriorityQueue<>();

        for(int i = 0; i < test_case; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        // 10, 20, 30, 40  -> answer = 0;
        // 30 30 40 -> answer = (10 + 20)
        // 60 40 -> answer = (10 + 20) + (30 + 30)
        // -> 매번 정렬 
        while(pq.size() > 1){
            int n1 = (int) pq.poll();
            int n2 = (int) pq.poll();

            int sum = n1 + n2;
            answer += sum;
            pq.add(sum);
        }

        System.out.println(answer);
    }
}
