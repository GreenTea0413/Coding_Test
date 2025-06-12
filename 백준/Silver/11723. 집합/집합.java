import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        int[] S = new int[21];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            if(str.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                if(S[num] == 0){
                    S[num] = num;
                }
            }
            if(str.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                if(S[num]!=0){
                    S[num] = 0;
                }
            }
            if(str.equals("check")){
                int num = Integer.parseInt(st.nextToken());
                if(S[num] == num) {
                    sb.append(1).append('\n');
                }
                else{
                    sb.append(0).append('\n');
                }
            }
            if(str.equals("toggle")){
                int num = Integer.parseInt(st.nextToken());
                if(S[num] != 0){
                    S[num] = 0;
                }
                else{
                    S[num] = num;
                }
            }
            if(str.equals("all")){
                S = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};;
            }
            if(str.equals("empty")){
                S = new int[21];
            }
        }
        System.out.println(sb.toString());
    }
}
