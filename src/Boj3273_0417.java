import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(br.readLine());
        int answer = 0;
        Arrays.sort(arr);

        int l = 0;
        int r = n-1;
        while (l<r) {
            int sum = arr[l] + arr[r];
            if (sum == x) {
                answer++;
                r--;
                l++;
            } else if (sum < x) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(answer);
    }
}
