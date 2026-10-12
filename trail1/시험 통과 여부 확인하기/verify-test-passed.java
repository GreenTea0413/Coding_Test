import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N >= 80)  System.out.print("pass");
        else {
            N = 80 - N;
            System.out.println(N + " more score");
        }
    }
}