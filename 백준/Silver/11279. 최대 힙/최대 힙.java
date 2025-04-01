import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 

    public static void printNum(int n) throws IOException{
        bw.write(n + "\n");
    }
    public static void main(String args[]) throws IOException{
        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++){
            int input_num = Integer.parseInt(br.readLine());
            
            if(input_num == 0){
                if(!maxHeap.isEmpty()){
                    printNum(maxHeap.poll());
                }
                else printNum(0);
            }
            else {
                maxHeap.offer(input_num);
            }
        }
        bw.flush();
        bw.close();
    }
}
