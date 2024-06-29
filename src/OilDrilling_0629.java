import java.util.*;

class OilDrilling_0629 {
    private int[] dy = {1, 0, -1, 0};
    private int[] dx = {0, 1, 0, -1};
    private Map<Integer, Integer> groupSize = new HashMap<>();
    private Map<Integer, Set<Integer>> groupXIndex = new HashMap<>();
    private int no = 2;
    private int ySize = 0;
    private int xSize = 0;
    private int[][] map;

    public int solution(int[][] land) {
        map = land;
        ySize = land.length;
        xSize = land[0].length;

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (land[y][x] == 1) {
                    bfs(y, x, no++);
                }
            }
        }

        int answer = 0;
        for (int key : groupXIndex.keySet()) {
            int sum = 0;
            for (int v : groupXIndex.get(key)) {
                sum += groupSize.getOrDefault(v, 0);
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    private void bfs(int sy, int sx, int no) {
        Deque<Point> q = new LinkedList<>();
        q.add(new Point(sy, sx));
        int qSize = q.size();
        int amount = 0;
        map[sy][sx] = no;
        if (!groupXIndex.containsKey(sx)) {
            groupXIndex.put(sx, new HashSet<>());
        }
        groupXIndex.get(sx).add(no);
        while (!q.isEmpty()) {
            Point cur = q.pollFirst();
            amount += 1;
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < ySize && ny >= 0 && nx < xSize && nx >= 0) {
                    if (map[ny][nx] == 1) {
                        if (!groupXIndex.containsKey(nx)) {
                            groupXIndex.put(nx, new HashSet<>());
                        }
                        map[ny][nx] = no;
                        groupXIndex.get(nx).add(no);
                        q.add(new Point(ny, nx));
                    }
                }
            }
        }
        groupSize.put(no, amount);
    }

    private static class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
