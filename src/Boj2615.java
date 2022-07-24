import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2615 {
    public static void main(String[] args) throws IOException {
        //1043
        // 만약 돌을 만나면 8방향 검색을 한다
        // 만약 해당 방향에 돌이 있으면 그 방향으로 계속 좌표를 옮기며 돌의 개수를 센다.
        //만약 5개가 아니라면 나머지 방향을 탐색한다.
        //그 위치에서 승부를 확인할 수 없으면 방문한 곳의 돌을 지운다.
        //visit 처리는 4방향만 하면 되기 때문에 비트 1 1 1 1 네 자리로 표기한다.
        //우, 우하, 하, 좌하 순으로 탐색한다.

        int[] dirY = {0, 1, 1, 1};
        int[] dirX = {1, 1, 0, -1};
        int size = 19;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][][] map = new int[size][size][2];
        String[] row;
        for (int i = 0; i < size; i++) {
            row = br.readLine().trim().split(" ");
            for (int j = 0; j < size; j++) {
                map[i][j][0] = Integer.parseInt(row[j]);
            }
        }

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (map[y][x][0] == 0) continue;
                for (int d = 0; d < 4; d++) {
                    if ((map[y][x][1] & 1 << d) == 1 << d) continue;
                    int cnt = 1;
                    int ny = y + dirY[d];
                    int nx = x + dirX[d];
                    while (0 <= ny && ny < size && 0 <= nx && nx < size && (map[y][x][0] == map[ny][nx][0] && cnt < 6)) {
                        map[ny][nx][1] += 1 << d;
                        cnt++;
                        ny += dirY[d];
                        nx += dirX[d];
                    }
                    if (cnt == 5) {
                        System.out.println(map[y][x][0]);
                        if (d == 3) {
                            x -= 4;
                            y += 4;
                        }
                        System.out.println((y + 1) + " " + (x + 1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
