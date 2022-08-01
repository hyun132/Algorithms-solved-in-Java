import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lightsSize = Integer.parseInt(br.readLine().trim());
        int[] lights = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int students = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < students; i++) {
            int[] student = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int idx = student[1] - 1;
            if (student[0] == 1) { // 남 배수
                while (idx < lightsSize) {
                    lights[idx]++;
                    idx += student[1];
                }
            } else if (student[0] == 2) { //여 양쪽
                int diff = 1;
                lights[idx] += 1;
                while (0 <= (idx - diff) && (idx + diff) < lightsSize && (lights[idx - diff]%2 == lights[idx + diff]%2)) {
                    lights[idx - diff]++;
                    lights[idx + diff]++;
                    diff++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lightsSize; i++) {
            sb.append(lights[i] % 2);

            if (i % 20 == 19) sb.append("\n");
            else sb.append(" ");
        }
        System.out.print(sb);
    }
}
