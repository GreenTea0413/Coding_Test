
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 현재 N개에 대한 우선순위 큐 내림차순으로 그래야 빼면 양수
        ArrayList<Integer> rest = new ArrayList<>();
        for (int i = 0; i < N; i++){
            rest.add(Integer.parseInt(st.nextToken()));
        }
        rest.add(0);
        rest.add(L);
        Collections.sort(rest);
       
        ArrayList<Integer> gaps = new ArrayList<>();
        for (int i = 1; i < rest.size(); i++) {
            gaps.add(rest.get(i) - rest.get(i - 1));
        }
        int left = 1;
        int right = L;
        int answer = 0;
        while(left <= right){
            // 얼마만큼이 휴게소에서 가장 최대로 있을 수 있는 거리인가를 비교하기 위한 수
            int mid = (left + right) / 2;
            int need = 0;

            for(int gap : gaps){
                // 휴게소 마다의 거리를 중간 값으로 나눴을 때 개수 비교
                // mid는 계속해서 거리를 나타냄
                need += (gap - 1) / mid;
            }
            // 휴개소 갯수가 넘어가게 되면 거리가 늘어나게 끔 범위를 좁힘
            // 거리가 줄어들게 되면 휴개소를 더 많이 짓기때문에
            if(need > M){
                left = mid + 1;
            }
            else{
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
