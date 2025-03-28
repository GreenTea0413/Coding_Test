import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException{
        Stack<Integer> stack = new Stack<>();
        int command_num = Integer.parseInt(br.readLine()); 

        for(int i = 0; i<command_num; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            else if(command.equals("pop")){
                if(!stack.empty()) bw.write(stack.pop() + "\n");
                else bw.write(-1 + "\n");
            }
            else if(command.equals("size")){
                bw.write(stack.size() + "\n");
            }
            else if(command.equals("empty")){
                if(!stack.empty()) bw.write(0 + "\n");
                else bw.write(1 + "\n");
            }
            else if(command.equals("top")){
                if(!stack.empty()) bw.write(stack.peek() +"\n");
                else bw.write(-1 + "\n");
            }
        }

        bw.flush();  // 출력 버퍼 비우기
        bw.close();  // BufferedWriter 닫기
    }
}
