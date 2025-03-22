import java.util.Scanner;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int output[] = new int[n];
        boolean visited[] = new boolean[n];
        
        permutation(output, visited, 0, n);
    }

    public static void permutation(int output[], boolean visited[], int depth, int r){
        if(depth == r){
            for(int i = 0; i < r; i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
        }
        // 15649에서는 숫자 2개받아서 자릿수 정해서 했는데 이번엔 그냥 수만큼 하면 됨
        // 범위 주어진대로 하면 바로 완성
        for (int i =0; i < r; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = i + 1;
                permutation(output, visited, depth + 1, r);
                visited[i]= false;
            }
        }
        
    }
}