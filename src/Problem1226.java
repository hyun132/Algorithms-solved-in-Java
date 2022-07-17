import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1226 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        int size = 16;
        int sx = 0, sy = 0, ex = 0, ey = 0;
        for (int test_case = 1; test_case <= 10; test_case++) {
            sc.nextInt();
            int input = 0;

            int[][] board = new int[size][size];
            int answer = 0;

            for (int y = 0; y < size; y++) {
                String row = sc.next();
                for (int x = 0; x < size; x++) {
                    input = row.charAt(x) - '0';
                    if (input == 0) continue;
                    else if (input == 2) {
                        sx = x;
                        sy = y;
                    } else if (input == 3) {
                        ex = x;
                        ey = y;
                    }

                    board[y][x] = input;
                }
            }

            // q
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{sy, sx});

            while (queue.size()>0 && answer == 0) {
                int[] position = queue.poll();
                int cury = position[0];
                int curx = position[1];
                for (int i = 0; i < 4; i++) {
                    int y = cury + dy[i];
                    int x = curx + dx[i];

                    if (y == ey && x == ex) {
                        answer = 1;
                        break;
                    }
                    if (0 <= x && x < size && 0 <= y && y < size) {
                        int value = board[y][x];
                        if (value == 0) {
                            board[y][x] = 1;
                            queue.add(new int[]{y, x});
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
