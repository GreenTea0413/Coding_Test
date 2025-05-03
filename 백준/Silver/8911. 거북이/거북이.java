
import java.util.*;
import java.io.*;

public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //F: 한 눈금 앞으로
    //B: 한 눈금 뒤로
    //L: 왼쪽으로 90도 회전
    //R: 오른쪽으로 90도 회전
    public static void moveTurtle(String command) throws IOException{
        // 여기에 이제 가로 세로 길이를 넣을거임 둘 중 하나라도 1이면 선으로 인식해서 0으로 출력할려고 생각
        int min_x = 0;
        int min_y = 0; 
        int max_x = 0;
        int max_y = 0; // 이러면 변수는 0으로 초기화 됨
        int crr_x = 0;
        int crr_y = 0; // 현재 위치
        
        int nav = 1;
        // 거북이는 처음에 위를 보고 있음 위 : 1 왼 : 2 오 : 3 아래 : 4 
        // 예시로 (0,0) -> F (0, 1) col += 1 근데 또 내려갈 수가 있음 RRF( 0, 0 ) 되어버림
        // 그럼 그렇다고 길이를 줄이냐.. 그건x
        // 그래서 나는 최소 최대 x, y를 두고 넓이를 구하는 걸로
        for(int i = 0; i < command.length(); i++){
            if(nav == 1){
                switch (command.charAt(i)) {
                    case 'F':
                        crr_y += 1;
                        break;
                    case 'B' :
                        crr_y -= 1;
                        break;
                    case 'L' :
                        nav = 2;
                        break;
                    case 'R' : 
                        nav = 3;
                        break;
                    default:
                        break;
                }
            }
            else if(nav == 2){
                switch (command.charAt(i)) {
                    case 'F':
                        crr_x -= 1;
                        break;
                    case 'B' :
                        crr_x += 1;
                        break;
                    case 'L' :
                        nav = 4;
                        break;
                    case 'R' : 
                        nav = 1;
                        break;
                    default:
                        break;
                }
            }
            else if(nav == 3){
                switch (command.charAt(i)) {
                    case 'F':
                        crr_x += 1;
                        break;
                    case 'B' :
                        crr_x -= 1;
                        break;
                    case 'L' :
                        nav = 1;
                        break;
                    case 'R' : 
                        nav = 4;
                        break;
                    default:
                        break;
                }
            }
            else if(nav == 4){
                switch (command.charAt(i)) {
                    case 'F':
                        crr_y -= 1;
                        break;
                    case 'B' :
                        crr_y += 1;
                        break;
                    case 'L' :
                        nav = 3;
                        break;
                    case 'R' : 
                        nav = 2;
                        break;
                    default:
                        break;
                }
            }
            // 여기서 이제 움직인거 만큼 넓이를 구해주기 위해 최소 최대를 업뎃
            if(crr_x > max_x){
                max_x = crr_x;
            }
            if(crr_x < min_x){
                min_x = crr_x;
            }
            if(crr_y > max_y){
                max_y = crr_y;
            }
            if(crr_y < min_y){
                min_y = crr_y;
            }
        }
        if((max_x == min_x) || (max_y == min_y))  bw.write(0 + "\n");
        else bw.write((max_x - min_x) * (max_y - min_y) + "\n");
    }
    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        
        st = new StringTokenizer(br.readLine());
        int test_case = Integer.parseInt(st.nextToken());

        for(int i = 0; i < test_case; i++){
            st = new StringTokenizer(br.readLine());
            moveTurtle(st.nextToken());
        }
        bw.flush();
        bw.close();

    }
}
