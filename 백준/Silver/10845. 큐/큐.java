
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    // 모든 숫자 출력에 대한 것을 여기서 처리하도록 함수 빼기
    public static void printNum(int num) throws IOException{
        bw.write(num + "\n");
    }
    
    public static void main(String args[]) throws IOException{
        Deque<Integer> queue = new LinkedList<>();

        int count_num = Integer.parseInt(br.readLine());

        for (int i =0; i<count_num; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            // 이미 st 선언할 때 한줄 다 받기여서 잘 봐야함함
            //st 토큰에 담긴거 꺼내서 써야함
            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);
            }
            else if(command.equals("pop")){
                if(!queue.isEmpty()) printNum(queue.poll());
                else printNum(-1);
            }
            else if(command.equals("size")){
                printNum(queue.size());

            } else if(command.equals("empty")){
                if(!queue.isEmpty()) printNum(0);
                else printNum(1);

            } else if(command.equals("front")){
                if(!queue.isEmpty()) printNum(queue.peek());
                else printNum(-1);

            } else if(command.equals("back")){
                if(!queue.isEmpty()) printNum(queue.peekLast());
                else printNum(-1);
            }
        }
        bw.flush();
        bw.close();  // BufferedWriter 닫기
    }
}
