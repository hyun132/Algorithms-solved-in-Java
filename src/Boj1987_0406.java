import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static boolean[] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = rc[0];
        visited = new boolean[26];
        char[][] map = new char[r][];
        for (int i = 0; i < r; i++) {
            char[] c = br.readLine().toCharArray();
            map[i] = c;
        }

        visited[map[0][0]-'A'] = true;
        dfs(map, 0, 0, 1);
        System.out.println(answer);
    }

    static void dfs(char[][] map, int y, int x, int count) {

        answer = Math.max(answer, count);

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length) continue;
            if (visited[map[ny][nx] - 'A']) continue;
            visited[map[ny][nx] - 'A'] = true;
            dfs(map, ny, nx, count + 1);
            visited[map[ny][nx] - 'A'] = false;
        }
    }
}
