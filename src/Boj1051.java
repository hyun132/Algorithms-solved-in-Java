import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ySize = input[0];
        int xSize = input[1];

        char[][] map = new char[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            char[] row = br.readLine().trim().toCharArray();
            for (int x = 0; x < xSize; x++) {
                map[y][x] = row[x];
            }
        }

        int maxLen = 0;
        int cnt;
        for (int y = 0; y < ySize - 1; y++) {
            for (int x = 0; x < xSize - 1; x++) {
                cnt = maxLen + 1;
                while (y + cnt < ySize && x + cnt < xSize && maxLen < Math.min(ySize, xSize)) {
                    if ((map[y][x] == map[y + cnt][x]) && (map[y][x] == map[y][x + cnt]) && (map[y][x] == map[y + cnt][x + cnt])) {
                        maxLen = Math.max(maxLen, cnt);
                        System.out.print(maxLen);
                        System.out.print(x);
                        System.out.println(map[y][x]);
                    }
                    cnt += 1;
                }
            }
        }
        maxLen += 1;
        System.out.println(maxLen * maxLen);

    }
}
