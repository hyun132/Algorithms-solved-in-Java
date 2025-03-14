import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][10]; // i자리수 j로 시작하는 숫자개수
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > 0) dp[i][j - 1] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
                if (j < 9) dp[i][j + 1] = (dp[i][j + 1] + dp[i - 1][j]) % 1000000000;
            }
        }

        long answer = 0;
        for (int i = 1; i < 10; i++) {
            answer = (answer + dp[n][i]) % 1000000000;
        }
        System.out.println(answer);
    }
}
