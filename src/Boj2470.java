import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine().trim();
        int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        if (arr[0] >= 0 || arr.length==2) {
            System.out.printf("%d %d", arr[0], arr[1]);
            return;
        }
        if (arr[arr.length - 1] <= 0) {
            System.out.printf("%d %d", arr[arr.length - 2], arr[arr.length - 1]);
            return;
        }

        int left = 1;
        int right = arr.length - 2;
        int answer = Integer.MAX_VALUE;
        int answerA = arr[left - 1];
        int answerB = arr[right + 1];

        while (answer != 0 && left <= right) {
            int a = Math.abs(arr[left - 1] + arr[right]);
            int b = Math.abs(arr[left] + arr[right + 1]);
            int c = Math.abs(arr[left - 1] + arr[right + 1]);

            if (a>c && b>c&& left != right && answer > c) {
                answerA = arr[left - 1];
                answerB = arr[right + 1];
                answer = c;

            } else if (a<b&& a<c&& answer > a) {
                answerA = arr[left - 1];
                answerB = arr[right];
                answer = a;
            } else if (a>b && c>b && answer > b) {
                answerA = arr[left];
                answerB = arr[right + 1];
                answer = b;
            }
            if (Math.abs(a) >= Math.abs(b)) {
                left++;
            }
            if (Math.abs(a) <= Math.abs(b)) {
                right--;
            }
        }

        System.out.printf("%d %d", answerA, answerB);
    }
}
