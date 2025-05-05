import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        int[] sumArr = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (i == 0) sumArr[i] = nums[i];
            if (i == 1) sumArr[i] = nums[i - 1] + nums[i];
            if (i > 1)
                sumArr[i] = Math.max(Math.max(sumArr[i - 2] + nums[i], nums[i - 1] + nums[i]), sumArr[i - 1]);
            if (i > 2) sumArr[i] = Math.max(sumArr[i], sumArr[i - 3] + nums[i - 1] + nums[i]);

            answer = Math.max(answer, sumArr[i]);
        }

        System.out.println(answer);
    }
}
