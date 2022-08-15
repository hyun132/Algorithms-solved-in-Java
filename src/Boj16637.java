import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj16637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine().trim());

        int[] maxVal = new int[size];
        int[] minVal = new int[size];

        if (size == 1) {
            System.out.println(Integer.parseInt(br.readLine().trim()));
            return;
        }
        char[] arr = br.readLine().trim().toCharArray();
        maxVal[0] = arr[0] - '0';
        minVal[0] = arr[0] - '0';

        for (int i = 1; i < size; i += 2) {
            int right = arr[i + 1] - '0';
            maxVal[i + 1] = Math.max(calc(maxVal[i - 1], arr[i], right), calc(minVal[i - 1], arr[i], right));
            minVal[i + 1] = Math.min(calc(maxVal[i - 1], arr[i], right), calc(minVal[i - 1], arr[i], right));
            if (i < 2) {
                continue;
            }
            int cur = calc(arr[i - 1] - '0', arr[i], right); // a x b
            int lastMax = calc(maxVal[i - 3], arr[i - 2], cur); // a + (b x c)
            int lastMin = calc(minVal[i - 3], arr[i - 2], cur); // a + (b x c)
            maxVal[i + 1] = Math.max(maxVal[i + 1], Math.max(lastMin, lastMax));
            minVal[i + 1] = Math.min(minVal[i + 1], Math.min(lastMin, lastMax));
        }
        System.out.println(Math.max(minVal[size - 1],maxVal[size - 1]));
    }

    public static int calc(int a, char oper, int b) {

        int answer = 0;
        if (oper == '+') {
            answer = a + b;
        } else if (oper == '-') {
            answer = a - b;
        } else if (oper == '*') {
            answer = a * b;
        }
        return answer;
    }
}
