import java.util.*;

public class Main {
    static int N, answer = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(0, 0);
        System.out.print(answer);
    }
    
    static void dfs(int cur, int num) {
        if(cur == N) {
            answer++;
            return;
        }
        if(cur > N) return;
        
        for(int i = 1; i <= 4; i++) {
            dfs(cur + i, i); 
        }
    }
    
}