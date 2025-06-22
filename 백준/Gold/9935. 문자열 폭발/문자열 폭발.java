import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        int len = bomb.length();
        // 폭탄 길이만큼 비교하면 되려나?
        // 그러면 그랬을 때 이제 문자열을 어떻게 계속 이어가냐..
        
        // 아니면 문자열 위치 찾기
        // 그 다음 위치에서 substring 써서 폭탄 길이만큼 비교 다해서 맞으면 넣고 아니면 없애기
        // 아니 나 천잰가? 딱 포함하고 있으면 반복하고 그 위치 잘라서 없애주고
        // 반복해서 다 없애면 반복 멈추니까
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (sb.length() >= bomb.length()) {
                boolean match = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (sb.charAt(sb.length() - bomb.length() + j) != bomb.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                // 일치하면 범위만큼 삭제
                if (match) {
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }
        if(sb.length() < 1){
            System.out.println("FRULA");
        }
        else{
            System.out.println(sb.toString());
        }
    }
}
