
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static String result = "";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int r = 5;
        int c = N / r;

//        System.out.println("r = " + r);
//        System.out.println("c = " + c);

        String st = br.readLine();
        String[][] signal = new String[r][c];

        int k=0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                signal[i][j] = String.valueOf(st.charAt(k));
                k++;
            }
        }


        for (int i = 0; i < c; i++) {
            if (signal[0][i].equals("#")) {
                if (i == c - 1 ) {
                    result += "1";
                    continue;
                }
                if (!signal[0][i + 1].equals("#")) {
                    // 0또는 4 (다음 열이 #이 아님)
                    if (signal[3][i].equals("#")) {
                        // 3행이 #이므로 암호는 1
                        result += "1";
                    } else {
                        result += "4";
                        i += 3;
                    }
                } else {
                    // 0,4 제외
                    if (signal[1][i].equals("#") && signal[1][i + 2].equals("#")) {
                        check_0_8_9(i, signal);
                    } else if (!signal[1][i].equals("#") && signal[1][i + 2].equals("#")) {
                        check_2_3_7(i, signal);
                    } else {
                        check_5_6(i, signal);
                    }
                    i += 3;
                }
            }
        }

        System.out.println(result);
    }

    static public void check_0_8_9(int i, String[][] signal) {
        if (!signal[2][i + 1].equals("#")) {
            result += "0";
        } else {
            if (signal[3][i].equals("#")) {
                result += "8";
            } else {
                result += "9";
            }
        }
    }

    static public void check_2_3_7(int i, String[][] signal) {
        if (!signal[2][i].equals("#")) {
            result += "7";
        } else {
            if (signal[3][i].equals("#")) {
                result += "2";
            } else {
                result += "3";
            }
        }
    }

    static public void check_5_6(int i, String[][] signal) {
        if (!signal[3][i].equals("#")) {
            result += "5";
        } else {
            result += "6";
        }
    }
}