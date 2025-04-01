
import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String args[]) throws IOException{
        int num = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        // 여기서 queue에 값 다 넣기
        for(int i = num; i > 0; i--){
            deque.push(i);
        }

        while(deque.size() != 1){
            deque.pop();                //처음에 젤 위에 카드 하나 버리기

            int second = deque.pop();    // 그 다음에 카드는 꺼내서 가장 아래에 다시 넣기기 
            deque.offerLast(second);
            
        }
        System.out.println( deque.pop());
    }
}
