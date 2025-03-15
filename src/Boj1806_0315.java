import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        int answer = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0];
        int s = input[1];

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int l = 0;
        int r = -1;
        long sum = 0;
        while (r < n - 1) {
            while (sum < s && r < n - 1) {
                sum += arr[++r];
            }
            while (sum >= s && l <= r) {
                answer = Math.min(answer, r - l + 1);
                sum -= arr[l++];
            }
        }
        if (answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
    }
}
