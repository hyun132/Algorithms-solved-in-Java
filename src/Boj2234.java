
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] map = new int[y][x];

        int answer = 0;

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> dq = new ArrayDeque<>();

        int[] dirY = {0, -1, 0, 1};
        int[] dirX = {-1, 0, 1, 0};
        int ny, nx, cy, cx;
        HashMap<Integer, Integer> roomSizeMap = new HashMap<>();

        int roomNo = 16;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int roomSize = 0; // 방 크기 큰거 저장하려고
                if (map[i][j] >= 15) {
                    if (map[i][j] == 15) {
                        roomSizeMap.put(roomNo, 1);
                        map[i][j] = roomNo++;
                        answer = 1;
                    }
                    continue;
                }

                dq.add(i * x + j);
                while (!dq.isEmpty()) {
                    cy = dq.peek() / x;
                    cx = dq.poll() % x;

                    ++roomSize;
                    for (int s = 0; s < 4; s++) {
                        int dir = map[cy][cx] & (1 << s);
                        if (dir != 0) continue;
                        ny = cy + dirY[s];
                        nx = cx + dirX[s];
                        if (0 <= ny && ny < y && 0 <= nx && nx < x && map[ny][nx] < 15 && !dq.contains(x * ny + nx)) {
                            dq.add(x * ny + nx);
                        }
                    }
                    map[cy][cx] = roomNo;
                }
                roomSizeMap.put(roomNo++, roomSize);
            }
        }

        answer = Math.max(answer,Collections.max(roomSizeMap.values()));
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(i>0 && map[i-1][j] != map[i][j]) answer = Math.max(answer, roomSizeMap.get(map[i-1][j]) + roomSizeMap.get(map[i][j]));
                if(j>0&& map[i][j-1] != map[i][j]) answer = Math.max(answer, roomSizeMap.get(map[i][j-1]) + roomSizeMap.get(map[i][j]));
            }
        }

        System.out.println(roomSizeMap.size());
        System.out.println(Collections.max(roomSizeMap.values()));
        System.out.println(answer);
    }
}
