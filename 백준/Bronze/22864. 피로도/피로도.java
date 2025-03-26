import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        // 한시간 일하면 
        // A만큼 피로도 ++ 
        // B만큼 처리
        // C만큼 피로도 --
        // 피로도가 음수로 내려가면 0
        // 최대한 M을 넘지말자 M 넘으면 사망
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b= sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();
        int p = 0;
        int ans = 0;
        for(int i = 0; i < 24; i++){
            // 일단 무조건 피로도 추가
            p += a;
            // 피로도가 M보다 크면 쉬어야 하니까 - c
            // 추가했던 피로도 - a 해주기
            if(p > m){
                p = p - a - c;
            }
            // 피로도가 M 보다 작거나 같으면 일처리 한거니까
            else if(p <= m){
                ans += b;
            }
            // 피로도가 음수로 내려가면 0
            if(p < 0){
                p = 0;
            }
        }
        System.out.print(ans);
        sc.close();
    } 
}
