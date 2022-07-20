import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Daily2034 {
    public static void main(String[] args) throws IOException {
        // UDRL은 해당방향 -1 만약 1이면 부수고 이동
        // x 는 주변 8개칸중 0아닌만큼 카운트하고 0으로 변경

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine().trim());

        int[][] map = new int[size][size];
        int y = -1, x = -1;
        for (int i = 0; i < size; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < size; j++) {
                map[i][j] = input[j] - '0';
                if (map[i][j] == 0) {
                    y = i;
                    x = j;
                }
            }
        }
        int command = Integer.parseInt(br.readLine());

        int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
        int count = 0;
        for (int i = 0; i < command; i++) {
            String c = br.readLine().trim();

            ArrayList<Integer> list = new ArrayList<Integer>();
            switch (c) {
                case "U":
                    list.add(0);
                    break;
                case "D":
                    list.add(4);
                    break;
                case "L":
                    list.add(6);
                    break;
                case "R":
                    list.add(2);
                    break;
                default:
                    list.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
            }
            int ny, nx;

            for (int d : list) {
                ny = y + dirY[d];
                nx = x + dirX[d];
                if (0 <= ny && 0 <= nx && ny < size && nx < size) {
                    if (list.size() > 2) {
                        if (map[ny][nx] > 0) count++;
                        map[ny][nx] = 0;
                    } else {
                        if (map[ny][nx] <= 1) {
                            y = ny;
                            x = nx;
                            if (map[ny][nx] == 1)count++;
                        }
                        if (map[ny][nx] > 0) map[ny][nx] -= 1;
                    }
                }
            }
        }
        System.out.printf("광부 위치 : (%d,%d)\n", y, x);
        System.out.printf("부순 암석 개수 : %d\n", count);
    }

}
