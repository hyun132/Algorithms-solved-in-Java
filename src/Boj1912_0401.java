import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1],0)+arr[i];
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
