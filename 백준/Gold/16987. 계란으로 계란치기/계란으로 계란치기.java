
import java.io.*;
import java.util.*;


public class Main {
    static int[][] graph;
    static int N;
    static int max = 0;
    public static void main(String[] args) throws IOException{
        // 계란 1의 내구도 7 무게 5
        // 계란 2의 내구도 3 무게 4

        // 1 -> 2  1의 내구도는 7 - 4 = 3 2의 내구도는 3 - 5 = -2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new int[N][2];

        for(int i = 0; i < N; i++){
            // 그래프 만듦과 동시에 값 넣어주기
            st = new StringTokenizer(br.readLine());

            // 내구도 0 무게 1
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
        }  
        dfs(0,0);

        System.out.println(max);
    } 
    public static void dfs(int index, int count){
        // index 위치가 끝에 도달하면 끝
        if(index == N){
            max = Math.max(count,max);
            return;
        }


        // 손에 든 계란이 이미 깨져있으면 끝
        // 그리고 count가 N-1 이라면
        if(graph[index][0] <= 0 || count == N-1){
            dfs(index+1, count);
            return;
        }

        // 이거 count 수 다시 복구할려고 사용
        int nCount = count;
        for(int i =0; i < N; i++){
            // 당연히 깨려는 계란과 같은 위치면 x
            if(index == i) continue;
            // 지금 꺠려고 하는계란이 내구도가 0 이면 다음계란
            if(graph[i][0] <= 0) continue;
            // 계란 깨기
            hitEgg(index, i);
            // 깨기 했는데 하나라도 꺠지면 count++
            if(graph[index][0] <= 0) count ++;
            if(graph[i][0] <= 0) count ++;

            // 이제 다음 계란 도전
            dfs(index + 1, count);
            // 그 다음 다시 i 번째 계란 깬걸 다시 복구
            recoveryEgg(index, i);

            count = nCount;
        }
    }

    static void hitEgg(int left, int right){
        graph[right][0] -= graph[left][1];
        graph[left][0] -= graph[right][1];
    }

    static void recoveryEgg(int left, int right){
        graph[right][0] += graph[left][1];
        graph[left][0] += graph[right][1];
    }
}
