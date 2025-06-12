
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt((new StringTokenizer(br.readLine())).nextToken());

        // 우선순위 큐로 알아서 큰 수
        // 양수랑 음수 나눠서 구분
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int answer = 0;
        boolean zero = false;
        // 0은 음수 곱해서 없애는 용도

        // 일단 양수 정렬 한 다음에 곱하기 계속하기
        // 대신 큰 숫자부터 그래야 마지막에 작은 숫자는 그냥 더하게 됨
        // 반대면 큰 숫자가 낭비되고 더하게 될 수 있기 떄문
        
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt((new StringTokenizer(br.readLine())).nextToken());
            
            if(num > 1) plus.add(num);
            else if(num == 1) answer ++;
            else if(num == 0) zero = true;
            else minus.add(num);
        }
        // 일부로 2개씩 해서 하기
        // 차피 양수는 1 아니면 무조건 곱하는게 이득
        Collections.sort(plus, Collections.reverseOrder());
        for (int i = 0; i < plus.size(); i += 2) {
            // 사이즈 오버 해버리면 안되니까
            if (i + 1 < plus.size()) {
                answer += plus.get(i) * plus.get(i + 1);
            } else {
                answer += plus.get(i); 
            }
        }

        // 음수는 작은 수끼리 (음수 * 음수) 곱하는 게 유리
        Collections.sort(minus);
        for (int i = 0; i < minus.size(); i += 2) {
            if (i + 1 < minus.size()) {
                answer += minus.get(i) * minus.get(i + 1);
            } else {
                // 짝이 없으면 0이 있으면 곱하지 않고 버림
                if (!zero) answer += minus.get(i);
            }
        }
        System.out.println(answer);
        
    }
}
