import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1767 {

    static int[][] map;
    static int minLength = Integer.MAX_VALUE;
    static int maxChips = 0;
    static ArrayList<int[]> chipsArr = new ArrayList<>();
    static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine().trim());
            size = Integer.parseInt(st.nextToken());
            maxChips = 0;
            minLength = Integer.MAX_VALUE;
            chipsArr.clear();

            map = new int[size][size];

            for (int i = 0; i < size; i++) {
                map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

                for (int j = 1; j < size - 1; j++) {
                    if(i==0||i==size-1)continue;
                    if (map[i][j] == 1) chipsArr.add(new int[]{i, j});
                }
            }
            //부분집합으로 가능한 모든 경우를 찾는다.
            findCase(0, 0, 0);

            sb.append(minLength).append("\n");

        }
        System.out.print(sb.toString());
    }

    private static void findCase(int cnt, int start, int sum) {
//        if (start == chipsArr.size()) return;
        if (maxChips>0 && chipsArr.size() - start < maxChips - cnt) return;

        //만약 더 좋은 선택지가 있으면 값 갱신
        if (start == chipsArr.size()) {
            if (maxChips < cnt) {
                maxChips = cnt;
                minLength = sum;
            } else if (cnt > 0 && maxChips <= cnt && minLength > sum) {
                minLength = sum;
                maxChips = cnt;
            }
            return;
        }


        for (int i = 0; i < 4; i++) {
            int len = tryNewCase(chipsArr.get(start), i, cnt);
            if (len > 0) {
                findCase(cnt + 1, start + 1, sum + len);
                revert(chipsArr.get(start), i, len);
            }
        }
        findCase(cnt, start + 1, sum);
    }

    private static int tryNewCase(int[] ints, int dir, int n) {
        int y = ints[0] + dirs[dir][0];
        int x = ints[1] + dirs[dir][1];

        int cnt = 0;
        while (!check(y, x) && map[y][x] == 0) {
            map[y][x] = n + 2;
            y += dirs[dir][0];
            x += dirs[dir][1];
            cnt += 1;
        }
        if (check(y,x)) return cnt;
        y = ints[0] + dirs[dir][0];
        x = ints[1] + dirs[dir][1];

        while (cnt > 0) {
            cnt--;
            map[y][x] = 0;
            y += dirs[dir][0];
            x += dirs[dir][1];
        }

        return 0;
    }

    public static void revert(int[] ints, int dir, int cnt) {
        int y = ints[0] + dirs[dir][0];
        int x = ints[1] + dirs[dir][1];

        while (cnt > 0) {
            map[y][x] = 0;
            y += dirs[dir][0];
            x += dirs[dir][1];
            cnt--;
        }
    }

    public static boolean check(int y, int x) {
        return y < 0 || x < 0 || y >= size || x >= size;
    }
}
