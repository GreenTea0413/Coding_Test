import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    // 모든 숫자 출력에 대한 것을 여기서 처리하도록 함수 빼기
    public static void printNum(int num) throws IOException{
        bw.write(num + "\n");
    }

    //main
    public static void main(String[] args) throws IOException{
        // 덱 생성
        Deque<Integer> deque = new LinkedList<>();
        
        // 여기서 명령어 얼만큼 적을 건지 숫자 입력
        int n = Integer.parseInt(br.readLine());
        // 그만큼 반복하면서
        for( int i = 0; i < n; i++){

            // 여기서 부터 명령어 입력 들어가는 거임!
            // br.readLine()은 한줄 전체를 통째로 입력 받음!
            st= new StringTokenizer(br.readLine());
            // nextToken을 통해 처음에 나오는 단어를 가져감!
            // ex) push_front 2 이렇게 띄어써져있으면 push_front만 쏙 빼서 넣음
            String command = st.nextToken();

            // push_back과 push_front는 뒤에 숫자가 같이 옴!
            // 그렇기에 뒤에따라오는 st안의 값을 한번 더 nextToken으로 숫자를 가져와서
            // deque에 앞과 뒤에 넣는다!
            if(command.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                deque.offerLast(num);
            }
            else if(command.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());
                deque.offerFirst(num);
            }

            // pop_front, pop_back은 덱에 들어있는 값이 없으면 -1 출력
            // 있으면 앞에서 또는 뒤에서 첫 번째로 있는 값 출력
            else if(command.equals("pop_front")){
                if(!deque.isEmpty()) printNum(deque.pollFirst());
                else printNum(-1);
            }
            else if(command.equals("pop_back")){
                if(!deque.isEmpty()) printNum(deque.pollLast());
                else printNum(-1);
            }
            // size는 말그대로 정수 개수 반환
            else if(command.equals("size")){
                printNum(deque.size());
            }
            // empty는 비어있는지 아닌지 확인 해줌
            else if(command.equals("empty")){
                if(!deque.isEmpty()){
                    printNum(0);
                }
                else printNum(1);
            }
            // 그냥 front와 back은 숫자 꺼내지 않고 그냥 숫자 출력!
            // 그래서 peek~~ 사용
            // 마찬가지로 없으면 -1
            else if(command.equals("front")){
                if(!deque.isEmpty()) printNum(deque.peekFirst());
                else printNum(-1);
            }
            else if(command.equals("back")){
                if(!deque.isEmpty()) printNum(deque.peekLast());
                else printNum(-1);
            }
        }

        bw.flush();  // 출력 버퍼 비우기
        bw.close();  // BufferedWriter 닫기
    }
}
