import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 피보나치 0이 호출 횟수
    static int zero_count = 0;
    // 피보나치 1이 호출 횟수
    static int one_count = 0;
    // 입력받을 test_case
    static int test_case = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)  throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test_case = Integer.parseInt(br.readLine());

        // 재귀는 DP 상 제한 조건에 충돌나기 때문에 반복문으로 수행
        for (int i=0; i < test_case; i++)   {
            fibonacci(Integer.parseInt(br.readLine()));
            sb.append(zero_count).append(" ").append(one_count).append("\n");
            zero_count = 0; one_count = 0;
        }
        System.out.println(sb);
    }

    // 피보나치 수열 구현
    public static void fibonacci(int n) {
        int temp1 = 0;
        int temp2 = 1;
        int temp = 0;

        // 0과 1일 때의 예외처리 진행
        if (n==0)   {
            zero_count++;
            return;
        }
        else if (n==1)  {
            one_count++;
            return;
        }
        else if (n<0)
            return;
        // 예외 처리 후 피보나치 연산 수행
        // 피보나치 계산이 제대로 수행되려면 2부터 의미가 있다
        else {
            for (int i = 1; i < n; i++) {
                temp = temp1 + temp2;
                temp1 = temp2;
                temp2 = temp;
            }
            zero_count = temp1;
            one_count = temp2;
        }
    }
}

// 참고 https://infodon.tistory.com/65