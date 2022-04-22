import java.io.BufferedInputStream;
import java.util.*;

public class Main {
    // 입력 받기 위한 BufferedReader/Writer 사용
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)  {

        // test_case 입력받기 위한 T 선언 및 초기화
        int test_case = Integer.parseInt(br.readLine());
        int num_N = 0;

        for (int k=0; k < test_case; k++)   {
            num_N = Integer.parseInt(br.readLine());
            phadovan_f(num_N);
        }
    }

    public static void phadovan_f(int num_N) {
        int[] phadovan = new int[num_N];

        phadovan[0] = 1;
        phadovan[1] = 1;
        phadovan[2] = 1;
        phadovan[3] = 2;
        phadovan[4] = 2;
        for (int i = 5; i < test_case; i++) {
            phadovan[i] = phadovan[i-1] + phadovan[i-5];
        }

        bw.write(phadovan[]);
    }
}
