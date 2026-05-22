import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.

        int answer = lcm(n, m);
        System.out.print(answer);
        return;
    }

    public static int lcm(int a, int b){
        return a / gcd(a, b) * b;
    }

    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}