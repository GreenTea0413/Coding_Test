import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        int a = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int num = a % 9 + 1;
                sb.append(num).append(" ");
                a++;
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
        return;
    }
}